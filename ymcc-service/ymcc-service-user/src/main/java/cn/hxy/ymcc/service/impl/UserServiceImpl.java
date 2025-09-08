package cn.hxy.ymcc.service.impl;

import cn.hxy.ymcc.api.LoginFeignAPI;
import cn.hxy.ymcc.constants.BusinessConstants;
import cn.hxy.ymcc.domain.Login;
import cn.hxy.ymcc.domain.User;
import cn.hxy.ymcc.domain.UserAccount;
import cn.hxy.ymcc.domain.UserBaseInfo;
import cn.hxy.ymcc.dto.CodeDto;
import cn.hxy.ymcc.dto.RegisterParamsDto;
import cn.hxy.ymcc.exception.GlobleBusinessException;
import cn.hxy.ymcc.mapper.UserMapper;
import cn.hxy.ymcc.result.JSONResult;
import cn.hxy.ymcc.service.IUserAccountService;
import cn.hxy.ymcc.service.IUserBaseInfoService;
import cn.hxy.ymcc.service.IUserService;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hxy
 * @since 2025-08-29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;
    @Autowired
    private LoginFeignAPI loginFeignAPI;
    @Autowired
    private IUserAccountService userAccountService;
    @Autowired
    private IUserBaseInfoService userBaseInfoService;
    @Override
    public void phoneRegister(RegisterParamsDto registerParamsDto) {

        String phone = registerParamsDto.getMobile();
        String smsCode = registerParamsDto.getSmsCode();
        String password = registerParamsDto.getPassword();
        Integer regChannel = registerParamsDto.getRegChannel();
        //1.校验
        if (phone == null || smsCode == null || password == null || regChannel == null) {
            throw new GlobleBusinessException("参数不能为空");
        }
        //2.校验短信验证码
      String key =  BusinessConstants.PHONE_REGISTER + phone;
        Object obj = redisTemplate.opsForValue().get(key);
        if (obj == null) {
            throw new GlobleBusinessException("短信验证码过期,请重新发送");
        }
        //3.校验短信验证码是否正确
        CodeDto value = (CodeDto) obj;
        if(!value.getCode().equals(smsCode)){
            throw new GlobleBusinessException("短信验证码错误");
        }
        //4.校验手机号是否已注册
        Wrapper<User> www = new EntityWrapper<>();
        www.eq("phone", phone);
        User userDB = selectOne(www);
        if (userDB != null) {//
            throw new GlobleBusinessException("手机号已注册");
        }

        //5.注册t_user,t_user_account,t_user_base_info,t_login

        //先添加t_login表   返回自增login_id
        Login login = new Login();
        login.setUsername(phone);
        login.setPassword(password);
        login.setType(1);
        login.setEnabled(true);
        login.setAccountNonExpired(true);
        login.setCredentialsNonExpired(true);
        login.setAccountNonLocked(true);
        JSONResult jsonResult = loginFeignAPI.saveRegister(login);
        Object data = jsonResult.getData();
        String jsonString = JSONObject.toJSONString(data);
        Login loginFromDB = JSONObject.parseObject(jsonString,Login.class);
        Long login_id = loginFromDB.getId();
        User user = new User();
        long nowTime = new Date().getTime();
        user.setCreateTime(nowTime);
        user.setUpdateTime(nowTime);
        user.setPhone(phone);
        user.setNickName(phone);
        user.setBitState(0L);
        user.setSecLevel(0);
        user.setLoginId(login_id);
        insert(user);

        //添加t_user_account表
        UserAccount userAccount = new UserAccount();
        userAccount.setId(user.getId());
        userAccount.setUsableAmount(new BigDecimal(0));
        userAccount.setFrozenAmount(new BigDecimal(0));
        userAccount.setCreateTime(nowTime);
        userAccount.setUpdateTime(nowTime);
        userAccountService.insert(userAccount);

        //添加t_user_base_info表
        UserBaseInfo userBaseInfo = new UserBaseInfo();
        userBaseInfo.setCreateTime(nowTime);
        userBaseInfo.setUpdateTime(nowTime);
        userBaseInfo.setId(user.getId());
        userBaseInfo.setRegChannel(regChannel);
        userBaseInfoService.insert(userBaseInfo);
        //删除redis中的短信验证码
        redisTemplate.delete(key);
    }
}

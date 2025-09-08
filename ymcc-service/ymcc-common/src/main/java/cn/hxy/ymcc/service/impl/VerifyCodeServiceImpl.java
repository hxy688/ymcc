package cn.hxy.ymcc.service.impl;

import cn.hxy.ymcc.constants.BusinessConstants;
import cn.hxy.ymcc.dto.CodeDto;
import cn.hxy.ymcc.exception.GlobleBusinessException;
import cn.hxy.ymcc.service.VerifyCodeService;
import cn.hxy.ymcc.util.SendSmsUtil;
import cn.hxy.ymcc.util.VerifyCodeUtils;
import com.sun.org.apache.bcel.internal.classfile.Code;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;
@Slf4j
@Service
public class VerifyCodeServiceImpl implements VerifyCodeService {
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;
    @Override
    public void sendSmsCode(String phone) {
        //key
        String key = BusinessConstants.PHONE_REGISTER +phone;
        // 1.校验
        if (StringUtils.isEmpty(phone)){
            throw new GlobleBusinessException("手机号不能为空");
        }
        // 2.从redis中查询code
        Object obj = redisTemplate.opsForValue().get(key);
        CodeDto value = null;
        if (obj!=null){
            value= (CodeDto) obj;
            String code = value.getCode();
            //判断是否超过一分钟
            if (new Date().getTime()-value.getTimer()<60000){
                throw new GlobleBusinessException("一分钟内不能重复发送");
            }//如果超过一分钟,则发送验证码,并且刷新过期时间
        }else {
            //3.redis有验证码
            //判断是否超过一分钟,如果没超过一分钟,提示用户一分钟内不允许重复发送
            //如果超过一分钟,则发送验证码,并且刷新过期时间
            //4.redis没有验证码
            //生成验证码,发送验证码,并且刷新过期时间
            String code = VerifyCodeUtils.generateVerifyCode(4);
            //value
            long timer = new Date().getTime();
            //这个就是验证码和时间戳的封装类Value
            value = new CodeDto(code, timer);
            //存入redis
        }
        log.info("您的验证码为:{},请再{}分钟内使用",value.getCode(),5);
        //发送短信
//      SendSmsUtil.sendSms(phone,value.getCode());
        redisTemplate.opsForValue().set(key, value, 5, TimeUnit.MINUTES);

    }
}

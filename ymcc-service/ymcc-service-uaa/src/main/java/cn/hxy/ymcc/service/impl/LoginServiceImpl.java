package cn.hxy.ymcc.service.impl;

import cn.hxy.ymcc.domain.Login;
import cn.hxy.ymcc.mapper.LoginMapper;
import cn.hxy.ymcc.service.ILoginService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 登录表 服务实现类
 * </p>
 *
 * @author hxy
 * @since 2025-08-29
 */
@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, Login> implements ILoginService {

}

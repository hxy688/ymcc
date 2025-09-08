package cn.hxy.ymcc.service.impl;

import cn.hxy.ymcc.domain.LoginLog;
import cn.hxy.ymcc.mapper.LoginLogMapper;
import cn.hxy.ymcc.service.ILoginLogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 登录记录 服务实现类
 * </p>
 *
 * @author hxy
 * @since 2025-08-29
 */
@Service
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog> implements ILoginLogService {

}

package cn.hxy.ymcc.service;

import cn.hxy.ymcc.domain.User;
import cn.hxy.ymcc.dto.RegisterParamsDto;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 会员登录账号 服务类
 * </p>
 *
 * @author hxy
 * @since 2025-08-29
 */
public interface IUserService extends IService<User> {

    void phoneRegister(RegisterParamsDto registerParamsDto);
}

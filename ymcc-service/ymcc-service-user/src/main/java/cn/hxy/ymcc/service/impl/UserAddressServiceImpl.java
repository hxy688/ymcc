package cn.hxy.ymcc.service.impl;

import cn.hxy.ymcc.domain.UserAddress;
import cn.hxy.ymcc.mapper.UserAddressMapper;
import cn.hxy.ymcc.service.IUserAddressService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 收货地址 服务实现类
 * </p>
 *
 * @author hxy
 * @since 2025-08-29
 */
@Service
public class UserAddressServiceImpl extends ServiceImpl<UserAddressMapper, UserAddress> implements IUserAddressService {

}

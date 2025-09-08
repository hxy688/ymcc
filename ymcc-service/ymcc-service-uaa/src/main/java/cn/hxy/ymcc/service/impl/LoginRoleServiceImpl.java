package cn.hxy.ymcc.service.impl;

import cn.hxy.ymcc.domain.LoginRole;
import cn.hxy.ymcc.mapper.LoginRoleMapper;
import cn.hxy.ymcc.service.ILoginRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户和角色中间表 服务实现类
 * </p>
 *
 * @author hxy
 * @since 2025-08-29
 */
@Service
public class LoginRoleServiceImpl extends ServiceImpl<LoginRoleMapper, LoginRole> implements ILoginRoleService {

}

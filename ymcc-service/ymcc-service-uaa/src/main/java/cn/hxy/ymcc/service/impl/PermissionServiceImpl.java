package cn.hxy.ymcc.service.impl;

import cn.hxy.ymcc.domain.Permission;
import cn.hxy.ymcc.mapper.PermissionMapper;
import cn.hxy.ymcc.service.IPermissionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author hxy
 * @since 2025-08-29
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

}

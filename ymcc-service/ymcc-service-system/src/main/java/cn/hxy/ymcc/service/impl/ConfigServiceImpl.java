package cn.hxy.ymcc.service.impl;

import cn.hxy.ymcc.domain.Config;
import cn.hxy.ymcc.mapper.ConfigMapper;
import cn.hxy.ymcc.service.IConfigService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 参数配置表 服务实现类
 * </p>
 *
 * @author whale
 * @since 2025-08-28
 */
@Service
public class ConfigServiceImpl extends ServiceImpl<ConfigMapper, Config> implements IConfigService {

}

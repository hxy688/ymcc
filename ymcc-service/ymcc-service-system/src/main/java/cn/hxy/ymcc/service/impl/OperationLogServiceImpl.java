package cn.hxy.ymcc.service.impl;

import cn.hxy.ymcc.domain.OperationLog;
import cn.hxy.ymcc.mapper.OperationLogMapper;
import cn.hxy.ymcc.service.IOperationLogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 操作日志记录 服务实现类
 * </p>
 *
 * @author whale
 * @since 2025-08-28
 */
@Service
public class OperationLogServiceImpl extends ServiceImpl<OperationLogMapper, OperationLog> implements IOperationLogService {

}

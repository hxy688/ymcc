package cn.hxy.ymcc.service.impl;

import cn.hxy.ymcc.domain.Employee;
import cn.hxy.ymcc.mapper.EmployeeMapper;
import cn.hxy.ymcc.query.EmployeeQuery;
import cn.hxy.ymcc.service.IEmployeeService;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author whale
 * @since 2025-08-28
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {
}

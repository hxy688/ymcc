package cn.hxy.ymcc.web.controller;

import cn.hxy.ymcc.service.IDepartmentService;
import cn.hxy.ymcc.domain.Department;
import cn.hxy.ymcc.query.DepartmentQuery;
import cn.hxy.ymcc.result.JSONResult;
import cn.hxy.ymcc.result.PageList;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    public IDepartmentService departmentService;

    /**
     * 保存和修改公用的
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public JSONResult saveOrUpdate(@RequestBody Department department) {
        if (department.getId() != null) {
            departmentService.updateById(department);
        } else {
            departmentService.insert(department);
        }
        return JSONResult.success();
    }

    /**
     * 删除对象
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public JSONResult delete(@PathVariable("id") Long id) {
        departmentService.deleteById(id);
        return JSONResult.success();
    }

    /**
     * 获取对象
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public JSONResult get(@PathVariable("id") Long id) {
        return JSONResult.success(departmentService.selectById(id));
    }


    /**
     * 查询所有对象
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public JSONResult list() {
        return JSONResult.success(departmentService.selectList(null));
    }


    /**
     * 带条件分页查询数据
     */
    @RequestMapping(value = "/pagelist", method = RequestMethod.POST)
    public JSONResult page(@RequestBody DepartmentQuery query) {
        Page<Department> page = new Page<Department>(query.getPage(), query.getRows());
        if (query.getKeyword() != null) {
            page = departmentService.selectPage(page, new Wrapper<Department>() {
                @Override
                public String getSqlSegment() {
                    return "where name like '%" + query.getKeyword() + "%'";
                }
            });
        } else {
            page = departmentService.selectPage(page);

        }
        return JSONResult.success(new PageList<Department>(page.getTotal(), page.getRecords()));
    }
}

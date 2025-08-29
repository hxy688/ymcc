package cn.hxy.ymcc.web.controller;

import cn.hxy.ymcc.service.IEmployeeService;
import cn.hxy.ymcc.domain.Employee;
import cn.hxy.ymcc.query.EmployeeQuery;
import cn.hxy.ymcc.result.JSONResult;
import cn.hxy.ymcc.result.PageList;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    public IEmployeeService employeeService;

    /**
    * 保存和修改公用的
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public JSONResult saveOrUpdate(@RequestBody Employee employee){
        if(employee.getId()!=null){
            employeeService.updateById(employee);
        }else{
            employeeService.insert(employee);
        }
        return JSONResult.success();
    }

    /**
    * 删除对象
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public JSONResult delete(@PathVariable("id") Long id){
        employeeService.deleteById(id);
        return JSONResult.success();
    }

    /**
   * 获取对象
   */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public JSONResult get(@PathVariable("id")Long id){
        return JSONResult.success(employeeService.selectById(id));
    }


    /**
    * 查询所有对象
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public JSONResult list(){
        return JSONResult.success(employeeService.selectList(null));
    }


    /**
    * 带条件分页查询数据
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public JSONResult page(@RequestBody EmployeeQuery query){
        Page<Employee> page = new Page<Employee>(query.getPage(),query.getRows());//当前页，每页多少条记录
        //分页查询

        if (query.getKeyword()!=null){
            page =employeeService.selectPage(page, new Wrapper<Employee>() {
                @Override
                public String getSqlSegment() {
                    return "where real_name like '%"+query.getKeyword()+"%'";
                }
            });
        }
        else {
            page = employeeService.selectPage(page);
        }

        return JSONResult.success(new PageList<Employee>(page.getTotal(),page.getRecords()));
    }
}

package cn.hxy.ymcc.api;

import cn.hxy.ymcc.domain.Login;
import cn.hxy.ymcc.result.JSONResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//接口服务名称
@FeignClient("service-uaa")
public interface LoginFeignAPI {
    @RequestMapping(value="/login/register",method= RequestMethod.POST)
    JSONResult saveRegister(@RequestBody Login login);
}

package cn.hxy.ymcc.exception;

import cn.hxy.ymcc.constants.ErrorCode;
import cn.hxy.ymcc.result.JSONResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

/*
* 全局异常处理类
* */
@RestControllerAdvice
public class GlobleExceptionHandler {

    //拦截异常 : 这个注解就可以拦截器 GlobleException 异常
    @ExceptionHandler(GlobleBusinessException.class)
    public JSONResult globleException(GlobleBusinessException e){
        e.printStackTrace();
        return JSONResult.error(e.getMessage());
        
    }


    //拦截器其他异常
    @ExceptionHandler(Exception.class)
    public JSONResult exception(Exception e){
        e.printStackTrace();
        return JSONResult.error(ErrorCode.NETWORK_ERROR);
    }


    //拦截器其他异常
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public JSONResult methodArgumentNotValidException(MethodArgumentNotValidException e){
        e.printStackTrace();
//        System.out.println(e.getBindingResult().getAllErrors()
//                .stream().map(error -> error.getDefaultMessage()).collect(Collectors.toList()));
        return JSONResult.error(e.getBindingResult().getAllErrors());
    }

}
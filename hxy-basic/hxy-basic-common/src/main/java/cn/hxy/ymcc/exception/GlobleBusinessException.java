package cn.hxy.ymcc.exception;
/*
* 自定义业务异常类
* */
public class GlobleBusinessException extends RuntimeException{
    public GlobleBusinessException(String message) {
        super(message);
    }
    public GlobleBusinessException() {
    }
}

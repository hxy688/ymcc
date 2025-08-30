package cn.hxy.ymcc.service.impl;

import cn.hxy.ymcc.service.VerifyCodeService;
import org.springframework.stereotype.Service;

@Service
public class VerifyCodeServiceImpl implements VerifyCodeService {
    @Override
    public void sendSmsCode(String phone) {
        //  TODO: 发送短信验证码
    }
}

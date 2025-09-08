package cn.hxy.ymcc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterParamsDto {

    // 手机号
   private String mobile;
    // 密码
   private String password;
   // 注册渠道
   private Integer regChannel;
  // 短信验证码
   private String smsCode;

}

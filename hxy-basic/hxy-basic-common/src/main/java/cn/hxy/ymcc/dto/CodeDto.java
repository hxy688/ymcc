package cn.hxy.ymcc.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
* 封装验证码和时间戳的
* */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CodeDto {
    private String code;
    private Long timer;
}

package cn.hxy.ymcc.constants;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
* 错误码
* */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorCode {
    NETWORK_ERROR("10000","网络异常,请稍后重试"),
    SUCCESS("200","成功"),
    ERROR("500","失败"),
    USER_NOT_EXIST("10001","用户不存在"),
    USER_PASSWORD_ERROR("10002","用户密码错误"),
    USER_NOT_LOGIN("10003","用户未登录"),
    USER_NOT_AUTH("10004","用户未授权"),
    USER_NOT_PERMISSION("10005","用户无权限"),
    USER_NOT_ROLE("10006","用户无角色"),
    USER_NOT_MENU("10007","用户无菜单"),
    USER_NOT_BUTTON("10008","用户无按钮"),
    USER_NOT_DATA_SCOPE("10009","用户无数据权限"),
    USER_NOT_ORGANIZATION("10010","用户无组织机构");
    private String code;
    private String message;
}

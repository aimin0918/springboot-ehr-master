package cn.timelost.hr.enums;

import lombok.Getter;


@Getter
public enum ResultEnum {
    SUCCESS(200, "成功"),
    DEPARTMENT_NOT_EXIST(10, "部门未找到"),
    POSITION_NOT_EXIST(11, "岗位未找到"),
    PERSONAL_NOT_EXIST(12, "员工未找到"),
    PERSONAL_TRAIN_NOT_EXIST(13, "员工培训记录未找到"),
    PERSONAL_REWARD_NOT_EXIST(14, "员工奖惩记录未找到"),
    PERSONAL_SALARY_NOT_EXIST(15, "员工薪资记录未找到"),
    RECRUIT_NOT_EXIST(16, "招聘记录未找到"),

    USER_NOT_EXIST(20, "用户不存在"),
    PASSWORD_FAIL(21, "用户名或密码错误"),
    CODE_NOT_EXIST(22, "请输入验证码"),
    CODE_FAIL(23, "验证码错误"),

    UPLOAD_FAIL(50, "服务器上传失败"),
    UPLOAD_NOT_ENABLE(51, "上传配置未开启"),
    AUTHENTICATE_FAIL(5000, "认证异常,请重新登录"),
    AUTHORIZATION_FAIL(5001, "用户无权限"),
    ERROR(500, "未知错误"),
    PARAM_ERROR(501, "参数错误");

    private final Integer code;
    private final String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

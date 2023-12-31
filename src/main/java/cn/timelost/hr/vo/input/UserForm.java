package cn.timelost.hr.vo.input;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;


@Data
public class UserForm {

    @NotBlank(message = "用户名必填")
    private String username;

    @NotBlank(message = "密码必填")
    private String password;

    private Integer roleId;
    private String code;
    private String timestamp;
}
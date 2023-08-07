package cn.timelost.hr.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private Integer id;

    private String username;

    private String password;

    private String salt;

    private Integer roleId;

    private static final long serialVersionUID = 1L;
}
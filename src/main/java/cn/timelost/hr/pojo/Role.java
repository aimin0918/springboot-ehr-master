package cn.timelost.hr.pojo;

import java.io.Serializable;
import lombok.Data;


@Data
public class Role implements Serializable {

    private Integer id;

    private String name;

    private String description;

    private Integer permissionId;

    private static final long serialVersionUID = 1L;
}
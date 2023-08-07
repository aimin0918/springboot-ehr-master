package cn.timelost.hr.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;


@Data
public class Personal implements Serializable {

    private Integer id;

    private String name;

    private Integer gender;

    private Date birthday;

    private Long phone;

    private String email;

    private Long identity;

    private String education;

    private String school;

    private String imgUrl;

    private Integer workStatus;

    private Integer departmentId;

    private Integer positionId;

    private Date beginDate;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}
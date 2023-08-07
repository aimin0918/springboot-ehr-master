package cn.timelost.hr.pojo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class Department implements Serializable {

    private Integer id;

    private String departmentName;

    private String description;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}
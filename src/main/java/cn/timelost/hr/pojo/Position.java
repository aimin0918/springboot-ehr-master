package cn.timelost.hr.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;


@Data
public class Position implements Serializable {

    private Integer id;

    private String positionName;

    private String description;

    private Integer departmentId;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}
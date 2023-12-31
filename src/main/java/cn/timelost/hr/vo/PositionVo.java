package cn.timelost.hr.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
public class PositionVo implements Serializable {

    private static final long serialVersionUID = 7968167691662644209L;
    private Integer id;
    private String positionName;
    private String description;
    private Integer departmentId;
    private String departmentName;
    private Date createTime;
    private Date updateTime;

}

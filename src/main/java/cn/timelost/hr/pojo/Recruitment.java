package cn.timelost.hr.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;


@Data
public class Recruitment implements Serializable {

    private Integer id;

    private String departmentName;

    private String positionName;

    private Integer needNum;

    private String demand;

    private String needEducation;

    private Date startDate;

    private Date endTime;

    private Integer recruitStatus;

    private static final long serialVersionUID = 1L;
}
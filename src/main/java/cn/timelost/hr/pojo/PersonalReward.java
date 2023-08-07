package cn.timelost.hr.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;


@Data
public class PersonalReward implements Serializable {

    private Integer id;

    private Integer personalId;

    private String personalName;

    private String departmentName;

    private String positionName;

    private Date rewardDate;

    private Integer rewardKind;

    private Long rewardAmount;

    private String description;

    private static final long serialVersionUID = 1L;
}
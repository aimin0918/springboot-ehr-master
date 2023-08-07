package cn.timelost.hr.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;


@Data
public class PersonalTrain implements Serializable {

    private Integer id;

    private Integer personalId;

    private String personalName;

    private String departmentName;

    private String positionName;

    @JsonFormat(
            pattern = "yyyy-MM-dd",
            timezone = "GMT+8"
    )
    private Date beginDate;

    @JsonFormat(
            pattern = "yyyy-MM-dd",
            timezone = "GMT+8"
    )
    private Date endDate;

    private String trainContent;

    private BigDecimal trainScore;

    private BigDecimal trainCost;

    private String remake;

    private static final long serialVersionUID = 1L;
}
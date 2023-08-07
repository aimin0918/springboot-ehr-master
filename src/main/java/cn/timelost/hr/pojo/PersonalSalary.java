package cn.timelost.hr.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;


@Data
public class PersonalSalary implements Serializable {

    private Integer id;

    private Integer personalId;

    private String personalName;

    private String departmentName;

    private String positionName;

    private Date salaryDate;

    private BigDecimal basisSalary;

    private BigDecimal subsidySalary;

    private BigDecimal socialSalary;

    private BigDecimal providentFund;

    private BigDecimal bonus;

    private BigDecimal allSalary;

    private static final long serialVersionUID = 1L;
}
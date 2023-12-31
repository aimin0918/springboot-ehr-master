package cn.timelost.hr.vo.input;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;


@Data
public class PersonalTrainForm {
    @NotNull(message = "用户必填")
    private Integer personalId;
    @NotNull(message = "时间必填")
    @JsonFormat(
            pattern = "yyyy-MM-dd",
            timezone = "GMT+8"
    )
    private Date beginDate;
    @NotNull(message = "时间必填")
    @JsonFormat(
            pattern = "yyyy-MM-dd",
            timezone = "GMT+8"
    )
    private Date endDate;
    private String trainContent;
    private BigDecimal trainScore;
    private BigDecimal trainCost;
    private String remake;
}

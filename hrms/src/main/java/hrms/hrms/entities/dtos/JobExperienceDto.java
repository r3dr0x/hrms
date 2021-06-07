package hrms.hrms.entities.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobExperienceDto {
    @JsonIgnore
    private int id;
    private int resumeId;
    private String companyName;
    private int jobPositionId;
    @PastOrPresent
    private LocalDate startedDate;
    private LocalDate endedDate;
}

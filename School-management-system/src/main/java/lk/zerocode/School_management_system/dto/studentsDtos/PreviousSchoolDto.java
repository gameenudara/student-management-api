package lk.zerocode.School_management_system.dto.studentsDtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PreviousSchoolDto {

    private String schoolName;
    private LocalDate startDate;
    private LocalDate endDate;
}

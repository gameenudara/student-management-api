package lk.zerocode.School_management_system.dto.studentsDtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MedicalRecordDto {

    private String condition;
    private LocalDate diagnosisDate;

}

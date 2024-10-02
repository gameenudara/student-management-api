package lk.zerocode.School_management_system.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentDto {

    private Long id;
    private String name;
    private LocalDate Date;
    private Long gradeId;
    private String address;
    private LocalDate birthDate;
    private String gender;
    private String religion;


}

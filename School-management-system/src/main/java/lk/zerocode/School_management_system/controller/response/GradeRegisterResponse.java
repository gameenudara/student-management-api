package lk.zerocode.School_management_system.controller.response;

import lombok.Data;

@Data
public class GradeRegisterResponse {

    private Long id;
    private String grade;
    private String gradeName;
    private Long teacherId;
    private double classFee;
}

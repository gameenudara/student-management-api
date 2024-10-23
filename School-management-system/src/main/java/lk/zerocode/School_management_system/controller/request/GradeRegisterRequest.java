package lk.zerocode.School_management_system.controller.request;

import lombok.Data;

@Data
public class GradeRegisterRequest {

    private String grade;
    private String gradeName;
    private Long teacherId;
    private double classFee;
}

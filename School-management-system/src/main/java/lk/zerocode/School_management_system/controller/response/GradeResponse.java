package lk.zerocode.School_management_system.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GradeResponse {
    private String grade;
    private String gradeName;
    private Double fee;
    private String teacherName;
}

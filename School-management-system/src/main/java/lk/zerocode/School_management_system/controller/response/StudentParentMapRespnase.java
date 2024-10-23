package lk.zerocode.School_management_system.controller.response;

import lombok.Data;

import java.util.List;

@Data

public class StudentParentMapRespnase {
    private Long studentId;
    private List<Long> parentIds;
}

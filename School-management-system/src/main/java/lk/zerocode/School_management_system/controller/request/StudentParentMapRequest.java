package lk.zerocode.School_management_system.controller.request;

import lombok.Data;

import java.util.List;
@Data

public class StudentParentMapRequest {

    private List<Long> parentIds;
}

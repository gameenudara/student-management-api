package lk.zerocode.School_management_system.controller.request;

import lombok.Data;

import java.util.List;

@Data
public class ParentInformationRequest {

    private Long studentId;
    private List<Long> parentNicId;
}

package lk.zerocode.School_management_system.controller.request;

import lombok.Data;

import java.util.List;

@Data
public class StudentOtherInformationRequest {

    private List<Long> previousSchools;
    private List<Long> healthStatuses;
    private String additionalInfo;
}

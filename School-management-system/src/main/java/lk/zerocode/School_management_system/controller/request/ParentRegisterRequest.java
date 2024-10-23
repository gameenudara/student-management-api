package lk.zerocode.School_management_system.controller.request;

import lombok.Data;

@Data
public class ParentRegisterRequest {

    private String guardianType;
    private String name;
    private String address;
    private String nic;
    private String occupation;
    private String mobile;
    private String religion;
    private Double monthlyAvgIncome;
}

package lk.zerocode.School_management_system.service;

import lk.zerocode.School_management_system.controller.request.HealthStatusRequest;
import lk.zerocode.School_management_system.exception.StudentNotFoundException;
import lk.zerocode.School_management_system.model.StudentHealth;

public interface StudentHealthService {

    StudentHealth create(HealthStatusRequest request,Long id) throws StudentNotFoundException;
}

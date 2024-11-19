package lk.zerocode.School_management_system.service;

import lk.zerocode.School_management_system.controller.request.ExtraActivitiesRequest;
import lk.zerocode.School_management_system.exception.GradeNotFoundException;
import lk.zerocode.School_management_system.exception.StudentNotFoundException;
import lk.zerocode.School_management_system.model.StudentExtraActivity;
import org.springframework.stereotype.Service;

@Service
public interface StudentExtraActivitiesService {

    StudentExtraActivity create(Long studentId, ExtraActivitiesRequest extraActivitiesRequest)throws StudentNotFoundException,GradeNotFoundException;
}

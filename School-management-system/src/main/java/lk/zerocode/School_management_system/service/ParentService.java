package lk.zerocode.School_management_system.service;

import lk.zerocode.School_management_system.controller.request.ParentRequest;
import lk.zerocode.School_management_system.exception.StudentNotFoundException;
import lk.zerocode.School_management_system.model.Parent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ParentService {

    Parent create(Long studentId,ParentRequest parentRequest)throws StudentNotFoundException;

    List<Parent> findAll();
}

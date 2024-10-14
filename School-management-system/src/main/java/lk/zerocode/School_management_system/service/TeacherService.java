package lk.zerocode.School_management_system.service;

import lk.zerocode.School_management_system.controller.request.TeacherControllerRequest;
import lk.zerocode.School_management_system.exception.TeacherNotFoundException;
import lk.zerocode.School_management_system.model.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {
    Teacher createTeacher(TeacherControllerRequest teacherControllerRequest);

    List<Teacher> readAllTeachers();

    Teacher getSpecificTeacherById(Long id) throws TeacherNotFoundException;

    Teacher deleteTeacherById(Long id) throws TeacherNotFoundException;

    Teacher updateSpecificTeacherById(Long id,TeacherControllerRequest teacherControllerRequest) throws TeacherNotFoundException;

}

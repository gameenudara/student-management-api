package lk.zerocode.School_management_system.service;

import lk.zerocode.School_management_system.controller.request.GradeRequest;
import lk.zerocode.School_management_system.exception.GradeNotFoundException;
import lk.zerocode.School_management_system.exception.TeacherNotFoundException;
import lk.zerocode.School_management_system.model.Grade;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GradeService {

    Grade creteGrade(Long id,GradeRequest gradeRequest)throws TeacherNotFoundException;

    List<Grade> readAllGrades();

    Grade getGradeById(Long id) throws GradeNotFoundException;

    Grade updateById(Long gradeId, GradeRequest gradeRequest)throws GradeNotFoundException, TeacherNotFoundException;
}

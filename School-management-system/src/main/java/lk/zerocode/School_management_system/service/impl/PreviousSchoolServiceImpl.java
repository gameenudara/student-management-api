package lk.zerocode.School_management_system.service.impl;

import lk.zerocode.School_management_system.controller.request.PreviousSchoolRequest;
import lk.zerocode.School_management_system.controller.response.StudentPreviousSchoolResponse;
import lk.zerocode.School_management_system.exception.StudentNotFoundException;
import lk.zerocode.School_management_system.model.Student;
import lk.zerocode.School_management_system.model.StudentPreviousSchool;
import lk.zerocode.School_management_system.repository.StudentPreviousSchoolRepository;
import lk.zerocode.School_management_system.repository.StudentRepository;
import lk.zerocode.School_management_system.service.PreviousSchoolService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PreviousSchoolServiceImpl implements PreviousSchoolService {

    private StudentPreviousSchoolRepository previousSchoolRepository;
    private ModelMapper modelMapper;
    private StudentRepository studentRepository;

    @Override
    public StudentPreviousSchoolResponse create(Long id, PreviousSchoolRequest request) throws StudentNotFoundException {

        StudentPreviousSchool studentPreviousSchool = modelMapper.map(request, StudentPreviousSchool.class);
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student Not Found " + id));
        studentPreviousSchool.setStudent(student);
        StudentPreviousSchool savedPreviousSchool = previousSchoolRepository.save(studentPreviousSchool);
        return modelMapper.map(savedPreviousSchool, StudentPreviousSchoolResponse.class);
    }


}


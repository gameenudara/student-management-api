package lk.zerocode.School_management_system.service.impl;

import lk.zerocode.School_management_system.controller.request.HealthStatusRequest;
import lk.zerocode.School_management_system.exception.StudentNotFoundException;
import lk.zerocode.School_management_system.model.Student;
import lk.zerocode.School_management_system.model.StudentHealth;
import lk.zerocode.School_management_system.repository.StudentHealthRepository;
import lk.zerocode.School_management_system.repository.StudentRepository;
import lk.zerocode.School_management_system.service.StudentHealthService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentHealthServiceImpl implements StudentHealthService {

    private StudentHealthRepository studentHealthRepository;
    private StudentRepository studentRepository;
    private ModelMapper modelMapper;

    @Override
    public StudentHealth create(HealthStatusRequest request, Long id) throws StudentNotFoundException {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student Not Found" + id));
        StudentHealth studentHealth = modelMapper.map(request, StudentHealth.class);
        studentHealth.setStudent(student);
        return studentHealthRepository.save(studentHealth);
    }
}

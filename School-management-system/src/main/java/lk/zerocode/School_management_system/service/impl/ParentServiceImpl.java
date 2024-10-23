package lk.zerocode.School_management_system.service.impl;

import lk.zerocode.School_management_system.controller.request.ParentRegisterRequest;
import lk.zerocode.School_management_system.controller.request.StudentParentMapRequest;
import lk.zerocode.School_management_system.exception.ParentNotFoundException;
import lk.zerocode.School_management_system.exception.StudentNotFoundException;
import lk.zerocode.School_management_system.model.Parent;
import lk.zerocode.School_management_system.model.Student;
import lk.zerocode.School_management_system.repository.ParentRepository;
import lk.zerocode.School_management_system.repository.StudentRepository;
import lk.zerocode.School_management_system.service.ParentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ParentServiceImpl implements ParentService {

    private ParentRepository parentRepository;
    private StudentRepository studentRepository;
    private ModelMapper modelMapper;

    @Override
    public Parent create(ParentRegisterRequest request) {

        Parent parent = modelMapper.map(request, Parent.class);
        Parent savedParent = parentRepository.save(parent);
        return modelMapper.map(savedParent, Parent.class);

    }

    @Override
    public void mapParentStudent(Long id, StudentParentMapRequest request) throws StudentNotFoundException {

//        System.out.println(id);
//        System.out.println(request);
//        Student student = studentRepository.findById(id)
//
//                .orElseThrow(() -> new StudentNotFoundException("Student not found with ID: " + id));
//
//        Set<Parent> parents = request.getParentIds().stream()
//                .map(parentId -> {
//                    try {
//                        return parentRepository.findById(parentId)
//                                .orElseThrow(() -> new ParentNotFoundException("Parent not found with ID: " + parentId));
//                    } catch (ParentNotFoundException e) {
//                        throw new RuntimeException(e);
//                    }
//                })
//                .collect(Collectors.toSet());
//        student.setParents(new ArrayList<>(parents));
//
//        System.out.println(student);
//
//        parents.forEach(parent -> parent.getStudents().add(student));
//        System.out.println("THUSHAN");
//        studentRepository.save(student);
    }
}

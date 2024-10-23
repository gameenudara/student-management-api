package lk.zerocode.School_management_system.service.impl;

import lk.zerocode.School_management_system.controller.request.GradeRegisterRequest;
import lk.zerocode.School_management_system.controller.response.GradeRegisterResponse;
import lk.zerocode.School_management_system.model.Grade;
import lk.zerocode.School_management_system.model.Parent;
import lk.zerocode.School_management_system.repository.GradeRepository;
import lk.zerocode.School_management_system.service.GradeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GradeServiceImpl implements GradeService {

    private GradeRepository gradeRepository;
    private ModelMapper modelMapper;

    @Override
    public GradeRegisterResponse create(GradeRegisterRequest request) {

        System.out.println(request);
        Grade grade = modelMapper.map(request, Grade.class);
        Grade savedParent = gradeRepository.save(grade);
        return modelMapper.map(savedParent, GradeRegisterResponse.class);
    }
}

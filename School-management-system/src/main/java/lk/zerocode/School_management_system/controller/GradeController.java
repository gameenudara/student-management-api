package lk.zerocode.School_management_system.controller;

import lk.zerocode.School_management_system.controller.request.GradeRequest;
import lk.zerocode.School_management_system.controller.response.GradeResponse;
import lk.zerocode.School_management_system.controller.response.GradeSummaryResponse;
import lk.zerocode.School_management_system.exception.GradeNotFoundException;
import lk.zerocode.School_management_system.exception.TeacherNotFoundException;
import lk.zerocode.School_management_system.model.Grade;
import lk.zerocode.School_management_system.service.GradeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@AllArgsConstructor
public class GradeController {

    private final GradeService gradeService;
    private final ModelMapper modelMapper;

    @PostMapping(value = "/teachers/{teacher-id}/grades", headers = "X-Api-Version=v1")
    public ResponseEntity<GradeResponse> createGrade(@PathVariable("teacher-id") Long id, @RequestBody GradeRequest gradeRequest) throws TeacherNotFoundException {

        Grade grade = gradeService.creteGrade(id, gradeRequest);
        GradeResponse gradeResponse = modelMapper.map(grade, GradeResponse.class);
        return new ResponseEntity<>(gradeResponse, HttpStatus.CREATED);

    }

    @GetMapping(value = "/grades", headers = "X-Api-Version=v1")
    public ResponseEntity<List<GradeResponse>> getAllClassesWithTeachers() {

        List<Grade> grades = gradeService.readAllGrades();
        List<GradeResponse> gradeResponseList = grades.stream().map(grade -> modelMapper.map(grade, GradeResponse.class)).toList();
        return new ResponseEntity<>(gradeResponseList, HttpStatus.OK);
    }

    @GetMapping(value = "/grades/{grade-id}", headers = "X-Api-Version=v1")
    public ResponseEntity<GradeResponse> getGradesById(@PathVariable("grade-id") Long id) throws GradeNotFoundException {

        Grade grade = gradeService.getGradeById(id);
        GradeResponse gradeResponse = modelMapper.map(grade, GradeResponse.class);
        return new ResponseEntity<>(gradeResponse, HttpStatus.OK);
    }


    @PutMapping(value = "/grades/{grade-id}", headers = "X-Api-Version=v1")
    public ResponseEntity<GradeResponse> updateGrade(@PathVariable("grade-id") Long gradeId, @RequestBody GradeRequest gradeRequest) throws GradeNotFoundException, TeacherNotFoundException {

        Grade grade = gradeService.updateById(gradeId,gradeRequest);
        GradeResponse gradeResponse = modelMapper.map(grade, GradeResponse.class);
        return new ResponseEntity<>(gradeResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/grades-details", headers = "X-Api-Version=v1")
    public ResponseEntity<List<GradeSummaryResponse>> getGradesDetails() {
                return new ResponseEntity<>(gradeService.getGradeTeacherDetails(), HttpStatus.OK);
    }

}

package lk.zerocode.School_management_system.controller;

import lk.zerocode.School_management_system.controller.request.PreviousSchoolRequest;
import lk.zerocode.School_management_system.controller.response.StudentPreviousSchoolResponse;
import lk.zerocode.School_management_system.exception.SchoolNotFoundException;
import lk.zerocode.School_management_system.exception.StudentNotFoundException;
import lk.zerocode.School_management_system.model.PreviousSchool;
import lk.zerocode.School_management_system.service.PreviousSchoolService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/students")
public class PreviousSchoolController {

    private PreviousSchoolService previousSchoolService;
    private ModelMapper modelMapper;

    @PostMapping(value = "/{student-id}/previous-schools", headers = "X-Api-Version=v1")
    public ResponseEntity<StudentPreviousSchoolResponse> create(@PathVariable("student-id") Long id,
                                                                @RequestBody PreviousSchoolRequest request) {
        try {
            PreviousSchool studentPreviousSchool = previousSchoolService.create(id, request);
            StudentPreviousSchoolResponse studentPreviousSchoolResponse = modelMapper.map(studentPreviousSchool, StudentPreviousSchoolResponse.class);
            return new ResponseEntity<>(studentPreviousSchoolResponse, HttpStatus.CREATED);
        } catch (StudentNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{student-id}/previous-schools", headers = "X-Api-Version=v1")
    public ResponseEntity<List<StudentPreviousSchoolResponse>> getAll(@PathVariable("student-id") Long id) {
        System.out.println("Controller " + id);
        try {
            List<PreviousSchool> previousSchoolList = previousSchoolService.getAll(id);
            List<StudentPreviousSchoolResponse> schoolResponses = previousSchoolList
                    .stream().map(studentPreviousSchool -> modelMapper
                            .map(studentPreviousSchool, StudentPreviousSchoolResponse.class)).toList();
            return new ResponseEntity<>(schoolResponses, HttpStatus.OK);
        } catch (StudentNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{student-id}/previous-schools/{school-id}", headers = "X-Api-Version=v1")
    public ResponseEntity<StudentPreviousSchoolResponse> getById(@PathVariable("student-id") Long studentId,
                                                                 @PathVariable("school-id") Long schoolId) {
        try {
            PreviousSchool previousSchool = previousSchoolService.getById(studentId, schoolId);
            StudentPreviousSchoolResponse previousSchoolResponse = modelMapper.map(previousSchool, StudentPreviousSchoolResponse.class);
            return new ResponseEntity<>(previousSchoolResponse, HttpStatus.OK);
        } catch (StudentNotFoundException | SchoolNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/{student-id}/previous-schools/{school-id}", headers = "X-Api-Version=v1")
    public ResponseEntity<StudentPreviousSchoolResponse> updateById(@PathVariable("student-id") Long studentId,
                                                                    @PathVariable("school-id") Long schoolId,
                                                                    @RequestBody PreviousSchoolRequest request) throws StudentNotFoundException {
        try {
            PreviousSchool previousSchool = previousSchoolService.updateById(studentId, schoolId, request);
            StudentPreviousSchoolResponse previousSchoolResponse = modelMapper.map(previousSchool, StudentPreviousSchoolResponse.class);
            return new ResponseEntity<>(previousSchoolResponse, HttpStatus.OK);
        } catch (StudentNotFoundException | SchoolNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{student-id}/previous-schools/{school-id}", headers = "X-Api-Version=v1")
    public ResponseEntity<StudentPreviousSchoolResponse> deleteById(@PathVariable("student-id") Long studentId,
                                                                    @PathVariable("school-id") Long schoolId) {
        try {
            previousSchoolService.deleteById(studentId, schoolId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (StudentNotFoundException | SchoolNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
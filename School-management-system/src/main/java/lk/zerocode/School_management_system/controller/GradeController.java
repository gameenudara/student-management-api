package lk.zerocode.School_management_system.controller;

import lk.zerocode.School_management_system.controller.request.GradeRegisterRequest;
import lk.zerocode.School_management_system.controller.response.GradeRegisterResponse;
import lk.zerocode.School_management_system.service.GradeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class GradeController {

    private GradeService gradeService;

    @PostMapping(value = "/grades", headers = "X-Api-Version=v1")
    public ResponseEntity<?> create(@RequestBody GradeRegisterRequest request) {

        GradeRegisterResponse createdGrade = gradeService.create(request);
        return new ResponseEntity<>(createdGrade, HttpStatus.CREATED);

    }
}

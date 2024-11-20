package lk.zerocode.School_management_system.controller;

import lk.zerocode.School_management_system.controller.request.ExtraActivitiesRequest;
import lk.zerocode.School_management_system.controller.request.LeadershipRequest;
import lk.zerocode.School_management_system.controller.response.ExtraActivitiesResponse;
import lk.zerocode.School_management_system.controller.response.LeadershipResponse;
import lk.zerocode.School_management_system.exception.GradeNotFoundException;
import lk.zerocode.School_management_system.exception.StudentNotFoundException;
import lk.zerocode.School_management_system.model.StudentExtraActivity;
import lk.zerocode.School_management_system.model.StudentLeadership;
import lk.zerocode.School_management_system.service.StudentLeadershipService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
@AllArgsConstructor
public class StudentLeadershipController {

    private final StudentLeadershipService studentLeadershipService;
    private final ModelMapper modelMapper;

    @PostMapping(value = "/students/{student-id}/leaderships",headers = "X-api-Version=v1")
    public ResponseEntity<LeadershipResponse> create(@PathVariable("student-id") Long studentId,
                                                     @RequestBody LeadershipRequest leadershipRequest)throws StudentNotFoundException, GradeNotFoundException {

        StudentLeadership studentLeadership = studentLeadershipService.createStudentLeadership(studentId, leadershipRequest);
        LeadershipResponse leadershipResponse = modelMapper.map(studentLeadership, LeadershipResponse.class);
        return new ResponseEntity<>(leadershipResponse, HttpStatus.OK);
    }
}

package lk.zerocode.School_management_system.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "student_previous_schools")

public class StudentPreviousSchool extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String schoolName;

    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne
    private Student student;

}


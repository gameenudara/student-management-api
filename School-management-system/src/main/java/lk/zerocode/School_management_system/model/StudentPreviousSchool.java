package lk.zerocode.School_management_system.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "student_previous_school")

public class StudentPreviousSchool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String schoolName;

    @ManyToOne
    private Student student;


}


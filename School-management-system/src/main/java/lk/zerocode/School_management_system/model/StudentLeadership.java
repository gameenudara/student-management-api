package lk.zerocode.School_management_system.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "student_leadership")

public class StudentLeadership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String leadership;

    @ManyToOne
    private Student student;




}

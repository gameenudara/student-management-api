package lk.zerocode.School_management_system.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "student_health")

public class StudentHealth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String healthStatus;

    @ManyToOne
    private Student student;




}

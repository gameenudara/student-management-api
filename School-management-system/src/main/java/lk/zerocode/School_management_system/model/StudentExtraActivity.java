package lk.zerocode.School_management_system.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "student_extra_activity")

public class StudentExtraActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String extraActivity;

    @ManyToOne
    private Student student;




}

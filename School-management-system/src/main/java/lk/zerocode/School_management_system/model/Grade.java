package lk.zerocode.School_management_system.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "grade")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String grade;
    private String gName;
    private Double fee;

    @ManyToOne
    private Teacher teacher;

    @OneToMany(mappedBy = "grade")
    private List<Student> students = new ArrayList<>();

}

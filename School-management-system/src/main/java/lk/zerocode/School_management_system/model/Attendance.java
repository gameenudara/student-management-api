package lk.zerocode.School_management_system.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    private Student student;
}

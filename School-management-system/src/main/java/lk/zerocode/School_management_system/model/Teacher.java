package lk.zerocode.School_management_system.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String nic;
    private String address;
    private Integer mobile;
    private LocalDate date;
    private String email;
    private String subject;
    private String imageUrl;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Lob
    private String education;

    @Lob
    private String Experience;

    @OneToMany(mappedBy = "teacher")
    private List<Grade> grades  = new ArrayList<>();

}

package lk.zerocode.School_management_system.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;
    private String name;
    private String regNumber;
    private String address;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private LocalDate birthDate;
    private LocalDate admissionDate;
    private Integer mobile; /* mobile number eka ain karanne oni */
    private String religion;

    @ManyToOne
    private Grade grade;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Attendance> attendance = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "student_parent",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "parent_id")
    )
    private List<Parent> parents = new ArrayList<>();

    @OneToMany(mappedBy = "student" , cascade = CascadeType.ALL)
    private List<StudentHealth> studentHealths = new ArrayList<>();

    @OneToMany(mappedBy = "student" , cascade = CascadeType.ALL)
    private List<StudentPreviousSchool> studentPreviousSchools  = new ArrayList<>();

    @OneToMany(mappedBy = "student" , cascade = CascadeType.ALL)
    private List<StudentExtraActivity> studentExtraActivities  = new ArrayList<>();

    @OneToMany(mappedBy = "student" , cascade = CascadeType.ALL)
    private List<StudentLeadership> studentLeaderships  = new ArrayList<>();




}

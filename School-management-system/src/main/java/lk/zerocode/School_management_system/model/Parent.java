package lk.zerocode.School_management_system.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "parent")
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private GuardianType guardianType;
    private String name;
    private String address;
    private String nic;
    private String occupation;
    private Integer mobile;
    private String religion;
    private Double monthlyAvgIncome;

    @ManyToMany(mappedBy = "parents")
    private List<Student> students;
}

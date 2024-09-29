package lk.zerocode.School_management_system.repository;

import lk.zerocode.School_management_system.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}

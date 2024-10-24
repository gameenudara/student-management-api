package lk.zerocode.School_management_system.repository;

import lk.zerocode.School_management_system.model.Status;
import lk.zerocode.School_management_system.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByStatus(Status status);
}

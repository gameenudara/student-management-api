package lk.zerocode.School_management_system.repository;

import lk.zerocode.School_management_system.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Long> {
}

package com.multiple.db.ibdb.repository;

import com.multiple.db.ibdb.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}

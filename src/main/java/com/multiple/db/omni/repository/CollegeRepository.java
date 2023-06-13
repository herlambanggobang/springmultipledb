package com.multiple.db.omni.repository;

import com.multiple.db.omni.entity.College;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeRepository extends JpaRepository<College, Integer> {
}

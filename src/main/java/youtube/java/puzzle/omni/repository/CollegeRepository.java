package youtube.java.puzzle.omni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import youtube.java.puzzle.omni.entity.College;

public interface CollegeRepository extends JpaRepository<College, Integer> {
}

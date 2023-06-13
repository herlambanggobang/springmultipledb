package youtube.java.puzzle.ibdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import youtube.java.puzzle.ibdb.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}

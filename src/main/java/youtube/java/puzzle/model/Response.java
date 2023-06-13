package youtube.java.puzzle.model;

import lombok.Data;
import youtube.java.puzzle.omni.entity.College;
import youtube.java.puzzle.ibdb.entity.Student;

import java.util.List;

@Data
public class Response {
    List<Student> students;
    List<College> colleges;
}

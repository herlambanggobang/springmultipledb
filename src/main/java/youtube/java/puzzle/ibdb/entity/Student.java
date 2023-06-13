package youtube.java.puzzle.ibdb.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employeeId")
    private int id;
    @Column(name = "studentName")
    private String name;
    @Column(name = "studentAge")
    private String age;
}

package com.multiple.db.model;

import com.multiple.db.ibdb.entity.Student;
import com.multiple.db.omni.entity.College;
import lombok.Data;

import java.util.List;

@Data
public class Response {
    List<Student> students;
    List<College> colleges;
}

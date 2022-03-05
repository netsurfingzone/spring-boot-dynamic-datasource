package com.netsurfingzone.service;

import com.netsurfingzone.entity.Student;
import org.springframework.stereotype.Component;

@Component
public interface StudentService {
    public Student save(Student student);

    public Student update(Student student);

    public Student get(Long id);

    public void delete(Student student);
}

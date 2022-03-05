package com.netsurfingzone.serviceimpl;

import com.netsurfingzone.entity.Student;
import com.netsurfingzone.repository.mysql.MySqlRepository;
import com.netsurfingzone.repository.oracle.OracleRepository;
import com.netsurfingzone.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private MySqlRepository mySqlRepository;

    //Our another datasource
    @Autowired
    private OracleRepository oracleRepository;

    @Transactional
    public Student save(Student student) {
        Student createResponse = mySqlRepository.save(student);
        return createResponse;
    }

    @Transactional
    public Student update(Student student) {
        Student updateResponse = mySqlRepository.save(student);
        return updateResponse;
    }

    @Transactional
    public Student get(Long id) {
        Optional<Student> studentResponse = mySqlRepository.findById(id);
        Student getResponse = studentResponse.get();
        return getResponse;
    }

    @Transactional
    public void delete(Student student) {
        mySqlRepository.delete(student);
    }
}
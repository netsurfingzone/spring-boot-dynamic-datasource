package com.netsurfingzone.repository.mysql;

import com.netsurfingzone.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface MySqlRepository extends JpaRepository<Student, Serializable> {

}

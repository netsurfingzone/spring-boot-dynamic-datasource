package com.netsurfingzone.repository.oracle;

import com.netsurfingzone.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface OracleRepository extends JpaRepository<Student, Serializable> {

}

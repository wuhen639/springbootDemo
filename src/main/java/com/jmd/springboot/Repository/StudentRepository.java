package com.jmd.springboot.Repository;

import com.jmd.springboot.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by mengtongzhou1 on 2017/1/8.
 */
public interface StudentRepository extends MongoRepository<Student,Integer> {
    Student findByName(String name);
}

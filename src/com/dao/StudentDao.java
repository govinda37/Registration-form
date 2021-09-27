/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Student;
import java.util.List;

/**
 *
 * @author Govinda
 */
public interface StudentDao {
     public Integer addStudent(Student s);
     public List<Student> getAllStudent();
}

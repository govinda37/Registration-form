/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daoImp;
import com.connection.dbconnection;
import com.dao.StudentDao;
import com.model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Govinda
 */
public class StudentDaoImpl implements StudentDao {
     static Connection con = dbconnection.getConnection();

    @Override
    public Integer addStudent(Student s) {
        Integer roll = null;
        try {
            String addQuery = "INSERT INTO student_data(s_name,roll_no,email,fees,uni_name,depart,gender) VALUE(?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(addQuery);
            ps.setString(1, s.getStudentName());
            ps.setInt(2, s.getRollNo());
            ps.setString(3, s.getEmail());
            ps.setInt(4, s.getFees());
            ps.setString(5, s.getuName());
            ps.setString(6, s.getDepartment());
            ps.setString(7, s.getGender());
            roll = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            e.printStackTrace();
        }
        return roll;
    }

    @Override
    public List<Student> getAllStudent() {
        List<Student> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM student_data";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet set = ps.executeQuery();
            while (set.next()) {                
                Student s = new Student();
                s.setId(set.getInt("s_id"));
                s.setStudentName(set.getString("s_name"));
                s.setDepartment(set.getString("depart"));
                s.setEmail(set.getString("email"));
                s.setFees(set.getInt("fees"));
                s.setGender(set.getString("gender"));
                s.setRollNo(set.getInt("roll_no"));
                s.setuName(set.getString("uni_name"));
                list.add(s);
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }
}

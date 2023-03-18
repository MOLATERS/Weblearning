package com.lab2.lab2.Dao.Impl;

import com.lab2.lab2.DB.DBUtil;
import com.lab2.lab2.Dao.StudentDao;
import com.lab2.lab2.Entity.Major;
import com.lab2.lab2.Entity.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public void add(Student student){
        DBUtil dbutil =new DBUtil();
        String sid = student.getSid();
        String sname = student.getSname();
        String gender = student.getGender();
        int age = student.getAge();
        Date birthday = student.getBirthday();
        String mid = student.getMid();
        dbutil.executeUpdate("insert into student(sid,sname,gender,age,birthday,mid) values('"+sid+"','"+ sname +
                "','"+ gender +"',"+ age +",'"+ birthday +"','"+ mid +"')");
        try {
            dbutil.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void modify(Student student) {
        DBUtil dbutil =new DBUtil();
        String sid = student.getSid();
        String sname = student.getSname();
        String gender = student.getGender();
        int age = student.getAge();
        Date birthday = student.getBirthday();
        String mid = student.getMid();
        dbutil.executeUpdate("update student set sname = '" + sname +"', gender = '" + gender + "', age = "+ age +
                ", birthday = '"+ birthday +"', mid = '"+ mid +"' where sid = '"+ sid + "'");
        try {
            dbutil.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(String sid){
        DBUtil dbutil =new DBUtil();
        dbutil.executeUpdate("delete from student where mid = '"+ sid + "'");
        try {
            dbutil.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Student getById(String sid) {
        DBUtil dbutil =new DBUtil();
        ResultSet rs = dbutil.executeQuery("select * from student where sid = '"+sid+"'");
        List<Major> majorList=new ArrayList<>();
        String sname;
        String gender;
        int age;
        Date birthday;
        String mid;
        try {
            if(rs.next()){
                sname = rs.getString("sname");
                gender = rs.getString("gender");
                age = rs.getInt("age");
                birthday = rs.getDate("birthday");
                mid = rs.getString("mid");
                return new Student(sid,sname,gender,age,birthday,mid);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                dbutil.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return null;
        }
    }

    @Override
    public List<Student> getAll(String sql){
        DBUtil dbutil=new DBUtil();
        List<Student> studentList= new ArrayList<>();
        ResultSet rs=dbutil.executeQuery(sql);
        String sname,sid,mid,gender;
        int age;
        Date birthday;
        try {
            while(rs.next()){
                sid = rs.getString("sid");
                sname = rs.getString("sname");
                gender = rs.getString("gender");
                age = rs.getInt("age");
                birthday = rs.getDate("birthday");
                mid = rs.getString("mid");
                studentList.add(new Student(sid,sname,gender,age,birthday,mid));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                dbutil.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return studentList;
        }
    }
}

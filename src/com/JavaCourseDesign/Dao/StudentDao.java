package com.JavaCourseDesign.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.JavaCourseDesign.Model.Admin;
import com.JavaCourseDesign.Model.Student;
import com.JavaCourseDesign.Util.StringUtil;

public class StudentDao extends BaseDao{
	public Student login(Student student){
		String sql = "select * from s_student where name=? and password=?";
		Student studentRst = null;
		try {
			PreparedStatement prst = con.prepareStatement(sql);//把sql语句传给数据库操作对象
			//prst.setInt(1, student.getId());
			prst.setString(1, student.getName());
			//prst.setInt(3, student.getCla_id());
			prst.setString(2, student.getPassword());
			//prst.setString(5, student.getSex());
			ResultSet executeQuery = prst.executeQuery();
			if(executeQuery.next()){
				studentRst = new Student();
				//studentRst.setId(executeQuery.getInt("id"));
				studentRst.setName(executeQuery.getString("name"));
				//studentRst.setCla_id(executeQuery.getInt("cla_id"));
				studentRst.setPassword(executeQuery.getString("password"));
				//studentRst.setSex(executeQuery.getString("sex"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentRst;
	}
	public boolean addStudent(Student scl) {
		String sql="insert into s_student values(?,?,?,?,?)";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, scl.getId());
			preparedStatement.setString(2, scl.getName());
			preparedStatement.setInt(3, scl.getCla_id());
			preparedStatement.setString(4, "1234");
			preparedStatement.setString(5, scl.getSex());
			if(preparedStatement.executeUpdate()>0)return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public List<Student> getStudentList(Student student){
		List<Student> retList = new ArrayList<Student>();
		String name=student.getName();
		String sqlString="select * from s_student";
		if(!StringUtil.isEmpty(name)) {
			sqlString =" select * from s_student where name like '%"+name+"%'";
			
		}
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString);
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()) {
				Student st =new Student();
				st.setId(executeQuery.getInt("id"));
				st.setName(executeQuery.getString("name"));
				st.setCla_id(executeQuery.getInt("classId"));
				st.setSex(executeQuery.getString("sex"));
				retList.add(st);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return retList;
	}
	public boolean delete(int id) {
		String sql = "delete from s_student where id=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			if(preparedStatement.executeUpdate() > 0) {
				return true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean update(Student student) {
		String sql="update s_student set name=?,classId=?,sex=? where id=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setInt(2, student.getCla_id());
			preparedStatement.setString(3, student.getSex());
			preparedStatement.setInt(4, student.getId());
			if(preparedStatement.executeUpdate() > 0){
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}

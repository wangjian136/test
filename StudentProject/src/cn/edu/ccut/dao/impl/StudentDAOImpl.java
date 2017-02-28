package cn.edu.ccut.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cn.edu.ccut.dao.IStudentDAO;
import cn.edu.ccut.vo.Student;

public class StudentDAOImpl implements IStudentDAO {
	private Connection conn;
	private PreparedStatement pstmt;

	public StudentDAOImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public boolean doCreate(Student vo) throws Exception {
		String sql = "insert into student(id,name,sex,age,tel,loc) values (?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, vo.getId());
		this.pstmt.setString(2, vo.getName());
		this.pstmt.setString(3, vo.getSex());
		this.pstmt.setInt(4, vo.getAge());
		this.pstmt.setString(5, vo.getTel());
		this.pstmt.setString(6, vo.getLoc());
		if (this.pstmt.executeUpdate() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public Student findById(Integer id) throws Exception {
		Student vo = null;
		String sql = "select id,name,sex,age,tel,loc from student where id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, id);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			vo = new Student();
			vo.setId(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setSex(rs.getString(3));
			vo.setAge(rs.getInt(4));
			vo.setTel(rs.getString(5));
			vo.setLoc(rs.getString(6));
		}
		return vo;
	}

	@Override
	public List<Student> doListAll() throws Exception {
		List<Student> all = new ArrayList<Student>();
		Student vo;
		String sql = "select id,name,sex,age,tel,loc from student";
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			vo = new Student();
			vo.setId(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setSex(rs.getString(3));
			vo.setAge(rs.getInt(4));
			vo.setTel(rs.getString(5));
			vo.setLoc(rs.getString(6));
			all.add(vo);
		}
		return all;
	}

	@Override
	public boolean doLogin(String username, String password) throws Exception {
		String sql = "select COUNT(username) from user where username=? and password=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, username);
		this.pstmt.setString(2, password);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			if (rs.getInt(1) == 1) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Student> doListAll(Integer currentPage, Integer lineSize) throws Exception {
		List<Student> all = new ArrayList<Student>();
		Student vo;
		String sql = "select id,name,sex,age,tel,loc from student limit ?,?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, (currentPage - 1) * lineSize);
		this.pstmt.setInt(2, lineSize);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			vo = new Student();
			vo.setId(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setSex(rs.getString(3));
			vo.setAge(rs.getInt(4));
			vo.setTel(rs.getString(5));
			vo.setLoc(rs.getString(6));
			all.add(vo);
		}
		return all;
	}

	@Override
	public boolean doRemove(Integer id) throws Exception {
		String sql = "delete from student where id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, id);
		if (this.pstmt.executeUpdate() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean doUpdate(Student vo) throws Exception {
		String sql = "update student set name=?,sex=?,age=?,tel=?,loc=? where id=? ";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getName());
		this.pstmt.setString(2, vo.getSex());
		this.pstmt.setInt(3, vo.getAge());
		this.pstmt.setString(4, vo.getTel());
		this.pstmt.setString(5, vo.getLoc());
		this.pstmt.setInt(6, vo.getId());
		if (this.pstmt.executeUpdate() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean doBantchRemove(Set<Integer> all) throws Exception {
		Iterator<Integer> iter = all.iterator();
		String sql = "delete from student where id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		while (iter.hasNext()) {
			this.pstmt.setInt(1, iter.next().intValue());
			this.pstmt.addBatch();
		}
		int result[] = this.pstmt.executeBatch();
		for (int i = 0; i < result.length; i++) {
			if (result[i] == 0) {
				return false;
			}
		}
		return true;
	}
}

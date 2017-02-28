package cn.edu.ccut.dao;

import java.util.List;
import java.util.Set;

import cn.edu.ccut.vo.Student;

public interface IStudentDAO {
	public boolean doCreate(Student vo) throws Exception;

	public Student findById(Integer id) throws Exception;

	public List<Student> doListAll() throws Exception;

	public boolean doLogin(String username, String password) throws Exception;

	public List<Student> doListAll(Integer currentPage, Integer lineSize) throws Exception;

	public boolean doRemove(Integer id) throws Exception;

	public boolean doUpdate(Student vo) throws Exception;

	public boolean doBantchRemove(Set<Integer> all) throws Exception;
}

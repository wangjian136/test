package cn.edu.ccut.service;

import java.util.List;
import java.util.Set;

import cn.edu.ccut.vo.Student;

public interface IStudentService {
	public boolean insert(Student vo) throws Exception;

	public List<Student> listAll() throws Exception;

	public boolean login(String username, String password) throws Exception;

	public List<Student> listAll(int currentPage, int lineSize) throws Exception;

	public boolean delete(int id) throws Exception;

	public boolean update(Student vo) throws Exception;

	public boolean bantchDelete(Set<Integer> all) throws Exception;
}

package cn.edu.ccut.service.impl;

import java.util.List;
import java.util.Set;

import cn.edu.ccut.dbc.DatabaseConnection;
import cn.edu.ccut.factory.DAOFactory;
import cn.edu.ccut.service.IStudentService;
import cn.edu.ccut.vo.Student;

public class StudentServiceImpl implements IStudentService {
	private DatabaseConnection dbc = new DatabaseConnection();

	@Override
	public boolean insert(Student vo) throws Exception {
		try {
			if (DAOFactory.getStudentDAO(this.dbc.getConnection()).findById(vo.getId()) == null) {
				return DAOFactory.getStudentDAO(this.dbc.getConnection()).doCreate(vo);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return false;
	}

	@Override
	public List<Student> listAll() throws Exception {
		try {
			return DAOFactory.getStudentDAO(this.dbc.getConnection()).doListAll();
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	@Override
	public boolean login(String username, String password) throws Exception {
		try {
			return DAOFactory.getStudentDAO(this.dbc.getConnection()).doLogin(username, password);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	@Override
	public List<Student> listAll(int currentPage, int lineSize) throws Exception {
		try {
			return DAOFactory.getStudentDAO(this.dbc.getConnection()).doListAll(currentPage, lineSize);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	@Override
	public boolean delete(int id) throws Exception {
		try {
			return DAOFactory.getStudentDAO(this.dbc.getConnection()).doRemove(id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	@Override
	public boolean update(Student vo) throws Exception {
		try {
			return DAOFactory.getStudentDAO(this.dbc.getConnection()).doUpdate(vo);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	@Override
	public boolean bantchDelete(Set<Integer> all) throws Exception {
		try {
			return DAOFactory.getStudentDAO(this.dbc.getConnection()).doBantchRemove(all);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}
}

package cn.edu.ccut.factory;

import java.sql.Connection;

import cn.edu.ccut.dao.IStudentDAO;
import cn.edu.ccut.dao.impl.StudentDAOImpl;

public class DAOFactory {
	public static IStudentDAO getStudentDAO(Connection conn) {
		return new StudentDAOImpl(conn);
	}
}

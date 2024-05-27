package DAO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DAOTest {
	private DAO dao;

	@BeforeEach
	public void inicializando() throws SQLException {
		dao = new DAO();
		dao.conectarDb();
	}

	@Test
	protected void testConectarDb() {
		try {

			Connection conn = dao.conn;
			assertNotNull(conn);
			assertFalse(conn.isClosed());
		} catch (SQLException e) {
			fail("error al conectar: " + e.getMessage());
		}
	}

	@Test
	void testConsultar() {

		assertNotNull(dao.conn);

		String sql = "select id, nombre from user where id = '1'";

		ResultSet rs = dao.consultar(sql);
		assertNotNull(rs);

		try {

			assertTrue(rs.next());

			int user_id = rs.getInt("id");
			String nombre = rs.getString("nombre");

			assertEquals(1, user_id);
			assertEquals("Paul", nombre);

		} catch (SQLException e) {
			fail("Excepción SQL: " + e.getMessage());
		}
	}

	@Test
	protected void testEjecutarSql() {

		String sql = "insert into user (nombre, email, contrasena) values " + "('Paul','arra2@gmail.com','1234')";

		int registrosAfectados = dao.ejecutarSql(sql);

		assertEquals(1, registrosAfectados);
	}
}

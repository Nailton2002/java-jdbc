package conexaojdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {
	//URL DE CONEXÃO EM JDBC O PADRAO É ESTE
	private static String url = "jdbc:postgresql://localhost:5432/posjava";
	private static String password = "admin";
	private static String user = "postgres";
	private static Connection connection = null;

	static {
		conectar();
	}

	public SingleConnection() {

	}

	private static void conectar() {// TUDO ACONECE AQUI NESTE METODO
		try {
			if (connection == null) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(false);// AQUI EU DECIDO SE VOU GRAVAR OU NAO NO BANCO
				System.out.println("Conectou com sucesso!");
			}

		} catch (Exception e) {

		}
	}

	public static Connection getConnection() {
		return connection;
	}

}

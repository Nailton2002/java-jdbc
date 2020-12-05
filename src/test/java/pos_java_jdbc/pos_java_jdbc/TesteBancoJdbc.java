package pos_java_jdbc.pos_java_jdbc;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import dao.UserPosDao;
import model.BeanUserFone;
import model.Telefone;
import model.Userposjava;

public class TesteBancoJdbc {

	@Test
	public void initBanco() { // metodo de insert

		UserPosDao userPosDAO = new UserPosDao();
		Userposjava userposjava = new Userposjava();
		
		userposjava.setNome("nailton");
		userposjava.setEmail("nailton@gmail.com");

		userPosDAO.salvar(userposjava);

	}

	@Test
	public void initListar() {
		UserPosDao dao = new UserPosDao();
		try {
			List<Userposjava> list = dao.listar();

			for (Userposjava userposjava : list) {
				System.out.println(userposjava);
				System.out.println("----------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void initBuscar() {

		UserPosDao dao = new UserPosDao();

		try {
			Userposjava userposjava = dao.buscar(1L);

			System.out.println(userposjava);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void initAtualizar() {
		try {

			UserPosDao dao = new UserPosDao();

			Userposjava objetoBanco = dao.buscar(1L);

			objetoBanco.setNome("Nailton Mendes");

			dao.atualizar(objetoBanco);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void initDeletar() {

		try {

			UserPosDao dao = new UserPosDao();
			dao.deletar(4L);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	//---------------------------------teste de telefones----------------------------

    @Test
	public void testeInsertTelefone() {

		Telefone telefone = new Telefone();
		telefone.setNumero("(81) 998582500");
		telefone.setTipo("Casa");
		telefone.setUsuario(2L);

		UserPosDao dao = new UserPosDao();
		dao.salvarTelefone(telefone);

	}

	@Test
	public void testeCarregaFonesUser() {

		UserPosDao dao = new UserPosDao();

		List<BeanUserFone> beanUserFones = dao.listaUserFone(2L);

		for (BeanUserFone beanUserFone : beanUserFones) {
			System.out.println(beanUserFone);
			System.out.println("---------------------------------------------");
		}

	}

	@Test
	public void testeDeleteUserFone() {

		UserPosDao dao = new UserPosDao();
		dao.deleteFonesPorUser(8L);

	}

	@Test
	public void teste() {

		try {

			// Data Limite com 50 anos
			Date dataLimite = new SimpleDateFormat("dd/MM/yyyy").parse("25/10/2068");

			// Zera as horas, minutos e segundos
			Calendar cal = Calendar.getInstance();
			
			// Data informada pelo usúario
			cal.setTime(new SimpleDateFormat("dd/MM/yyyy").parse("25/10/2068"));
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);

			// Add 50 anos
			//cal.add(Calendar.YEAR, 50);
			
			if (cal.getTime().compareTo(dataLimite) <= 0 ) {
				System.out.println("Data está OK");
			} else {
				System.out.println("Data passou do limite");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

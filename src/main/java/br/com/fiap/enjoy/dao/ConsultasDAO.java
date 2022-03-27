package br.com.fiap.enjoy.dao;

import javax.persistence.Query;
import javax.persistence.EntityManager;

public class ConsultasDAO {
	private EntityManager em;
	
	public ConsultasDAO(EntityManager em) {
		this.em = em;
	}
	
	@SuppressWarnings("unused")
	private void getTicketMedio(int numTelefone) {
		Query query = (Query) em.createQuery(
				"SELECT AVG(VL_CONSUMIDO) as valor_gasto"
				+ "ROM Visitas vis"
				+ "inner join Consumidor con"
				+ "on con.id_consumidor = vis.id_consumidor"
				+ "where con.telefone = 987654321");
		((javax.persistence.Query) query).setParameter("tel", numTelefone);
		Object resultado = ((javax.persistence.Query) query).getSingleResult();
		System.out.println("Ticket m�dio: R$ " + resultado);
	}

	@SuppressWarnings("unused")
	private void getFrequenciaVisitas(int numTelefone) {
		javax.persistence.Query query = em.createQuery(
				"ROUND(COUNT(DISTINCT vis.dt_visita) / COUNT(DISTINCT TO_CHAR(vis.dt_visita, 'mm/YY')),0) "
			  + "from tb_enjoy_visita vis INNER JOIN tb_enjoy_consumidor con "
			  + "where con.nr_telefone = :telefone ");
		query.setParameter("telefone", numTelefone);
		Object resultado = query.getSingleResult();
		System.out.println("Frequência: " + resultado + "por mês");
	}

	private void getBebidaConsumida(int numTelefone) {
		
		Query query = (Query) em.createQuery("SELECT BEB.categoria AS categoria_bebida, SUM(COM.quantidade) AS quantidade_prod"
				+ "FROM Bebida BEB"
				+ "INNER JOIN Comanda COM"
				+ "ON BEB.id = COM.bebida"
				+ "INNER JOIN Visitas VIS"
				+ "ON COM.id = VIS.comanda"
				+ "INNER JOIN Consumidor CON"
				+ "ON VIS.consumidor = CON.id"
				+ "WHERE CON.telefone = :tel"
				+ "GROUP BY COM.quantidade,BEB.categoria"
				+ "ORDER BY BEB.categoria");
		query.setMaxResults(1);
		query.setParameter("tel", numTelefone);
		
		Object resultado1 = (Object[]) query.getSingleResult();		
		System.out.println(resultado1);
	}
	
	@SuppressWarnings("unused")
	private void getUltimaVisita(int numTelefone) {
		Query query = (Query) em.createQuery(
				"select max(vis.dataVisita)"
				+ "from Visita vis"
				+ "inner join Consumidor con"
				+ "on con.id_consumidor = vis.id_consumidor"
				+ "where con.telefone = 987654321");
		
		query.setMaxResults(1);
		query.setParameter("telefone", numTelefone);
		Object resultado = query.getSingleResult();
		System.out.println(resultado);
		
	}
	

}

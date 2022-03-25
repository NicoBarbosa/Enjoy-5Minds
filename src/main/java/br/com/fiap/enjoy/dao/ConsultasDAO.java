package br.com.fiap.enjoy.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ConsultasDAO {
	private EntityManager em;
	
	public ConsultasDAO(EntityManager em) {
		this.em = em;
	}
	
	@SuppressWarnings("unused")
	private void getTicketMedio(int nr_telefone) {
		Query query = em.createQuery(
				"SELECT AVG(VL_CONSUMIDO) as valor_gasto"
				+ "ROM TB_ENJOY_VISITA vis"
				+ "inner join tb_enjoy_consumidor con"
				+ "on con.id_consumidor = vis.id_consumidor"
				+ "where con.nr_telefone = 987654321");
		query.setParameter("tel", nr_telefone);
		var result = query.getSingleResult();
		System.out.println("Ticket médio: R$ " + result);
		
	}
	
}

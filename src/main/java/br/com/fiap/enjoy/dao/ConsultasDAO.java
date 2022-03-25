package br.com.fiap.enjoy.dao;

import javax.management.Query;
import javax.persistence.EntityManager;

public class ConsultasDAO {
	private EntityManager em;
	
	public ConsultasDAO(EntityManager em) {
		this.em = em;
	}
	
	
	@SuppressWarnings("unused")
	private void getTicketMedio(int nr_telefone) {
		Query query = (Query) em.createQuery(
				"SELECT AVG(VL_CONSUMIDO) as valor_gasto"
				+ "ROM TB_ENJOY_VISITA vis"
				+ "inner join tb_enjoy_consumidor con"
				+ "on con.id_consumidor = vis.id_consumidor"
				+ "where con.nr_telefone = 987654321");
		((javax.persistence.Query) query).setParameter("tel", nr_telefone);
		var result = ((javax.persistence.Query) query).getSingleResult();
		System.out.println("Ticket médio: R$ " + result);
	}

	public void getFrequenciaVisitas(int numTelefone) {
		Query query = (Query) em.createQuery(
				"ROUND(COUNT(DISTINCT vis.dt_visita) / COUNT(DISTINCT TO_CHAR(vis.dt_visita, 'mm/YY')),0)\n"
			  + "from tb_enjoy_visita vis JOIN tb_enjoy_consumidor con"
				);
	}

	private void getTicketMedio() {
		
		
	}
	
	private void getBebidaConsumida() {
		
		
	}
	

}

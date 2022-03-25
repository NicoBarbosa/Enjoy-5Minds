package br.com.fiap.enjoy.dao;

import javax.management.Query;
import javax.persistence.EntityManager;

public class ConsultasDAO {
	private EntityManager em;
	
	public ConsultasDAO(EntityManager em) {
		this.em = em;
	}
	
	public void getFrequenciaVisitas(int numTelefone) {
		Query query = (Query) em.createQuery(
				"ROUND(COUNT(DISTINCT vis.dt_visita) / COUNT(DISTINCT TO_CHAR(vis.dt_visita, 'mm/YY')),0)\n"
			  + "from tb_enjoy_visita vis JOIN tb_enjoy_consumidor con"
				);
	}
}

package br.com.fiap.enjoy.dao;

import javax.persistence.Query;
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

	private void getTicketMedio() {
		
		
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
		
		var resultado1 = (Object[]) query.getSingleResult();		
		System.out.println(resultado1);
	}
	

}

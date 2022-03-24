package br.com.fiap.enjoy.domain;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "tb_enjoy_visita")
public class Visitas {

	@Id
	@Column(name = "id_visitas")
	@SequenceGenerator(name="visitas",sequenceName="sq_tb_visitas",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="visitas")
	private Integer id;
	
	@Column(name = "vl_consumido", nullable = false)
	private double valorConsumido;
	
	@Column(name = "qt_consumida", nullable = false)
	private int quantidade;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_visita", nullable = false)
	private Calendar dataVisita;
	
	@ManyToOne
	@JoinColumn(name = "id_consumidor")
	private Consumidor consumidor;
	
	@ManyToOne
	@JoinColumn(name = "id_estabelecimento")
	private Estabelecimento estabelecimento;
	
	@OneToOne
	@JoinColumn(name = "id_comanda")
	private Comanda comanda;


	public Visitas(Integer id, double valorConsumido, int quantidade, Calendar dataVisita, Consumidor consumidor,
			Estabelecimento estabelecimento, Comanda comanda) {
		super();
		this.id = id;
		this.valorConsumido = valorConsumido;
		this.quantidade = quantidade;
		this.dataVisita = dataVisita;
		this.consumidor = consumidor;
		this.estabelecimento = estabelecimento;
		this.comanda = comanda;
	}

	public Visitas() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getValorConsumido() {
		return valorConsumido;
	}

	public void setValorConsumido(double valorConsumido) {
		this.valorConsumido = valorConsumido;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Calendar getDataVisita() {
		return dataVisita;
	}

	public void setDataVisita(Calendar dataVisita) {
		this.dataVisita = dataVisita;
	}

	public Consumidor getConsumidor() {
		return consumidor;
	}

	public void setConsumidor(Consumidor consumidor) {
		this.consumidor = consumidor;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public Comanda getComanda() {
		return comanda;
	}

	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}
	
}

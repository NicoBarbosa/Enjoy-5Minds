package br.com.fiap.enjoy.domain;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="tb_enjoy_comanda")
public class Comanda {
	
	@Id
	@Column(name="id_comanda")
	@SequenceGenerator(name="comanda",sequenceName="sq_tb_comanda",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="comanda")
	private int id;
	
	@Column(name="qt_produtos")
	private int quantidade;
	
	@Column(name="vl_comanda")
	private double valor;
	
	@CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_cadastro", nullable = false)
    private Calendar dataCadastro;
	
	@Column(name="dt_atualizacao", nullable = false)
	@UpdateTimestamp
	private Calendar atualizacao;
	
	@OneToMany(mappedBy = "comanda")
	private List<Visitas> visitas;

	//OneToMany
	@OneToMany(mappedBy = "comanda")
  	private List<Bebida> bebida;

	@ManyToOne
	@JoinColumn(name="id_estab")
	private Estabelecimento estabelecimento;

	public Comanda() {
		super();
	}

	

	public Comanda(int id, int quantidade, double valor, Calendar dataCadastro, Calendar atualizacao,
			List<Visitas> visitas, List<Bebida> bebida, Estabelecimento estabelecimento) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.valor = valor;
		this.dataCadastro = dataCadastro;
		this.atualizacao = atualizacao;
		this.visitas = visitas;
		this.bebida = bebida;
		this.estabelecimento = estabelecimento;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Calendar getAtualizacao() {
		return atualizacao;
	}

	public void setAtualizacao(Calendar atualizacao) {
		this.atualizacao = atualizacao;
	}

	public List<Visitas> getVisitas() {
		return visitas;
	}

	public void setVisitas(List<Visitas> visitas) {
		this.visitas = visitas;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}



	public List<Bebida> getBebida() {
		return bebida;
	}



	public void setBebida(List<Bebida> bebida) {
		this.bebida = bebida;
	}
	
}

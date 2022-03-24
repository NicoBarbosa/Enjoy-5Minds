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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="tb_enjoy_produto")
public class Produto {
	
	@Id
	@Column(name="id_produto")
	@SequenceGenerator(name="produto",sequenceName="sq_tb_produto",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="produto")
	private int id;
	
	@Column(name="qt_produto")
	private int quantidade;
	
	@Column(name="vl_produto")
	private double valor;
	
	@CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_cadastro", nullable = false)
    private Calendar dataCadastro;
	
	@Column(name="dt_atualizacao", nullable = false)
	@UpdateTimestamp
	private Calendar atualizacao;
	
	@OneToMany(mappedBy = "produto")
	private List<Visitas> visitas;

	//OneToMany
	@OneToOne
	@JoinColumn(name="id_bebida")
  	private Bebida bebida;

	@ManyToOne
	@JoinColumn(name="id_estab")
	private Estabelecimento estabelecimento;

	public Produto() {
		super();
	}

	public Produto(int id, int quantidade, double valor, Calendar dataCadastro, Calendar atualizacao,
			List<Visitas> visitas, Bebida bebida, Estabelecimento estabelecimento) {
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

	public Bebida getBebida() {
		return bebida;
	}

	public void setBebida(Bebida bebida) {
		this.bebida = bebida;
	}
	
}

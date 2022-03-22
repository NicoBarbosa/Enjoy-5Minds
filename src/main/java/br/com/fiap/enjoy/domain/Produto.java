package br.com.fiap.enjoy.domain;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="tb_produto")
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
	
//	@OneToMany(mappedBy = "estabVisita")
//	private List<Visitas> visitas;

//  @ManyToOne
//	@JoinColumn(name="id_bebida")
//  private Bebida bebida;

//  @ManyToOne
//  @JoinColumn(name="id_estab")
//  private Estabelecimento estabelecimento;

	public Produto() {
		super();
	}

	public Produto(int id, int quantidade, double valor, Calendar dataCadastro, Calendar atualizacao) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.valor = valor;
		this.dataCadastro = dataCadastro;
		this.atualizacao = atualizacao;
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
	
	

}

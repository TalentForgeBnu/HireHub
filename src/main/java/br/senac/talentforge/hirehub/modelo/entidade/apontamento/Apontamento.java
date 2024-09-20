package br.senac.talentforge.hirehub.modelo.entidade.apontamento;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.senac.talentforge.hirehub.modelo.entidade.dossie.Dossie;

@Entity
@Table(name = "apontamento")
public class Apontamento implements Serializable {

	private static final long serialVersionUID = -7307291718586965410L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_apontamento")
	private long id;

	@Column(name = "descricao", length = 200, nullable = false, unique = true)
	private String descricao;

	@Column(name = "data_criacao", nullable = false, unique = true)
	private LocalDate data;

	@ManyToOne
	@JoinColumn(name="id_dossie", nullable = false)
	private Dossie dossie;

	public Apontamento(){}

	public Apontamento( String descricao, LocalDate data, long id) {
		setDescricao(descricao);
		setData(data);
		setId(id);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Dossie getDossie() {
		return dossie;
	}

	public void setDossie(Dossie dossie) {
		this.dossie = dossie;
	}

}

	
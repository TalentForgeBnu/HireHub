package br.senac.talentforge.hirehub.modelo.entidade.empresa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.senac.talentforge.hirehub.modelo.entidade.oferta.Oferta;
import br.senac.talentforge.hirehub.modelo.entidade.vaga.Vaga;
import br.senac.talentforge.hirehub.modelo.enumeracao.modalidadecontratacao.ModalidadeContratacao;
import br.senac.talentforge.hirehub.modelo.enumeracao.situacaovaga.SituacaoVaga;


@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {
		
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_empresa")
	private long id;
	
	@Column(name = "nomeEmpresa", length = 25, nullable = false, unique = false)
	private String nomeEmpresa;
	
	@Column(name = "cnpj", length = 14, nullable = false, unique = false)
	private String cnpj;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "empresa",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Vaga> demandaVagas;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "empresa",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Oferta> ofertas;

	public Empresa(String nomeEmpresa, String cnpj) {
		setNomeEmpresa(nomeEmpresa);
		setId(id);
		this.demandaVagas = new ArrayList<>();
		this.ofertas = new ArrayList<>();
		
	}

	public void OfertarVagas(String nomeVaga, int codigoVaga, String descricao, ModalidadeContratacao modalidadeContratacao, SituacaoVaga situacaoVaga ) {
		Vaga novaVaga = new Vaga(nomeVaga, codigoVaga, descricao, modalidadeContratacao, situacaoVaga);
		this.demandaVagas.add(novaVaga);
		System.out.println("Vaga adicionada: " + novaVaga);

	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<Vaga> getVagas() {
		return demandaVagas;
	}

	public void setVagas(Vaga vaga){	
	        demandaVagas.add(vaga);
	}
	
	public List<Oferta> getOferta() {
		return ofertas;
	}

	public void setOfertas(Oferta oferta){	
	        ofertas.add(oferta);
	}
		
	public void DeterminarDemanda() {
		
		int totalVagas = demandaVagas.size();
        System.out.println("Total de vagas: " + totalVagas);

	}
	
	public long getId() {
		return id;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

}
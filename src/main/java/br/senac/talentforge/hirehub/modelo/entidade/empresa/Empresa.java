package br.senac.talentforge.hirehub.modelo.entidade.empresa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.senac.talentforge.hirehub.modelo.entidade.oferta.Oferta;
import br.senac.talentforge.hirehub.modelo.entidade.pessoaJuridica.PessoaJuridica;
import br.senac.talentforge.hirehub.modelo.entidade.vaga.Vaga;

@Entity
@Table(name = "empresa")
public class Empresa extends PessoaJuridica implements Serializable {

	private static final long serialVersionUID = -6802369364395050191L;

	@OneToMany(mappedBy = "empresa",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Vaga> vagas;

	@OneToMany(mappedBy = "empresa",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Oferta> ofertas;

	public Empresa() {
		vagas = new ArrayList<Vaga>();
		ofertas = new ArrayList<Oferta>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Vaga> getVagas() {
		return vagas;
	}

	public void setVagas(List<Vaga> vagas) {
		this.vagas = vagas;
	}

	public List<Oferta> getOfertas() {
		return ofertas;
	}

	public void setOfertas(List<Oferta> ofertas) {
		this.ofertas = ofertas;
	}

	public void addVaga(Vaga vaga){
		this.vagas.add(vaga);
	}

	public void addOferta(Oferta oferta){
		this.ofertas.add(oferta);
	}
}
package TalentForge.HireHub;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;


@Entity
@Table(name = "empresa")
public class Empresa extends Usuario implements Serializable {
	
	
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
	
	public Empresa(String nomeEmpresa, String cnpj, List<Vaga> vaga) {
		super();
		setNomeEmpresa(nomeEmpresa);
		setCnpj(cnpj);
		this.demandaVagas = new ArrayList<>();
		setId(id);
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

	public void setVagas(List<Vaga> vagas) {
		this.demandaVagas = vagas;
	}
	
	public void OfertarVagas() {
		Vaga novaVaga = new Vaga(nomeVaga, codigoVaga, modalidadeContratacao);
        this.demandaVagas.add(novaVaga);
        System.out.println("Vaga adicionada: " + novaVaga);

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
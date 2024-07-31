package TalentForge.HireHub;

import java.util.ArrayList;
import java.util.List;

public class Empresa extends Usuario {
	private String nomeEmpresa;
	private String cnpj;
	private List<Vaga> demandaVagas;
	
	
	
	public Empresa(String nomeEmpresa, String cnpj, List<Vaga> vaga) {
		super();
		setNomeEmpresa(nomeEmpresa);
		setCnpj(cnpj);
		this.demandaVagas = new ArrayList<>();
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
	

}
package br.senac.talentforge.hirehub.modelo.dao.empresa;

import br.senac.talentforge.hirehub.modelo.entidade.empresa.Empresa;

public interface EmpresaDAO {
    Empresa recuperarEmpresa(String cnpj);
}
package br.senac.talentforge.hirehub.modelo.dao.empresa;

import br.senac.talentforge.hirehub.modelo.entidade.empresa.Empresa;

public interface EmpresaDAO {
    void inserirEmpresa(Empresa empresa);

    void deletarEmpresa(Empresa empresa);

    void atualizarEmpresa(Empresa empresa);
}
package br.senac.talentforge.hirehub.modelo.factory.conexao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ConexaoFactory {

    public SessionFactory getConexao() {

        Configuration configuracao = new Configuration();

        configuracao.addAnnotatedClass(br.senac.talentforge.hirehub.modelo.entidade.aluno.Aluno.class);
        configuracao.addAnnotatedClass(br.senac.talentforge.hirehub.modelo.entidade.curso.Curso.class);
        configuracao.addAnnotatedClass(br.senac.talentforge.hirehub.modelo.entidade.empresa.Empresa.class);
        configuracao.addAnnotatedClass(br.senac.talentforge.hirehub.modelo.entidade.endereco.Endereco.class);
        configuracao.addAnnotatedClass(br.senac.talentforge.hirehub.modelo.entidade.instituicao.Instituicao.class);
        configuracao.addAnnotatedClass(br.senac.talentforge.hirehub.modelo.entidade.proposta.Proposta.class);
        configuracao.addAnnotatedClass(br.senac.talentforge.hirehub.modelo.entidade.professor.Professor.class);
        configuracao.addAnnotatedClass(br.senac.talentforge.hirehub.modelo.entidade.turma.Turma.class);
        configuracao.addAnnotatedClass(br.senac.talentforge.hirehub.modelo.entidade.usuario.Usuario.class);
        configuracao.addAnnotatedClass(br.senac.talentforge.hirehub.modelo.entidade.vaga.Vaga.class);
        configuracao.addAnnotatedClass(br.senac.talentforge.hirehub.modelo.entidade.apontamento.Apontamento.class);
        configuracao.addAnnotatedClass(br.senac.talentforge.hirehub.modelo.entidade.dossie.Dossie.class);
        configuracao.addAnnotatedClass(br.senac.talentforge.hirehub.modelo.entidade.papel.Papel.class);


        configuracao.configure("hibernate.cfg.xml");

        ServiceRegistry servico = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();
        return configuracao.buildSessionFactory(servico);
    }

}
package br.senac.talentforge.hirehub.modelo.entidade.foto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.senac.talentforge.hirehub.modelo.entidade.curso.Curso;
import br.senac.talentforge.hirehub.modelo.entidade.usuario.Usuario;
import br.senac.talentforge.hirehub.modelo.entidade.vaga.Vaga;

@Entity
@Table(name = "foto")
public class Foto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Lob
    @Column(name = "imagem", nullable = false)
    private byte[] imagem;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @OneToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;

    @OneToOne
    @JoinColumn(name = "id_vaga", nullable = false)
    private Vaga vaga;

    public Foto() {
    }

    public Foto(byte[] imagem, String tipo, Usuario usuario) {
        this.imagem = imagem;
        this.tipo = tipo;
        this.usuario = usuario;
    }

    public Foto(long id, byte[] imagem, String tipo, Usuario usuario) {
        this.id = id;
        this.imagem = imagem;
        this.tipo = tipo;
        this.usuario = usuario;
    }

    public Foto(byte[] imagem, String tipo, Curso curso) {
        this.imagem = imagem;
        this.tipo = tipo;
        this.curso = curso;
    }

    public Foto(long id, byte[] imagem, String tipo, Curso curso) {
        this.id = id;
        this.imagem = imagem;
        this.tipo = tipo;
        this.curso = curso;
    }

    public Foto(byte[] imagem, String tipo, Vaga vaga) {
        this.imagem = imagem;
        this.tipo = tipo;
        this.vaga = vaga;
    }

    public Foto(long id, byte[] imagem, String tipo, Vaga vaga) {
        this.id = id;
        this.imagem = imagem;
        this.tipo = tipo;
        this.vaga = vaga;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

}

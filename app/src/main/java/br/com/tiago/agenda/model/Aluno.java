package br.com.tiago.agenda.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * Created by TiagoCabral on 8/1/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Aluno implements Serializable {

//    @SerializedName("id")
//    @Expose
    private String id;

//    @SerializedName("nome")
//    @Expose
    private String nome;

//    @SerializedName("endereco")
//    @Expose
    private String endereco;

//    @SerializedName("telefone")
//    @Expose
    private String telefone;

    public Aluno() {
    }

    public Aluno(String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public Aluno(String id, String nome, String endereco, String telefone) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return id.concat(" - ")
                .concat(nome);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}

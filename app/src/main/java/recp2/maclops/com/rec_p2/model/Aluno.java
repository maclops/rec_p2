package recp2.maclops.com.rec_p2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Aluno {

    @SerializedName("nome")
    @Expose
    private String nome;
    @SerializedName("nota")
    @Expose
    private int nota;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

}
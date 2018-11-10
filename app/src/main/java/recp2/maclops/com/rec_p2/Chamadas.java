package recp2.maclops.com.rec_p2;

import java.util.List;

import recp2.maclops.com.rec_p2.model.Aluno;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Chamadas {

    @GET("/lista_de_alunos")
    Call<List<Aluno>> obterLista();

}

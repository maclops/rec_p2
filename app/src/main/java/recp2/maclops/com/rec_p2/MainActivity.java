package recp2.maclops.com.rec_p2;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import recp2.maclops.com.rec_p2.model.Aluno;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends ListActivity {
    private final String BASE_URL = "http://angoti.atwebpages.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chamada();
    }

    private Chamadas getRetrofit() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        return (new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()).create(Chamadas.class);
    }

    private void chamada() {

        Call<List<Aluno>> call = getRetrofit().obterLista();

        call.enqueue(new Callback<List<Aluno>>() {
            public void onResponse(Call<List<Aluno>> call,
                                   Response<List<Aluno>> response) {
                Log.i("teste", "não entrou aqui!");
                List<Aluno> aluno = response.body();

                Log.i("teste",aluno.get(0).getNome());
                setListAdapter(new AlunosAdapter(MainActivity.this, aluno));
            }

            public void onFailure(Call<List<Aluno>> call, Throwable t) {
                // Log error here since request failed
                Log.i("teste", t.getMessage());
            }
        });
    }

}
package recp2.maclops.com.rec_p2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import recp2.maclops.com.rec_p2.model.Aluno;

public class AlunosAdapter extends BaseAdapter {

    Context contexto;
    List<Aluno> lista;

    public AlunosAdapter(Context contexto, List<Aluno> lista) {
        this.contexto = contexto;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View linha = LayoutInflater.from(contexto).inflate(R.layout.lista, null);
        Aluno aluno = lista.get(position);

        ImageView imagem = linha.findViewById(R.id.imagem);
        TextView nome = linha.findViewById(R.id.textNome);
        TextView nota = linha.findViewById(R.id.textNota);

        nome.setText(aluno.getNome());
        nota.setText(aluno.getNota()+"");

        if (aluno.getNota() >= 6) {
            imagem.setImageResource(R.drawable.ic_blue_24dp);
        } else {
            imagem.setImageResource(R.drawable.ic_red_24dp);
        }

        return linha;

    }
}


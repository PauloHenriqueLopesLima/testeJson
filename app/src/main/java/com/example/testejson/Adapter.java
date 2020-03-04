package com.example.testejson;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private List<Topping> lista;
    private Context context;
    private String item;

    public Adapter(List<Topping> lista, Context context) {
        this.lista = lista;
        this.context = context;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell,
                parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        item = lista.get(position).getType();
        holder.textView1.setText(item);


    }


    class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView1;


        ViewHolder(View itemView) {
            super(itemView);

            textView1 = itemView.findViewById(R.id.textView);


        }


    }

    @Override
    public int getItemCount() {
        return lista.size();
    }


}

package com.example.bernardo.androidclass.adapters.adaptersmenu;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bernardo.androidclass.R;

/**
 * Created by Bernardo on 15/11/2017.
 */

public class AdapterMenuMassas extends RecyclerView.Adapter<AdapterMenuMassas.ViewHolder> {

    int img[] = {R.drawable.imgmenumassas, R.drawable.imgmenumassas, R.drawable.imgmenumassas, R.drawable.imgmenumassas, R.drawable.imgmenumassas, R.drawable.imgmenumassas, R.drawable.imgmenumassas, R.drawable.imgmenumassas, R.drawable.imgmenumassas, R.drawable.imgmenumassas, R.drawable.imgmenumassas, R.drawable.imgmenumassas, R.drawable.imgmenumassas, R.drawable.imgmenumassas, R.drawable.imgmenumassas, R.drawable.imgmenumassas, R.drawable.imgmenumassas, R.drawable.imgmenumassas, R.drawable.imgmenumassas, R.drawable.imgmenumassas, R.drawable.imgmenumassas, R.drawable.imgmenumassas, R.drawable.imgmenumassas, R.drawable.imgmenumassas};


    @Override
    public AdapterMenuMassas.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_menu_massas, parent, false);
        return new AdapterMenuMassas.ViewHolder(view);


    }

    public AdapterMenuMassas() {
        super();


    }

    @Override
    public void onBindViewHolder(AdapterMenuMassas.ViewHolder holder, int position) {
        holder.ivImage.setImageResource((img[position]));
    }

    @Override
    public int getItemCount() {
        return img.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView ivImage;
        private TextView titulo;


        public ViewHolder(View itemView) {
            super(itemView);

            titulo = (TextView) itemView.findViewById(R.id.titulo);
            ivImage = (ImageView) itemView.findViewById(R.id.ivMenuLocal);
            ivImage.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), "Você clicou no " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
            //view.getContext().startActivity(new Intent(view.getContext(), Cardapio.class));
        }


    }
}

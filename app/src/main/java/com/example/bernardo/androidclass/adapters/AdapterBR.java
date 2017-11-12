package com.example.bernardo.androidclass.adapters;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bernardo.androidclass.Cardapio;
import com.example.bernardo.androidclass.EstiloEscolhido;
import com.example.bernardo.androidclass.R;



/**
 * Created by Bernardo on 11/11/2017.
 */

public class AdapterBR extends RecyclerView.Adapter<AdapterBR.ViewHolder>{

    int img[] = {R.drawable.imgbr, R.drawable.imgbr, R.drawable.imgbr, R.drawable.imgbr, R.drawable.imgbr, R.drawable.imgbr, R.drawable.imgbr, R.drawable.imgbr, R.drawable.imgbr, R.drawable.imgbr};



    @Override
    public AdapterBR.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.brasil_rv, parent, false);
        return new AdapterBR.ViewHolder(view);



    }
    public AdapterBR(){
        super();


    }

    @Override
    public void onBindViewHolder(AdapterBR.ViewHolder holder, int position) {
        holder.ivImage.setImageResource((img[position]));
    }

    @Override
    public int getItemCount() {return img.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
        private ImageView ivImage;
        private TextView titulo;
        public Intent intent;



        public ViewHolder(View itemView){
            super(itemView);

            titulo = (TextView)itemView.findViewById(R.id.titulo);
            ivImage = (ImageView)itemView.findViewById(R.id.ivLocal);
            ivImage.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), "Você clicou no " + getAdapterPosition(), Toast.LENGTH_SHORT).show();

        }


    }


}

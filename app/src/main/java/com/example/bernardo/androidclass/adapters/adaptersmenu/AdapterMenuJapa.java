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

public class AdapterMenuJapa extends RecyclerView.Adapter<AdapterMenuJapa.ViewHolder>{

    int img[] = {R.drawable.imgmenujapa, R.drawable.imgmenujapa, R.drawable.imgmenujapa, R.drawable.imgmenujapa, R.drawable.imgmenujapa, R.drawable.imgmenujapa, R.drawable.imgmenujapa, R.drawable.imgmenujapa, R.drawable.imgmenujapa, R.drawable.imgmenujapa, R.drawable.imgmenujapa, R.drawable.imgmenujapa, R.drawable.imgmenujapa, R.drawable.imgmenujapa, R.drawable.imgmenujapa, R.drawable.imgmenujapa, R.drawable.imgmenujapa, R.drawable.imgmenujapa, R.drawable.imgmenujapa, R.drawable.imgmenujapa, R.drawable.imgmenujapa, R.drawable.imgmenujapa, R.drawable.imgmenujapa, R.drawable.imgmenujapa};



    @Override
    public AdapterMenuJapa.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_menu_generico, parent, false);
        return new AdapterMenuJapa.ViewHolder(view);



    }
    public AdapterMenuJapa(){
        super();


    }

    @Override
    public void onBindViewHolder(AdapterMenuJapa.ViewHolder holder, int position) {
        holder.ivImage.setImageResource((img[position]));
    }

    @Override
    public int getItemCount() {return img.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
        private ImageView ivImage;
        private TextView titulo;




        public ViewHolder(View itemView){
            super(itemView);

            titulo = (TextView)itemView.findViewById(R.id.titulo);
            ivImage = (ImageView)itemView.findViewById(R.id.ivMenuLocal);
            ivImage.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
        }


    }


}


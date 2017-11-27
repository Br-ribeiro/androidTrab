package com.example.bernardo.androidclass.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bernardo.androidclass.Cardapio;
import com.example.bernardo.androidclass.R;

/**
 * Created by Bernardo on 11/11/2017.
 */

public class AdapterFastFood extends RecyclerView.Adapter<AdapterFastFood.ViewHolder>{

    int img[] = {R.drawable.imgfastfood, R.drawable.imgfastfood, R.drawable.imgfastfood, R.drawable.imgfastfood, R.drawable.imgfastfood, R.drawable.imgfastfood, R.drawable.imgfastfood, R.drawable.imgfastfood, R.drawable.imgfastfood, R.drawable.imgfastfood};



    @Override
    public AdapterFastFood.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.generico_rv, parent, false);
        return new AdapterFastFood.ViewHolder(view);
    }
    public AdapterFastFood(){
        super();


    }

    @Override
    public void onBindViewHolder(AdapterFastFood.ViewHolder holder, int position) {
        holder.ivImage.setImageResource((img[position]));
    }

    @Override
    public int getItemCount() {return img.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
        private ImageView ivImage;
        private TextView test;

        public ViewHolder(View itemView){
            super(itemView);

            test = (TextView)itemView.findViewById(R.id.titulo);
            ivImage = (ImageView)itemView.findViewById(R.id.ivLocal);
            ivImage.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            view.getContext().startActivity(new Intent(view.getContext(), Cardapio.class));
        }
    }


}

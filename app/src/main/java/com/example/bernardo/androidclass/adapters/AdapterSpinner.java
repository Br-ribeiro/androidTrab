package com.example.bernardo.androidclass.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bernardo.androidclass.R;

/**
 * Created by Bernardo on 29/10/2017.
 */

public class AdapterSpinner extends BaseAdapter{



    private Context context;
    private int icones[];
    private String[] categorias;
    private LayoutInflater inflater;


    public AdapterSpinner (Context context, int[] icones, String[] categorias){
        this.context = context;
        this.icones = icones;
        this.categorias = categorias;
        this.inflater = (LayoutInflater.from(context));
    }




    @Override
    public int getCount() {
        return icones.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.spinner_row, null);
        ImageView icone = (ImageView) convertView.findViewById(R.id.ivSpinner);
        TextView nomeCat = (TextView)convertView.findViewById(R.id.tvSpinner);
        icone.setImageResource(icones[position]);
        nomeCat.setText(categorias[position]);

        return convertView;
    }
}

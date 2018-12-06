package com.example.administrator.myloginui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2018/12/2.
 */

public class  SingsAdapter extends RecyclerView.Adapter<SingsAdapter.ViewHolder>{
    private List<sings> singsList;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sing_item_layout,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        sings sing = singsList.get(position);
        holder.imageView.setImageResource(sing.getImageid());
        holder.txt_item.setText(sing.getSingsName());
        holder.txt_num.setText(sing.getSingsNum());
    }

    public SingsAdapter(List<sings> singsList) {
        this.singsList = singsList;
    }

    @Override
    public int getItemCount() {
        return singsList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView txt_item;
        TextView txt_num;

        public ViewHolder(View view) {
            super(view);
            imageView = (ImageView)view.findViewById(R.id.img_sing_image);
            txt_item = (TextView)view.findViewById(R.id.txt_item);
            txt_num = (TextView)view.findViewById(R.id.txt_num);
        }
    }
}

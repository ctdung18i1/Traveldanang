package com.example.traveldanang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.traveldanang.R;
import com.example.traveldanang.model.DataShow;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DataShowAdapter extends RecyclerView.Adapter<DataShowAdapter.ViewHolder>{

    ArrayList<DataShow> dataShows;
    Context context;

    public DataShowAdapter(ArrayList<DataShow> dataShows, Context context) {
        this.dataShows = dataShows;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_show,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataShow show = dataShows.get(position);

        holder.txt_ten.setText("Địa điểm: "+show.getTen());
        Picasso.with(context).load(show.getHinhanh()).into(holder.img_hinhanh);
        holder.txt_vitri.setText("Vị trí: "+show.getVitri());
        holder.txt_thongtin.setText("Thông tin: "+show.getThongtin());
        holder.txt_danhgia.setText("Đánh giá: "+show.getDanhgia());
    }

    @Override
    public int getItemCount() {
        return dataShows.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_ten, txt_vitri,txt_thongtin, txt_danhgia;
        ImageView img_hinhanh;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_ten = (TextView)itemView.findViewById(R.id.txt_ten);
            txt_vitri = (TextView)itemView.findViewById(R.id.txt_vitri);
            txt_thongtin = (TextView)itemView.findViewById(R.id.txt_thongtin);
            txt_danhgia = (TextView)itemView.findViewById(R.id.txt_danhgia);
            img_hinhanh = (ImageView)itemView.findViewById(R.id.img_hinhanh);
            img_hinhanh.setScaleType(ImageView.ScaleType.FIT_XY);
        }
    }
}

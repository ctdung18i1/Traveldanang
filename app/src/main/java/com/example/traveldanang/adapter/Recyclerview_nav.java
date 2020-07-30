package com.example.traveldanang.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.traveldanang.R;
import com.example.traveldanang.activity.Thongtin;
import com.example.traveldanang.activity.Caidat;
import com.example.traveldanang.activity.Khampha;
import com.example.traveldanang.activity.MainActivity;
import com.example.traveldanang.activity.Cogimoi;
import com.example.traveldanang.activity.User;
import com.example.traveldanang.model.data_recyclerview_nav;

import java.util.ArrayList;

public class Recyclerview_nav extends RecyclerView.Adapter<Recyclerview_nav.ViewHolder> {

    ArrayList <data_recyclerview_nav> data;
    Context context;

    public Recyclerview_nav(ArrayList<data_recyclerview_nav> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_recycleview_nav,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final data_recyclerview_nav dt = data.get(position);
        holder.img.setImageResource(dt.getHinhanh());
        holder.txtname.setText(dt.getTen());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent =null;
                if (dt.getTen() == "Trang Chủ") {
                    intent = new Intent(context, MainActivity.class);
                    intent.putExtra("name", "đây là " + dt.getTen());
                }
                 if (dt.getTen() == "Tài Khoản") {
                    intent = new Intent(context, User.class);
                    intent.putExtra("name", "đây là " + dt.getTen());
                }
                 if (dt.getTen() == "Có Gì Mới") {
                    intent = new Intent(context, Cogimoi.class);
                    intent.putExtra("title",""+ dt.getTen());
                    intent.putExtra("name", "cogimoi");
                }
                 if (dt.getTen() == "Khám Phá") {
                    intent = new Intent(context, Khampha.class);
                    intent.putExtra("name", "đây là " + dt.getTen());
                }
                 if (dt.getTen() == "Cài Đặt") {
                    intent = new Intent(context, Caidat.class);
                    intent.putExtra("name", "đây là " + dt.getTen());
                }
                if (dt.getTen() == "Hỗ Trợ") {
                    intent = new Intent(context, Thongtin.class);
                    intent.putExtra("name", "đây là " + dt.getTen());
                }
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtname;
        ImageView img;
        RelativeLayout relativeLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = (ImageView)itemView.findViewById(R.id.img_nav);
            img.setScaleType(ImageView.ScaleType.FIT_XY);
            txtname = (TextView)itemView.findViewById(R.id.txt_nav);
            relativeLayout = itemView.findViewById(R.id.relative);
        }
    }
}

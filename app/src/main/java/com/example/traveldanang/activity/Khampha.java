package com.example.traveldanang.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.traveldanang.R;

public class Khampha extends AppCompatActivity {
    Context context;
    Toolbar toolbar;
    Button btn_diadiem, btn_anuong, btn_khachsan, btn_vedem, btn_muasam, btn_phuongtien;
    Button btn_doxe, btn_truonghoc,btn_coquan, btn_benhvien, btn_congty,btn_nganhang,btn_atm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khampha);
        Tbar();
        Onclick();
    }

    private void Onclick() {
        btn_diadiem = (Button)findViewById(R.id.btn_diadiem);
        btn_diadiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Khampha.this,Showoption.class);
                intent.putExtra("name","diadiem");
                intent.putExtra("title",btn_diadiem.getText());
                startActivity(intent);

            }
        });
        btn_anuong = (Button)findViewById(R.id.btn_anuong);
        btn_anuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Khampha.this,Showoption.class);
                intent.putExtra("name","anuong");
                intent.putExtra("title",btn_anuong.getText());
                startActivity(intent);
            }
        });

        btn_khachsan = (Button)findViewById(R.id.btn_khachsan);
        btn_khachsan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Khampha.this,Showoption.class);
                intent.putExtra("name","khachsan");
                intent.putExtra("title",btn_khachsan.getText());
                startActivity(intent);
            }
        });

        btn_vedem = (Button)findViewById(R.id.btn_vedem);
        btn_vedem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Khampha.this,Showoption.class);
                intent.putExtra("name","vedem");
                intent.putExtra("title",btn_vedem.getText());
                startActivity(intent);
            }
        });

        btn_muasam = (Button)findViewById(R.id.btn_muasam);
        btn_muasam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Khampha.this,Showoption.class);
                intent.putExtra("name","muasam");
                intent.putExtra("title",btn_muasam.getText());
                startActivity(intent);
            }
        });

        btn_phuongtien = (Button)findViewById(R.id.btn_phuongtien);
        btn_phuongtien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Khampha.this,Showoption.class);
                intent.putExtra("name","phuongtien");
                intent.putExtra("title",btn_phuongtien.getText());
                startActivity(intent);
            }
        });


    }

    private void Tbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId())
            {
                case android.R.id.home:
                    onBackPressed();
                    return true;

                default:break;
            }

            return super.onOptionsItemSelected(item);
        }
}
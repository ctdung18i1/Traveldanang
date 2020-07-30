package com.example.traveldanang.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.traveldanang.R;
import com.example.traveldanang.adapter.DataShowAdapter;
import com.example.traveldanang.adapter.Recyclerview_nav;
import com.example.traveldanang.model.DataShow;
import com.example.traveldanang.model.data_recyclerview_nav;
import com.google.android.material.navigation.NavigationView;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ViewFlipper viewFlipper;
    RecyclerView recyclerView;
    RecyclerView recyclerView_nav;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Anhxa();
        Actionbar();
        ActionViewFliper();
        Hienthimenu();
        ShowData();

    }

    private void ShowData() {
        // Khởi tạo RecyclerView.
        final RecyclerView rvUsers = (RecyclerView) findViewById(R.id.recyclerview);
        rvUsers.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        // Khởi tạo OkHttpClient để lấy dữ liệu.
        OkHttpClient client = new OkHttpClient();

        // Khởi tạo Moshi adapter để biến đổi json sang model java (ở đây là User)
        Moshi moshi = new Moshi.Builder().build();
        Type DataType = Types.newParameterizedType(List.class,DataShow.class);
        final JsonAdapter<ArrayList<DataShow>> jsonAdapter = moshi.adapter(DataType);

        // Tạo request lên server.
        Request request = new Request.Builder().url("http://192.168.2.42/api/diadiem").build();
        //172.16.0.201 wifi chung
        //192.168.43.244 wifi di động
        // Thực thi request.
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("Lỗi", "Kiểm tra lại internet");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                // Lấy thông tin JSON trả về
                String json = response.body().string();
                final ArrayList<DataShow> dataShows = jsonAdapter.fromJson(json);

                Log.i("okooko", json);

                // Cho hiển thị lên RecyclerView.
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        rvUsers.setAdapter(new DataShowAdapter(dataShows,MainActivity.this));
                    }
                });
            }
        });
    }

    private void Hienthimenu() {
        recyclerView_nav.setHasFixedSize(false);
        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView_nav.setLayoutManager(gridLayoutManager);

//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplication(), LinearLayoutManager.VERTICAL, false);
//        recyclerView_nav.setLayoutManager(linearLayoutManager);

        ArrayList<data_recyclerview_nav> arrayList = new ArrayList<>();
        arrayList.add(new data_recyclerview_nav(R.drawable.home,"Trang Chủ"));
        arrayList.add(new data_recyclerview_nav(R.drawable.user,"Tài Khoản"));
        arrayList.add(new data_recyclerview_nav(R.drawable.bell,"Có Gì Mới"));
        arrayList.add(new data_recyclerview_nav(R.drawable.global,"Khám Phá"));
        arrayList.add(new data_recyclerview_nav(R.drawable.gear,"Cài Đặt"));
        arrayList.add(new data_recyclerview_nav(R.drawable.infor,"Hỗ Trợ"));


        Recyclerview_nav recyclerview_nav = new Recyclerview_nav( arrayList,getApplication());
        recyclerView_nav.setAdapter(recyclerview_nav);

    }

    private void ActionViewFliper() {
        ArrayList<String> mangquangcao = new ArrayList<>();
        mangquangcao.add("https://bkkaruncloud.b-cdn.net/wp-content/uploads/2019/05/ho-chi-minh-to-da-nang.jpg");
        mangquangcao.add("https://www.baodanang.vn/dataimages/202003/original/images1552376_telegraph_co_uk_tai_sao_ban_nen_ghe_tham_da_nang_viet_nam_nam_2019_nay_012.jpg");
        for (int i = 0; i <mangquangcao.size();i++) {
            ImageView imageView = new ImageView(getApplicationContext());
            Picasso.with(getApplicationContext()).load(mangquangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);
        Animation animation_slide_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right);
        Animation animation_slide_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out_right);
        viewFlipper.setInAnimation(animation_slide_in);
        viewFlipper.setOutAnimation(animation_slide_out);
    }


    private void Actionbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.nav);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    private void Anhxa() {
        toolbar = (Toolbar)findViewById(R.id.toolbar_trangchinh);
        viewFlipper = (ViewFlipper) findViewById(R.id.view_flipper);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        recyclerView_nav =(RecyclerView)findViewById(R.id.recyclerview_nav);
        navigationView = (NavigationView)findViewById(R.id.navigation);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawerlayout);

    }
}

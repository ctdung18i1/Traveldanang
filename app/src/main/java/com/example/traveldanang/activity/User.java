package com.example.traveldanang.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.traveldanang.R;
public class User extends AppCompatActivity {

    TextView textView;
    EditText txt_tk, txt_mk;
    Button button;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        textView = (TextView)findViewById(R.id.textView);
        txt_tk = (EditText)findViewById(R.id.txt_tk);
        txt_mk = (EditText)findViewById(R.id.txt_mk);
        button = (Button)findViewById(R.id.button);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null);
        String tk = bundle.getString("name");
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
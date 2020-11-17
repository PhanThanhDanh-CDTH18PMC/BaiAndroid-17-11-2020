package com.example.buger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.bumptech.glide.Glide;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Glide.with(this).load(R.drawable.logo).into((ImageView)findViewById(R.id.imageView));

    }

    public void btnLevel_click(View v) throws ExecutionException, InterruptedException {
        Button btn = (Button)v;
        String lst=new APIGetting(this).execute(v.getId()==R.id.buttonHard?"1":"2").get();
    }
}
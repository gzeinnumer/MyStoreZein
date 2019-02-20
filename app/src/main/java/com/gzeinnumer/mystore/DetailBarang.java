package com.gzeinnumer.mystore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gzeinnumer.mystore.Data.DataBaju;
import com.gzeinnumer.mystore.Data.DataModel;

import java.util.ArrayList;

public class DetailBarang extends AppCompatActivity {
    ImageView imageViewDet;
    TextView namaDet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_barang);
        Intent intent= getIntent();
        int id = intent.getIntExtra("id",0);
        String nama =  intent.getStringExtra("nama");
        String image =  intent.getStringExtra("image");
        String jenis =  intent.getStringExtra("jenis");
        String harga =  intent.getStringExtra("harga");
        String desc =  intent.getStringExtra("desc");
        String ukuran =  intent.getStringExtra("ukuran");
        int stok =  intent.getIntExtra("stok",0);


        imageViewDet=findViewById(R.id.imgDet);
        namaDet = findViewById(R.id.namaDet);
        Glide.with(this).load(image).into(imageViewDet);
        namaDet.setText(nama);
    }
}

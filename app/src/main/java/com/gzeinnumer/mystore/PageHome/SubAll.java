package com.gzeinnumer.mystore.PageHome;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.gzeinnumer.mystore.Data.DataBaju;
import com.gzeinnumer.mystore.Data.DataModel;
import com.gzeinnumer.mystore.DetailBarang;
import com.gzeinnumer.mystore.R;

import java.util.ArrayList;


public class SubAll extends Fragment {

    Context context;
    View view;
    RecyclerView recyclerViewAll;


    DataBaju data = new DataBaju();

    public SubAll() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_sub_all, container, false);
        recyclerViewAll = view.findViewById(R.id.recyclerViewAll);

        context = view.getContext();


        AdapterAll adapterAll = new AdapterAll(context,data.list);
        recyclerViewAll.setAdapter(adapterAll);
        GridLayoutManager layoutManager = new GridLayoutManager(context,2);
        recyclerViewAll.setLayoutManager(layoutManager);

        return view;
    }




    class AdapterAll extends RecyclerView.Adapter<AdapterAll.MyViewHolder>{
        Context mContext;
        ArrayList<DataModel> mList;


        public AdapterAll(Context context, ArrayList<DataModel> mList) {
            this.mContext = context;
            this.mList = mList;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_sub_all_item,viewGroup,false);
            MyViewHolder myViewHolder = new MyViewHolder(view);
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {

            final DataModel currentItem = mList.get(i);
            myViewHolder.indexNama.setText(currentItem.getNama());
            myViewHolder.indexHarga.setText(String .valueOf(currentItem.getHarga()));

            Glide.with(mContext).load(currentItem.getImage()).into(myViewHolder.indexImage);

            myViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(mContext,String.valueOf(i),Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mContext, DetailBarang.class);
                    intent.putExtra("id",currentItem.getId());
                    intent.putExtra("nama",currentItem.getNama());
                    intent.putExtra("image",currentItem.getImage());
                    intent.putExtra("jenis",currentItem.getJenis());
                    intent.putExtra("harga",currentItem.getHarga());
                    intent.putExtra("desc",currentItem.getDesc());
                    intent.putExtra("ukuran",currentItem.getUkuran());
                    intent.putExtra("stok",currentItem.getStok());
                    startActivity(intent);
                }
            });

        }

        @Override
        public int getItemCount() {
            return mList.size();
        }


        class MyViewHolder extends RecyclerView.ViewHolder{

            ImageView indexImage;
            TextView indexNama, indexHarga;
            CardView cardView;
            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                indexImage = itemView.findViewById(R.id.imgList);
                indexNama = itemView.findViewById(R.id.namaList);
                indexHarga = itemView.findViewById(R.id.hargaList);
                cardView = itemView.findViewById(R.id.cardList);
            }
        }
    }


}

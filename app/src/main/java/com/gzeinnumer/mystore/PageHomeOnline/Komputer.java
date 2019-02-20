package com.gzeinnumer.mystore.PageHomeOnline;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.gzeinnumer.mystore.Data.DataBajuOnline;
import com.gzeinnumer.mystore.Data.DataModelOnline;
import com.gzeinnumer.mystore.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Komputer extends Fragment {

    RecyclerView recyclerViewOnline;
    AdapterKomputer adapter;
    DataBajuOnline dataBajuOnline = new DataBajuOnline();
    private RequestQueue mQueue;

    View view;
    public Komputer() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_komputer, container, false);
        recyclerViewOnline = view.findViewById(R.id.recyclerViewOnline);
        initRecycler();
        getJSON("http://androidzein.000webhostapp.com/selectProduct.php");

        mQueue = Volley.newRequestQueue(view.getContext());

        return view;
    }

    private void initRecycler() {

        adapter = new AdapterKomputer(view.getContext(),dataBajuOnline.listOnline);
        recyclerViewOnline.setLayoutManager(new GridLayoutManager(view.getContext(),2));
        recyclerViewOnline.setAdapter(adapter);
    }

    private void getJSON(final String mUrl) {
        class GetJSON extends AsyncTask<Void, Void,String>{


            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                //Toast.makeText(getContext(),s,Toast.LENGTH_SHORT).show();

                JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST,
                        "http://androidzein.000webhostapp.com/selectProduct.php",
                        null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    JSONArray jsonArray = response.getJSONArray("products");
                                    for(int i =0; i<jsonArray.length(); i++){
                                        JSONObject product = jsonArray.getJSONObject(i);
                                        int id = product.getInt("id");
                                        String title = product.getString("title");
                                        String description = product.getString("desciption"); //description
                                        double rating = product.getDouble("rating");
                                        double price= product.getDouble("price");
                                        String image = product.getString("image");
                                        dataBajuOnline.listOnline.add(new DataModelOnline(id, title, description, rating, price, image));
                                        adapter.notifyDataSetChanged();
                                        initRecycler();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                mQueue.add(request);
            }

            @Override
            protected String doInBackground(Void... voids) {
                try {
                    URL url = new URL(mUrl);

                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                    StringBuilder sb = new StringBuilder();

                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                    String json;

                    while ((json = bufferedReader.readLine())!=null){
                        sb.append(json + "\n");
                    }

                    return sb.toString().trim();
                }  catch (Exception e){
                    return null;
                }
            }
        }

        GetJSON getJSON = new GetJSON();
        getJSON.execute();
    }

    public class AdapterKomputer extends RecyclerView.Adapter<AdapterKomputer.MyHolder>{
        Context mContext;
        ArrayList<DataModelOnline> mList;

        public AdapterKomputer(Context mContext, ArrayList<DataModelOnline> mList) {
            this.mContext = mContext;
            this.mList = mList;
        }

        @NonNull
        @Override
        public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.fragment_sub_all_item_online,viewGroup,false);
            MyHolder myHolder = new MyHolder(view);
            return myHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {
            DataModelOnline dataModelOnline = mList.get(i);
            myHolder.textViewTitle.setText(dataModelOnline.getTitle());
            myHolder.textViewHarga.setText(String.valueOf(dataModelOnline.getPrice()));
            Glide.with(mContext).load(dataModelOnline.getImage()).into(myHolder.imageView);
            myHolder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext,"hay",Toast.LENGTH_SHORT).show();
                }
            });

        }

        @Override
        public int getItemCount() {
            return mList.size();
        }

        class MyHolder extends RecyclerView.ViewHolder{
            ImageView imageView;
            TextView textViewTitle, textViewHarga;
            CardView cardView;
            public MyHolder(@NonNull View itemView) {
                super(itemView);
                cardView = itemView.findViewById(R.id.cardListOnline);
                imageView = itemView.findViewById(R.id.imgList);
                textViewTitle = itemView.findViewById(R.id.namaList);
                textViewHarga = itemView.findViewById(R.id.hargaList);
            }
        }
    }


}

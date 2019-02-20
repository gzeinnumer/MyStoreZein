package com.gzeinnumer.mystore.Data;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class DataBaju {
    public ArrayList<DataModel> list = new ArrayList<>();




    public DataBaju() {
        initData();

//        initDataOnline("http://androidzein.000webhostapp.com/select.php");


    }

    private void initData() {
        list.clear();
        list.add(new DataModel(
                1,
                "Baju",
                "https://cf.shopee.co.id/file/b2c0bbf5ad5c044723313ea479a3e3b1",
                "dress",
                50000,
                "ini baju",
                "M",
                1
        ));

        list.add(new DataModel(
                1,
                "Baju",
                "https://cf.shopee.co.id/file/b2c0bbf5ad5c044723313ea479a3e3b1",
                "dress",
                50000,
                "ini baju",
                "M",
                1
        ));

        list.add(new DataModel(
                1,
                "Baju",
                "https://cf.shopee.co.id/file/b2c0bbf5ad5c044723313ea479a3e3b1",
                "dress",
                50000,
                "ini baju",
                "M",
                1
        ));

        list.add(new DataModel(
                1,
                "Baju",
                "https://cf.shopee.co.id/file/b2c0bbf5ad5c044723313ea479a3e3b1",
                "dress",
                50000,
                "ini baju",
                "M",
                1
        ));

        list.add(new DataModel(
                1,
                "Baju",
                "https://cf.shopee.co.id/file/b2c0bbf5ad5c044723313ea479a3e3b1",
                "dress",
                50000,
                "ini baju",
                "M",
                1
        ));

        list.add(new DataModel(
                1,
                "Baju",
                "https://cf.shopee.co.id/file/b2c0bbf5ad5c044723313ea479a3e3b1",
                "dress",
                50000,
                "ini baju",
                "M",
                1
        ));

        list.add(new DataModel(
                1,
                "Baju",
                "https://ecs7.tokopedia.net/img/cache/700/product-1/2017/10/30/595597/595597_10896c19-4162-4a08-b7fc-9ccfe9111821_1280_1280.jpeg",
                "pants",
                50000,
                "ini baju",
                "M",
                1
        ));


    }
}

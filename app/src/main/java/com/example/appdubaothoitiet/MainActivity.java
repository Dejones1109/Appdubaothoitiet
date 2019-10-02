package com.example.appdubaothoitiet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {


    EditText editSearch;
    Button btnSearch,btnChangeActivity;
    TextView txtName,txtCountry,txtTemp,txtStatus,txtHumiduty,txtCloud,txtAriQuarity,txtWind,txtDays;
    ImageView imgIcon;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String city = editSearch.getText().toString();
                GetCurrentWeatherData(city);
            }
        });
    }
 public  void GetCurrentWeatherData(String data){
     RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
     String url = "http://api.openweathermap.org/data/2.5/find?q="+data+
             "&units=metric&appid=8c0fccf90cc5b7820144740197beff51";
     StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
             new Response.Listener<String>() {
                 @Override
                 public void onResponse(String response) {
                  Log.d("ket qua",response);
                 }
             },
             new Response.ErrorListener() {
                 @Override
                 public void onErrorResponse(VolleyError error) {

                 }
             }


     );
     requestQueue.add(stringRequest);

 }
    private void AnhXa() {
        editSearch = (EditText) findViewById(R.id.textSearch);
        btnSearch = (Button) findViewById(R.id.btnSearch);
        btnChangeActivity = (Button) findViewById(R.id.changeActivity);
        txtName = (TextView) findViewById(R.id.NameCity);
        txtCountry = (TextView) findViewById(R.id.NameCountry);
        txtTemp = (TextView) findViewById(R.id.Temp);
        txtHumiduty = (TextView) findViewById(R.id.textHumidity);
        txtStatus = (TextView) findViewById(R.id.Status);
        txtCloud = (TextView) findViewById(R.id.textCloud);
        txtWind = (TextView) findViewById(R.id.textSpeedWind);
        txtTemp = (TextView) findViewById(R.id.Temp);
        txtAriQuarity =   (TextView) findViewById(R.id.textAirQuality);
        txtDays = (TextView) findViewById(R.id.textDay);
        imgIcon = (ImageView) findViewById(R.id.imageIcon);



    }

}

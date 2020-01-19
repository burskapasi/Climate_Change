package com.example.climatechange;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DataActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

     private TextView mTextViewResults;
     private RequestQueue mQueue;
     private Spinner spinner;
     private Spinner spinner1;
    ArrayList<String> flightArray = new ArrayList<>(); // Create an ArrayList object

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        spinner = findViewById(R.id.spinnerFrom);
        spinner1 = findViewById(R.id.spinnerTo);
        mTextViewResults = findViewById(R.id.textView);

        //Queue Request
        mQueue = Volley.newRequestQueue(this);
        String url = "https://api.nutritionix.com/v1_1/search/mcdonalds?results=0:20&fields=item_name,brand_name,item_id,nf_calories&appId=5db103e5&appKey=80651e4e2c675a2f87fe6a7c8ca9a5da";
        //airline string
        final String[] airline = {"", "", "", "", ""};
        airline[0] = "";
        //price string
        final String[] price = {"", "", "", "", ""};
        price[0] = "";
        //price string
        final String[] seats = {"", "", "", "", ""};
        seats[0] = "";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject flight = new JSONObject(response);

                            JSONArray results = flight.getJSONArray("hits");


                            for (int i = 0; i < 5; i++) {


                                String airlineRecord = results.getJSONObject(i).getString("_index");
                                String PriceRecord = results.getJSONObject(i).getString("_type");
                                String SeatsRecord = results.getJSONObject(i).getString("fields");
                                airline[i] = airlineRecord;
                                price[i] = PriceRecord;
                                seats[i] = SeatsRecord;


                                //textbox
                                flightArray.add(airlineRecord);
                                flightArray.add(PriceRecord);
                                flightArray.add(SeatsRecord);
                               // mTextViewResults.setText(flightArray.toString());
                                System.out.println(flightArray.toString());
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mTextViewResults.setText("That didn't work!");
            }
        });

// Add the request to the RequestQueue.
        mQueue.add(stringRequest);

        //spinner
        ArrayAdapter<String> adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, price);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        //spinner 1
        ArrayAdapter adapter1 = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, price);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(this);


    }

    // Defining the Callback methods here
    public void onItemSelected(AdapterView parent, View view, int pos,
                               long id) {


    }


    // Defining the Callback methods here
    @Override
    public void onNothingSelected(AdapterView arg0) {
// TODO Auto-generated method stub

    }


}
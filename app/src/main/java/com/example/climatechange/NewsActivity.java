package com.example.climatechange;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class NewsActivity extends AppCompatActivity {
    private TextView textbox;
    private TextView textbox1;
    private TextView textbox2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        textbox = findViewById(R.id.textView2);
        requestWithSomeHttpHeaders();

        textbox1 = findViewById(R.id.textView4);
        requestWithSomeHttpHeaders();
        textbox2 = findViewById(R.id.textView5);
        requestWithSomeHttpHeaders();


    }
    public String requestWithSomeHttpHeaders() {
        RequestQueue queue = Volley.newRequestQueue(this);
        final String data = "";
        String url = "https://newsapi.org/v2/everything?q=bitcoin&from=2019-12-19&sortBy=publishedAt&apiKey=85b54447eff345e993f93b14ca6a1c96";
        StringRequest getRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        // JSON OBJECT
                        try {
                            JSONObject obj = new JSONObject(response);
                            System.out.println(obj.toString());

                           textbox.setText(obj.getJSONArray("articles").getJSONObject(0).getString("title"));
                           textbox1.setText(obj.getJSONArray("articles").getJSONObject(0).getString("description"));
                            textbox2.setText(obj.getJSONArray("articles").getJSONObject(0).getString("description"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        // Get data from JSON object
                        Log.d("Response", response);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub
                        Log.d("ERROR","error => "+error.toString());
                    }
                }
        ) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("title", "description");
                params.put("publishedAt", "content");

                return params;
            }
        };
        queue.add(getRequest);
        return "Didn't work";

    }
}

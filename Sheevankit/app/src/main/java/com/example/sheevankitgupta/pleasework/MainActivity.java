package com.example.sheevankitgupta.pleasework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    int total_positive_score = 0;
    int total_negative_score = 0;
    int walking_score = 0;
    int biking_score = 0;
    int car_score = 0;
    int plane_score = 0;
    int bus_score = 0;
    int rowing_score = 0;
    double co2 = 0;

    private Button walking;
    private Button biking;
    private Button car;
    private Button bus;
    private Button plane;
    private Button rowing;

    private EditText walkingtext;
    private EditText bikingtext;
    private EditText cartext;
    private EditText bustext;
    private EditText planetext;
    private EditText rowtext;


    TextView tv;
    TextView tv2;
    TextView tv4;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        walkingtext = findViewById(R.id.walk_text);
        bikingtext = findViewById(R.id.bike_text);
        cartext = findViewById(R.id.car_text);
        bustext = findViewById(R.id.bus_text);
        planetext = findViewById(R.id.plane_text);
        rowtext = findViewById(R.id.row_text);


        tv = findViewById(R.id.textView);
        tv2 = findViewById(R.id.textView2);
        tv4 = findViewById(R.id.textView4);


        walking = findViewById(R.id.walking_add);
        biking = findViewById(R.id.biking_add);
        car = findViewById(R.id.car_add);
        bus = findViewById(R.id.bus_add);
        plane = findViewById(R.id.plane_add);
        rowing = findViewById(R.id.row_add);



        walking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String str1 = walkingtext.getText().toString();
                int w = Integer.parseInt(str1);
                walking_score = walking_score + 50*w;
                Toast.makeText(MainActivity.this, "Yay! " + 50*w + " good points added!", Toast.LENGTH_SHORT).show();
                total_positive_score = biking_score + walking_score + rowing_score;
                total_negative_score = bus_score + car_score + plane_score;
                tv.setText(Integer.toString(total_positive_score));
                tv2.setText(Integer.toString(total_negative_score));



                //walking_score = walking_score + 10*walkingtext ;
               //Toast.makeText(MainActivity.this, ""+t, Toast.LENGTH_SHORT).show();

            }
        });




        biking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str2 = bikingtext.getText().toString();
                int b = Integer.parseInt(str2);
                biking_score = biking_score + 25*b;
                Toast.makeText(MainActivity.this, "Yay! " + 25*b + " good points added!", Toast.LENGTH_SHORT).show();
                total_positive_score = biking_score + walking_score + rowing_score;
                total_negative_score = bus_score + car_score + plane_score;
                tv.setText(Integer.toString(total_positive_score));
                tv2.setText(Integer.toString(total_negative_score));


            }
        });



        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str3 = cartext.getText().toString();
                int c = Integer.parseInt(str3);
                car_score = car_score + 200*c;
                co2 = co2 + (0.5)*c;
                Toast.makeText(MainActivity.this, "Your car emitted " + (0.5*c) + " kg of Co2!", Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, 200*c + " bad points added!", Toast.LENGTH_SHORT).show();
                total_positive_score = biking_score + walking_score + rowing_score;
                total_negative_score = bus_score + car_score + plane_score;
                tv.setText(Integer.toString(total_positive_score));
                tv2.setText(Integer.toString(total_negative_score));
                tv4.setText(Double.toString(co2));

            }
        });

        bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str4 = bustext.getText().toString();
                int bu = Integer.parseInt(str4);
                bus_score = bus_score + 100*bu;
                co2 = co2 + (0.08)*bu;
                Toast.makeText(MainActivity.this, "You emitted " + (0.08*bu) + " kg of Co2! But that's better than taking a car so good job!", Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, 100*bu + " bad points added!", Toast.LENGTH_SHORT).show();
                total_positive_score = biking_score + walking_score + rowing_score;
                total_negative_score = bus_score + car_score + plane_score;
                tv.setText(Integer.toString(total_positive_score));
                tv2.setText(Integer.toString(total_negative_score));
                tv4.setText(Double.toString(co2));

            }
        });


        plane.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str5 = planetext.getText().toString();
                int p = Integer.parseInt(str5);
                plane_score = plane_score + 500*p;
                co2 = co2 + (0.08)*p;
                Toast.makeText(MainActivity.this, "You emitted " + (0.3*p) + " kg of Co2!", Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, "No! " + 500*p + " bad points added!", Toast.LENGTH_SHORT).show();
                total_positive_score = biking_score + walking_score + rowing_score;
                total_negative_score = bus_score + car_score + plane_score;
                tv.setText(Integer.toString(total_positive_score));
                tv2.setText(Integer.toString(total_negative_score));
                tv4.setText(Double.toString(co2));
            }
        });


        rowing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str6 = rowtext.getText().toString();
                int r = Integer.parseInt(str6);
                rowing_score = rowing_score + 20*r;
                Toast.makeText(MainActivity.this, "Yay! " + 20*r + " points added!", Toast.LENGTH_SHORT).show();
                total_positive_score = biking_score + walking_score + rowing_score;
                total_negative_score = bus_score + car_score + plane_score;
                tv.setText(Integer.toString(total_positive_score));
                tv2.setText(Integer.toString(total_negative_score));
            }
        });




    }
}

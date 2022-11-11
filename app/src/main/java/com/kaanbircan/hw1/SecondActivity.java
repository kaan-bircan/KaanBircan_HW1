package com.kaanbircan.hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView textViewdisplay;
    EditText Value1,Value2;
    Button BackButton,CalculateButton;
    ImageView imgV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        textViewdisplay = findViewById(R.id.textViewdisplay);
        BackButton = findViewById(R.id.BackButtonSecond);
        CalculateButton = findViewById(R.id.buttonCalculate);
        Value1 = findViewById(R.id.Value1);
        Value2 = findViewById(R.id.Value2);
        imgV = findViewById(R.id.imgViewSecond);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        String Name = b.getString("EtName");
        String Surname = b.getString("EtSurname");
        String imgName = b.getString("imgName");
        int imgPos = b.getInt("ImgPos");
        textViewdisplay.setText("User Name: "+Name+"\n"+"User Surname: "+Surname+"\n"+ "Supporting Team: " +imgName);

        int ImgArray[] = {R.drawable.fb,R.drawable.gs,R.drawable.bjk};
        imgV.setImageResource(ImgArray[imgPos]);

        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });
        CalculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
                int v1 = Integer.parseInt(Value1.getText().toString());
                int v2 = Integer.parseInt(Value2.getText().toString());

                double hypo = Math.sqrt(v1*v1 + v2*v2);
                Bundle b = new Bundle();
                b.putInt("v1",v1);
                b.putInt("v2",v2);
                b.putDouble("hypo",hypo);


                intent.putExtras(b);
                startActivity(intent);


            }
        });
    }
}
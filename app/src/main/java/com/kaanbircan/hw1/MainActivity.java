package com.kaanbircan.hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvTitleFirst;
    EditText EtName,EtSurname;
    Button SecondActivityBtn;
    Spinner spinnerTeams;
    ImageView imgV;
    private int ImgPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);



        tvTitleFirst = findViewById(R.id.tvTitleFirst);
        SecondActivityBtn = findViewById(R.id.SecondActivityBtn);
        EtName = findViewById(R.id.EtName);
        EtSurname = findViewById(R.id.EtSurname);
        spinnerTeams = findViewById(R.id.spinnerMain);
        imgV = findViewById(R.id.imageViewMain);

        int[] imgSources = {R.drawable.fb, R.drawable.gs,R.drawable.bjk};


        spinnerTeams.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                imgV.setImageResource(imgSources[i]);
                String imgName = spinnerTeams.getSelectedItem().toString();
                ImgPos = i;
                Toast.makeText(MainActivity.this,imgName+" is selected." , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Animation anim = new AlphaAnimation(0.0f,1.0f);
        anim.setDuration(50); //You can manage the blinking time with this parameter
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        tvTitleFirst.startAnimation(anim);


        SecondActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                String name = EtName.getText().toString();
                String surname = EtSurname.getText().toString();
                Bundle b = new Bundle();

                b.putString("EtName",name);
                b.putString("EtSurname", surname);
                b.putString("imgName", spinnerTeams.getSelectedItem().toString());
                b.putInt("ImgPos", ImgPos);


                intent.putExtras(b);
                startActivity(intent);
            }
        });

    }

}
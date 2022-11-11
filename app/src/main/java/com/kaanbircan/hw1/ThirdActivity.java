package com.kaanbircan.hw1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
    TextView calculationstv;
    Button RestartButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        calculationstv = findViewById(R.id.calculationstv);
        RestartButton = findViewById(R.id.BackTheMain);
        RestartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThirdActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        Intent intentThird = getIntent();
        Bundle b = intentThird.getExtras();
        int value1 = b.getInt("v1");
        int value2 = b.getInt("v2");
        double hypo = b.getDouble("hypo");
        String message = "The hypothenuse value of "+value1+" and "+value2 +"\n" +hypo;
        makeAndShowDialog(message);

        calculationstv.setText("Congrats!!! Click the button below to try application again."+"\n");
    }
    private void makeAndShowDialog(String message) {
        AlertDialog.Builder box = new AlertDialog.Builder(this);
        box.setTitle("Alert Dialog");
        box.setMessage(message);
        box.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        box.create();
        box.show();
    }
}
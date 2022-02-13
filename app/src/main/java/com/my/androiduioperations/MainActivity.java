package com.my.androiduioperations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.my.dgnsyalertdialogs.CustomAlertDialog;
import com.my.dgnsyalertdialogs.OnAlertSelectListener;

public class MainActivity extends AppCompatActivity implements OnAlertSelectListener {
    Button btn;
    CustomAlertDialog alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert = new CustomAlertDialog(MainActivity.this,2,"UYARI" , "EVET","HAYIR" , "",MainActivity.this);
                alert.showMyCustomAlertDialog();
            }
        });
    }

    @Override
    public void isSelected(int buttonType) {
        System.out.println("BASILDI : " + buttonType);
    }
}

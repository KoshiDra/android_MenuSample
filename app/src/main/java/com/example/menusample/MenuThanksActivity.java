package com.example.menusample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MenuThanksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_thanks);

        Intent intent = getIntent();
        String menu = intent.getStringExtra("menu");
        String price = intent.getStringExtra("price");

        TextView tv1 = findViewById(R.id.tvMenuName);
        tv1.setText(menu);

        TextView tv2 = findViewById(R.id.tvMenuPrice);
        tv2.setText(price);
    }

    public void onBackButtonClick(View v) {
        // 戻るボタン押下（アクティビティの終了）
        finish();
    }
}
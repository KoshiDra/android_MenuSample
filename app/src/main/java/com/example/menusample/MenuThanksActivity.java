package com.example.menusample;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
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

        // -- アクションバーに「戻る」メニューを表示
        // アクションバーを取得
        ActionBar actionBar = getSupportActionBar();

        // アクションバーの「戻る」メニューを有効化
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    /**
     * 「戻る」メニュー選択時の処理
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        boolean retval = true;

        // 選択されたメニューIDを取得
        int itemId = item.getItemId();
        if (itemId == android.R.id.home) {
            // 選択されたメニューが「戻る」の場合はアクティビティを終了
            finish();
        } else {
            retval = super.onOptionsItemSelected(item);
        }

        return retval;
    }
}
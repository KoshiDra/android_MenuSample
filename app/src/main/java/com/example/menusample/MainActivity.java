package com.example.menusample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ListView lv;

    private List<Map<String, Object>> menuList;

    // 画面部品に割り当てるMapのキー配列
    private static final String[] FROM = {"name", "price"};

    // fromのMapのキー名に対応してデータが割り当てられる画面部品のR値配列
    private static final int[] TO = {R.id.tvMenuNameRow, R.id.tvMenuPriceRow};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lvMenu);

        // ----------------------------------------------------------------------------------------------------------------------------------
        // メニューリスト作成
        menuList = createTeisyokuMenu();

        SimpleAdapter adapter = new SimpleAdapter(MainActivity.this, menuList, R.layout.row, FROM, TO);

        lv.setAdapter(adapter);
        // ----------------------------------------------------------------------------------------------------------------------------------

        // メニュータップ時のリスナ設定
        lv.setOnItemClickListener(new ListItemClickListener());

        registerForContextMenu(lv);
    }

    private List<Map<String, Object>> createTeisyokuMenu() {

        List<Map<String, Object>> menuList = new ArrayList<>();

        Map<String, Object> menu = new HashMap<>();
        menu.put("name", "唐揚げ定食");
        menu.put("price", 850);
        menu.put("desc", "***********************************");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "ハンバーグ定食");
        menu.put("price", 800);
        menu.put("desc", "***********************************");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "生姜焼き定食");
        menu.put("price", 500);
        menu.put("desc", "***********************************");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "ステーキ定食");
        menu.put("price", 1850);
        menu.put("desc", "***********************************");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "野菜炒め定食");
        menu.put("price", 670);
        menu.put("desc", "***********************************");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "とんかつ定食");
        menu.put("price", 1000);
        menu.put("desc", "***********************************");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "ミンチかつ定食");
        menu.put("price", 900);
        menu.put("desc", "***********************************");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "チキンカツ定食");
        menu.put("price", 950);
        menu.put("desc", "***********************************");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "コロッケ定食");
        menu.put("price", 800);
        menu.put("desc", "***********************************");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "回鍋肉定食");
        menu.put("price", 1100);
        menu.put("desc", "***********************************");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "麻婆豆腐定食");
        menu.put("price", 1000);
        menu.put("desc", "***********************************");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "豆板醬定食");
        menu.put("price", 700);
        menu.put("desc", "***********************************");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "焼き魚定食");
        menu.put("price", 820);
        menu.put("desc", "***********************************");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "焼肉定食");
        menu.put("price", 930);
        menu.put("desc", "***********************************");
        menuList.add(menu);

        return menuList;
    }

    private List<Map<String, Object>> createCurryMenu() {

        List<Map<String, Object>> menuList = new ArrayList<>();

        Map<String, Object> menu = new HashMap<>();
        menu.put("name", "ビーフカレー");
        menu.put("price", 850);
        menu.put("desc", "***********************************");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "野菜カレー");
        menu.put("price", 530);
        menu.put("desc", "***********************************");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "ポークカレー");
        menu.put("price", 1000);
        menu.put("desc", "***********************************");
        menuList.add(menu);

        return menuList;
    }

    /**
     * オプションメニュー作成
     * @param menu
     * @return 規定でtrueを返す
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // メニューインフレーターの取得
        MenuInflater inflater = getMenuInflater();

        // オプションメニュー用のxnlファイルをインフレート
        inflater.inflate(R.menu.menu_options_menu_list, menu);

        return true;
    }

    /**
     * オプションメニュー選択時処理
     * @param item 選択したオプション
     * @return 規定でtrueを返す
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        boolean returnVal = true;

        int itemId = item.getItemId();

        switch (itemId) {
            case R.id.menuListOptionTeisyoku:
                menuList = createTeisyokuMenu();
                break;
            case R.id.menuListOptionCurry:
                menuList = createCurryMenu();
                break;
            default:
                returnVal = super.onOptionsItemSelected(item);
                break;
        }

        SimpleAdapter adapter = new SimpleAdapter(MainActivity.this, menuList, R.layout.row, FROM, TO);
        lv.setAdapter(adapter);

        return returnVal;
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {

        // 親クラスの同名メソッドの呼び出し
        super.onCreateContextMenu(menu, view, menuInfo);

        // メニューインフレーター取得
        MenuInflater inflater = getMenuInflater();

        // コンテキストメニュー用xmlファイルをインフレート
        inflater.inflate(R.menu.menu_context_menu_list, menu);

        // コンテキストメニューのヘッダタイトルを設定
        menu.setHeaderTitle(R.string.menu_list_context_header);
    }

    private class ListItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            // タップされた行データ取得（データはMap型）
            Map<String, Object> map = (Map<String, Object>) parent.getItemAtPosition(position);

            String menu = (String) map.get("name");
            Integer price = (Integer) map.get("price");
            String desc = (String) map.get("desc");

            // 第二画面への引数設定
            Intent intent = new Intent(MainActivity.this, MenuThanksActivity.class);
            intent.putExtra("menu", menu);
            intent.putExtra("price", price + getString(R.string.tv_menu_unit));

            // 第二画面の起動
            startActivity(intent);
        }
    }
}
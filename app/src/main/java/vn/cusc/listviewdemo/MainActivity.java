package vn.cusc.listviewdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] ds = { "Nguyễn Văn An", "Trần Thị C", "Lê Long Đỉnh",
            "Mã Văn Tấu", "Ngô Thanh Long", "Bành Tuấn Phong", "Châu Thanh Hậu",
            "Nguyễn Văn An", "Trần Thị C", "Lê Long Đỉnh",
            "Mã Văn Tấu", "Ngô Thanh Long", "Bành Tuấn Phong", "Châu Thanh Hậu"};
    ArrayAdapter<String> adp;
    ListView lvDSSinhVien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvDSSinhVien = (ListView) findViewById(R.id.lvDanhSachSinhVien);

        // thanh phan ho tro chuyen tung phan tu trong tap hop ds len
        // giao dien listview
        adp = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, ds);
        // chi dinh doi tuong ho tro chuyen doi
        lvDSSinhVien.setAdapter(adp);

        // dang ky don nhan phan tu ma nguoi dung chon
        lvDSSinhVien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) view).setTextColor(Color.RED);
                Toast.makeText(MainActivity.this, "Ban da chon: "+ ds[position], Toast.LENGTH_SHORT).show();
            }
        });

        // dang nhan su kien cham va du lau tren mot phan tu

       /* lvDSSinhVien.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Ban da cham lau lau lam tren:"+ ds[position], Toast.LENGTH_SHORT).show();
                return true;
            }
        });*/

        // dang ky su dung su kien long click  tren lstview de mo popup menu
        registerForContextMenu(lvDSSinhVien);
    }


    // gan trinh don chinh cho ung dung
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    // don nhan su kien nguoi dung chon chuc nang tren trinh don
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.mnThoat) {
            finish();
        }
        return true;
    }

    // gan trinh don ngu canh cho ung dung
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.popup_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    // don nhan su kien nguoi dung chon chuc nang tren trinh don
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.mnXoa) {
            // doc thong tin ve popup menu
            AdapterView.AdapterContextMenuInfo adp1 = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            // lay view da kich hoat popup menu
            TextView tv = (TextView) adp1.targetView;

            Toast.makeText(MainActivity.this, "ban da xoa sv: " + tv.getText().toString(), Toast.LENGTH_SHORT).show();
            // tim va xoa sv dc chon khoi danh sach
            for (int i = 0; i < ds.length; i++) {
                if (ds[i].equals(tv.getText().toString())) {
                    ds[i] = ds[i] + " da bi xoa";
                    // ngung viec tim xoa
                    break;
                }
            }
            // cap nhat lai list view
        }

        return true;
    }
}

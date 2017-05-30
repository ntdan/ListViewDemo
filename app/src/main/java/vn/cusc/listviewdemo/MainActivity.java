package vn.cusc.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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
                Toast.makeText(MainActivity.this, "Ban da chon: "+ ds[position], Toast.LENGTH_SHORT).show();
            }
        });

        // dang nhan su kien cham va du lau tren mot phan tu
        lvDSSinhVien.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Ban da cham lau lau lam tren:"+ ds[position], Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}

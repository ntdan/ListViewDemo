package vn.cusc.listviewdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    String[] ds = {"Nguyễn Văn An", "Trần Thị C", "Lê Long Đỉnh",
            "Mã Văn Tấu", "Ngô Thanh Long", "Bành Tuấn Phong", "Châu Thanh Hậu",
            "Nguyễn Văn An", "Trần Thị C", "Lê Long Đỉnh",
            "Mã Văn Tấu", "Ngô Thanh Long", "Bành Tuấn Phong", "Châu Thanh Hậu"};
    ArrayAdapter<String> adp;
    GridView grd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        grd = (GridView) findViewById(R.id.gridView);

        // thanh phan ho tro chuyen tung phan tu trong tap hop ds len
        // giao dien listview
        adp = new ArrayAdapter<String>(Main2Activity.this,
                android.R.layout.simple_list_item_1, ds);
        // chi dinh doi tuong ho tro chuyen doi
        grd.setAdapter(adp);

        grd.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) view).setTextColor(Color.RED);
                Toast.makeText(Main2Activity.this, "Ban da chon: " + ds[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}

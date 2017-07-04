package com.example.cj.testspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private ArrayAdapter<String> adapter;
    private ArrayAdapter<CharSequence> adapterXML;
    private List<String> list;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化
        spinner = (Spinner) findViewById(R.id.spinner);
        tv = (TextView) findViewById(R.id.spinner_tv);
        //initByList();
        initByXML();
        //设置spinner的选中item事件
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //AdapterView中的item被选中的时候执行的方法
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tv.setText(adapterXML.getItem(position));
            }

            //未被选中的时候执行的方法
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void initByXML() {
        adapterXML = ArrayAdapter.createFromResource(this, R.array.datalist, android.R.layout.simple_list_item_1);
        spinner.setAdapter(adapterXML);
    }

    //通过java代码获取List<String>
    private void initByList() {
        list = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            list.add("数据" + i);
        }
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        //设置spinner样式
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        //设置适配器显示
        spinner.setAdapter(adapter);
    }

}

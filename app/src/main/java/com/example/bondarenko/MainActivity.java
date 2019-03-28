package com.example.bondarenko;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.widget.AdapterView.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, OnItemClickListener {

    TextView tv;
    Button button1;
    EditText edit;
    TextView tv2;
    int counter = 0;

    ListView listView;
    ArrayList nameList = new ArrayList();
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.text_view);
        tv.setText(getString(R.string.HelloJava));
        tv2 = findViewById(R.id.text_view2 );
        tv2.setText("Number of clicks");

        button1 = findViewById(R.id.btn1);
        button1.setOnClickListener(this);
        edit = findViewById(R.id.edit);

        listView = findViewById(R.id.listview);
        arrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, nameList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //tv.setText(getString(R.string.Text_after));
        //tv.setText(edit.getText());

        nameList.add(edit.getText().toString());
        arrayAdapter.notifyDataSetChanged();
        counter = counter + 1;
        tv2.setText(Integer.toString(counter));
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        tv.setText(nameList.get(position).toString());
    }
}


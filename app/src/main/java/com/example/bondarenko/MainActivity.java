package com.example.bondarenko;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    TextView tv;
    Button button1;
    Button button2;
    TextView tv2;
    int counter = 0;
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
        View.OnClickListener onClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayAdapter.notifyDataSetChanged();
                counter = counter + 1;
                tv2.setText("Кнопка нажата " +Integer.toString(counter) + getEndWord());            }
        };
        View.OnClickListener DecreaseClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayAdapter.notifyDataSetChanged();
                counter = counter - 1;
                tv2.setText("Кнопка нажата "+ Integer.toString(counter)+ getEndWord());            }
        };
        button1.setOnClickListener(onClick);
        button2 = findViewById(R.id.btn2);
        button2.setOnClickListener(DecreaseClick);
        arrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, nameList);
    }

    private String getEndWord() {
        long absScore = Math.abs(counter);
        long lastScoreDigit = absScore % 10;
        if (lastScoreDigit == 0 || lastScoreDigit == 1)
            return " раз";
        if (absScore == 2 || absScore == 3 || absScore == 4)
            return " раза";
        if (absScore < 20)
            return " раз";
        return " раза";
    }

    //@Override
    //public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //tv.setText(nameList.get(position).toString());
    //}
}


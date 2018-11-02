package com.example.dell.createqcm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.function.Consumer;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_detail);

        Data data = (Data) getIntent().getSerializableExtra("QCM");

        Log.d("tAG", "onCreate: Data Values" + data.toString());

        LinearLayout linearLayout=new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setPadding(30,30,30,30);
        linearLayout.setLayoutParams(layoutParams);
        setContentView(linearLayout);

        TextView textView=new TextView(this);
        LinearLayout.LayoutParams textViewParams=new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        textView.setLayoutParams(textViewParams);
        textView.setText("Q:  " + data.getQuestion());
        textView.setTextSize(22);




        LinearLayout innerlayout=new LinearLayout(this);
        LinearLayout.LayoutParams innerParams=new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        innerlayout.setPadding(5,5,5,5);
        innerlayout.setLayoutParams(innerParams);

        TextView text2=new TextView(this);
        LinearLayout.LayoutParams text2Params=new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        text2Params.setMargins(0,22,0,0);
        text2.setLayoutParams(text2Params);
        text2.setText("A: ");
        text2.setTextSize(22);

        RadioGroup rdGroup=new RadioGroup(this);
        LinearLayout.LayoutParams rdGroupParams=new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        rdGroup.setLayoutParams(rdGroupParams);
        innerlayout.addView(text2);
        innerlayout.addView(rdGroup);

        linearLayout.addView(textView);
        linearLayout.addView(innerlayout);

        for (String s : data.getAnswers()) {
            RadioButton rdb=new RadioButton(this);
            LinearLayout.LayoutParams rdbParams=new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            rdbParams.setMargins(0,25,0,0);
            rdb.setLayoutParams(rdbParams);
            rdb.setText(s);
            rdb.setTextSize(15);
            rdGroup.addView(rdb);

        }





    }
}

package com.example.dell.createqcm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CreateActivity extends AppCompatActivity {

    private Data data;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        data = new Data();  // Create Obj class Data

        LinearLayout linearLayout=new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        linearLayout.setGravity(Gravity.CENTER_HORIZONTAL);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setPadding(80,22,80,22);
        linearLayout.setLayoutParams(layoutParams);
        setContentView(linearLayout);

        TextView textView=new TextView(this);
        LinearLayout.LayoutParams textViewParams=new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        textViewParams.setMargins(0,266,0,0);
        textView.setLayoutParams(textViewParams);
        textView.setText("Create QCM");
        textView.setTextSize(22);

        final EditText text1=new EditText(this);
        LinearLayout.LayoutParams text1Params=new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        text1Params.setMargins(0,60,0,0);
        text1.setLayoutParams(text1Params);
        text1.setHint("Question");

        final EditText text2=new EditText(this);
        LinearLayout.LayoutParams text2Params=new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        text2Params.setMargins(0,50,0,0);
        text2.setLayoutParams(text2Params);
        text2.setHint("Answer");

        Button btn1=new Button(this);
        LinearLayout.LayoutParams btn1Params =new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        btn1Params.setMargins(0,42,0,0);
        btn1.setLayoutParams(btn1Params);
        btn1.setText("Add");

        Button btn2=new Button(this);
        LinearLayout.LayoutParams btn2Params =new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        btn2Params.setMargins(0,226,0,0);
        btn2.setLayoutParams(btn2Params);
        btn2.setText("Done");




        linearLayout.addView(textView);
        linearLayout.addView(text1);
        linearLayout.addView(text2);
        linearLayout.addView(btn1);
        linearLayout.addView(btn2);


       btn1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(TextUtils.isEmpty(text1.getText())||TextUtils.isEmpty(text2.getText())){
                   Toast.makeText(CreateActivity.this, "Question and Answers is Required!", Toast.LENGTH_SHORT).show();
               }else{
                    data.setQuestion(text1.getText().toString());
                    data.getAnswers().add(text2.getText().toString());
               }
               text2.setText("");
           }
       });
       btn2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(data.getAnswers().size()>=2) {
                   Intent intent = new Intent(CreateActivity.this, DetailActivity.class);
                   intent.putExtra("QCM", data);
                   startActivity(intent);
               }
               else{
                   Toast.makeText(CreateActivity.this, "You need to add answer more than 2", Toast.LENGTH_LONG).show();
               }
           }
       });



    }
}

package com.example.kathrynl.weight;

import android.content.DialogInterface;
import android.R.string;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.content.Intent;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends AppCompatActivity {
public static String sex="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1 = (Button) findViewById(R.id.btn_calculate);
        b1.setOnClickListener(new OnClickListener() {
                                  public void onClick(View arg0) {
                                      EditText et = (EditText) findViewById(R.id.et_height);
                                      double height = Double.parseDouble(et.getText().toString());
                                      RadioGroup rg = (RadioGroup) findViewById(R.id.rg_sex);
                                      rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                          @Override
                                          public void onCheckedChanged(RadioGroup arg0, int checkedId) {
                                              if (checkedId == R.id.rb_male) {
                                                  sex = "M";
                                              } else {
                                                  sex = "F";
                                              }
                                          }
                                      });
                                      Intent intent = new Intent();
                                      intent.setClass(MainActivity.this, Result.class);
                                      Bundle bundle = new Bundle();
                                      bundle.putDouble("height", height);
                                      bundle.putString("sex", sex);
                                      intent.putExtras(bundle);
                                      startActivity(intent);
                                  }
                              } );
            }
        }







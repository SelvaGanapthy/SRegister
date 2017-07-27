package com.example.dell.sregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        String mob=intent.getStringExtra("mob");
        t1=(TextView)findViewById(R.id.t1);
        t1.setText("\nname :"+name+"\nmob.no :"+mob);
    }
}

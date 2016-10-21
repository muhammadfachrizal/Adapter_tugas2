package com.example.mfachrizal.student;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Home extends AppCompatActivity {
    private TextView studentView;
    private TextView teacherView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        studentView  = (TextView) findViewById(R.id.StudentView);
        teacherView = (TextView) findViewById(R.id.teacherview);
        studentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this,MainActivity.class);
                startActivity(intent);
            }
        });

        teacherView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(.this,TeacherActivity.class);
                //startActivity(intent);
            }
        });
    }
}

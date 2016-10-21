package com.example.mfachrizal.student;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Edit extends AppCompatActivity {
    private EditText eid,enoreg,enama,eemail,ephone;
    private Student student;
    private FloatingActionButton cancel,OK;

    private static ArrayList<Student> list = new ArrayList<>();
    private static Edit instance = new Edit();

    public static Edit getInstance(){
        return instance;
    }
    public static ArrayList<Student> getList(){
        return list;
    }
    public void addStudent(Student student){
        student.setId(next());
        list.add(student);
    }

    public void clearList(){
        list.clear();
    }
    public Student get(int index){
        Student student = list.get(index);
        return student;
    }
    public void edit(int index, Student student){
        list.set(index, student);
    }
    public int size(){
        return list.size();
    }
    public int next(){
        return list.size()+1;
    }
    public Student delete(int index){
        Student student = list.remove(index);
        changeNo(index);
        return student;
    }
    private void changeNo(int index){
        for (int position = index; position < list.size(); position++) {
            Student now = get(position);
            now.setId(position+1);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_edit);
        eid = (EditText)findViewById(R.id.eid);
        enoreg = (EditText)findViewById(R.id.enoreg);
        enama = (EditText)findViewById(R.id.enama);
        eemail = (EditText)findViewById(R.id.eemail);
        ephone = (EditText)findViewById(R.id.ephone);
        OK = (FloatingActionButton)findViewById(R.id.OK);
        cancel = (FloatingActionButton)findViewById(R.id.cancel);
        Intent intent = getIntent();
        final boolean action = intent.getBooleanExtra("edit", false);
        final int position = intent.getIntExtra("position", 0);

        if (action == true){
            setTitle("Edit Data");
            student = (Student) intent.getSerializableExtra("student_position");
            eid.setText(student.getId()+"");
            enoreg.setText(student.getNoreg());
            enama.setText(student.getNama());
            eemail.setText(student.getMail());
            ephone.setText((student.getPhone()));
        }
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Edit.this, MainActivity.class);
                startActivity(intent);
            }
        });

        OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Edit.this, MainActivity.class);
                int id = Integer.parseInt(eid.getText().toString());
                String noreg = enoreg.getText().toString();
                String nama = enama.getText().toString();
                String email = eemail.getText().toString();
                String phone = ephone.getText().toString();
                student = new Student(id,noreg,nama,email,phone);
                Edit studentList = getInstance();
                if(!action){
                    studentList.addStudent(student);
                    Toast.makeText(getApplicationContext(), "Berhasil Menambahkan!", Toast.LENGTH_SHORT).show();
                    startActivity(a);
                } else{
                    studentList.edit(position, student);
                    Toast.makeText(getApplicationContext(), "Berhasil Mengedit!", Toast.LENGTH_SHORT).show();
                    startActivity(a);
                }

            }
        });
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.delete:
                Intent a = new Intent(Edit.this, MainActivity.class);
                int no = student.getId();
                Edit list = getInstance();
                list.delete(no-1);
                Toast.makeText(getApplicationContext(), "Berhasil Dihapus!", Toast.LENGTH_SHORT).show();
                startActivity(a);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        Intent a = getIntent();
        boolean action = a.getBooleanExtra("edit", false);
        if (action){
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.delete, menu);}
        return true;
    }


}




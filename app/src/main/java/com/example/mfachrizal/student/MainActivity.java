package com.example.mfachrizal.student;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.FloatingActionButton;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

    private Edit studentList;
    private TextView kosong;
    private CustomUsersAdapter Cadapter;
    private ListView listing;
    private FloatingActionButton addStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user);
        studentList = Edit.getInstance();
        Cadapter = new CustomUsersAdapter(MainActivity.this, Edit.getList());
        listing = (ListView)findViewById(R.id.lvUsers);
        listing.setAdapter(Cadapter);
        kosong = (TextView)findViewById(R.id.tidakada);
        listing.setEmptyView(kosong);
        addStudent = (FloatingActionButton)findViewById(R.id.tambah);
        addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, Edit.class);
                startActivity(a);
            }
        });
        listing.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent a = new Intent(MainActivity.this, Edit.class);
                Student student = studentList.get(position);
                a.putExtra("edit", true);
                a.putExtra("student_position",student);
                a.putExtra("position",position);
                startActivity(a);
            }
        });


    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.createdummy, menu);
        return super.onCreateOptionsMenu(menu);
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.create_dummy:
                ArrayList<Student> students = populateUsersList();
                CustomUsersAdapter studentAdapter = new CustomUsersAdapter(this,students);
                listing= (ListView)findViewById(R.id.lvUsers);
                listing.setAdapter(studentAdapter);
                return true;
            case R.id.clear_list:
                clearlist();
                CustomUsersAdapter studentAdapters = new CustomUsersAdapter(this,new ArrayList<Student>());
                listing = (ListView)findViewById(R.id.lvUsers);
                listing.setAdapter(studentAdapters);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private ArrayList<Student> populateUsersList() {
        Edit students = Edit.getInstance();
        students.addStudent(new Student(studentList.next(),"3145136196","Mikael Yurubeli","mikael@gmail.com","0838xxxxxxxx"));
        students.addStudent(new Student(studentList.next(),"3145136197","Muhammad Fachrizal","bankai@yahoo.com","085711402970"));
        return Edit.getList();
    }


    private ArrayList<Student> clearlist(){
        Edit.getInstance().clearList();
        return Edit.getList();
    }

   // private void populateUsersList() {
        // Construct the data source
      //  ArrayList<Student> arrayOfUsers = Student.getStudent();
        // Create the adapter to convert the array to views
      //  CustomUsersAdapter adapter = new CustomUsersAdapter(this, arrayOfUsers);
        // Attach the adapter to a ListView
      //  ListView listView = (ListView) findViewById(R.id.lvUsers);
      //  listView.setAdapter(adapter);
  //  }

}



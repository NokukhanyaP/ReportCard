package com.example.nokukhanya.reportcard;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;

import static android.media.CamcorderProfile.get;

public class DisplayActivity extends AppCompatActivity {

    DatabaseHelper sd = new DatabaseHelper(this);

    Button btnDespADD,btnDespDELETE,btnDespUPDATE;
    //khutso
   // ArrayList<Student> students= new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

       final ArrayList<String> studentArr = sd.getStudents();
        //khutso
        //students = sd.getStudents();


        ListView LSV = (ListView) findViewById(R.id.display);

        btnDespADD = (Button) findViewById(R.id.btnADD);
        btnDespDELETE = (Button) findViewById(R.id.btnDELETE);
        btnDespUPDATE = (Button) findViewById(R.id.btnUPDATE);

        final Student student = new Student();

        ArrayList display = new ArrayList();
        display.add("");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, studentArr);
        LSV.setAdapter(arrayAdapter);

        btnDespDELETE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DisplayActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnDespADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DisplayActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnDespUPDATE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DisplayActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        LSV.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                AlertDialog.Builder dialog = new AlertDialog.Builder(DisplayActivity.this);
                dialog.setTitle("STUDENT REPORT CARD");
                dialog.setMessage("Are you sure you want to delete a student ?");
                dialog.setNegativeButton("Delete", new DialogInterface.OnClickListener() {

                    @Override

                    public void onClick(DialogInterface dialog, int which) {


                        //khutso
                        //student= studentArr.get(position);


                        dialog.dismiss();
                    }
                });
                dialog.setPositiveButton("Update", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        Intent intent = new Intent(DisplayActivity.this,MainActivity.class);
                        startActivity(intent);

                    }
                });

                dialog.show();
            }
        });
    }
}

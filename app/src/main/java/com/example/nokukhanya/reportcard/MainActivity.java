package com.example.nokukhanya.reportcard;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.nokukhanya.reportcard.R.id.EDstud_num;
import static com.example.nokukhanya.reportcard.R.id.txtAverage;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;


public class MainActivity extends AppCompatActivity {

    private EditText editStudID, editName, editSur, editCourse, editMark1, editMark2, editMark3;
    private TextView textvAverage;
    private DatabaseHelper sd;

    private Dialog dialog;
    private AlertDialog.Builder builder;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sd=new DatabaseHelper(this);


        editStudID = (EditText) findViewById(EDstud_num);
        editName = (EditText) findViewById(R.id.EDstud_name);
        editSur = (EditText) findViewById(R.id.EDstud_sur);
        editCourse = (EditText) findViewById(R.id.EDstud_course);
        editMark1 = (EditText) findViewById(R.id.EDmark_one);
        editMark2 = (EditText) findViewById(R.id.EDmark_two);
        editMark3 = (EditText) findViewById(R.id.EDmark_three);
        textvAverage = (TextView) findViewById(txtAverage);

    }

    public void add(View view) {

        int i = 0;
        int AverageMark;

        int idnumber = parseInt(editStudID.getText().toString());
        String name = editName.getText().toString();
        String surname = editSur.getText().toString();
        String course = editCourse.getText().toString();
        int mrk1 = parseInt(editMark1.getText().toString());
        int mrk2 = parseInt(editMark2.getText().toString());
        int mrk3 = parseInt(editMark3.getText().toString());


        AverageMark = (mrk1 + mrk2 + mrk3)/3;

        textvAverage.setText("Average" + AverageMark);

        Student student = new Student(idnumber,name, surname, course,mrk1, mrk2, mrk3,AverageMark);

        sd.AddStudent(student);

        Intent intent = new Intent(this, DisplayActivity.class);
        startActivity(intent);
    }

    public void Delete(View view) {

        String stdId = editStudID.getText().toString();
        sd.DeleteStudent(stdId);
        Intent intent = new Intent(this, DisplayActivity.class);
        startActivity(intent);

    }

    public void update(View view) {

        sd = new DatabaseHelper(this);
        int id = Integer.parseInt(editStudID.getText().toString());
        String name = String.valueOf(editName.getText().toString());
        String surname = String.valueOf(editSur.getText().toString());
        String course= String.valueOf(editCourse.getText().toString());
        int mark1 = parseInt(editMark1.getText().toString());
        int mark2 = parseInt(editMark2.getText().toString());
        int mark3 = parseInt(editMark3.getText().toString());

        int myAvarage = (mark1 + mark2 + mark3) / 3;

        sd.UpdateStudent(id,mark1,mark2,mark3,myAvarage,name,surname,course);

        textvAverage.setText("Average" + myAvarage);

        Intent intent = new Intent(this, DisplayActivity.class);
        startActivity(intent);

    }

}



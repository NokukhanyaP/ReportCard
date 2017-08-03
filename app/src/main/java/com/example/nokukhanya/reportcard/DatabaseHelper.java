package com.example.nokukhanya.reportcard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.app.NavUtils;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static android.R.attr.id;
import static android.R.attr.version;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by Nokukhanya on 2017/07/20.
 */

public class DatabaseHelper extends SQLiteOpenHelper {


    private final static int databaseVersion = 5;

    private final static String databaseName = "StudentsReport.db";

    String tablename = "Report";

    String STUDENT_ID = "idNumber";
    String STUDENT_NAME = "studName";
    String STUDENT_SURNAME = "studSurname";
    String STUDENT_COURSE = "studCourse";

    String STUDENT_MARK1 = "StudMark1";
    String STUDENT_MARK2 = "studMark2";
    String STUDENT_MARK3 = "studMark3";
    String AVARAGE = "average";

    static ArrayList<String> students;


    public DatabaseHelper(Context context) {
        super(context, databaseName, null, databaseVersion);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "create table " + tablename + "(" + STUDENT_ID + " integer Primary Key AutoIncrement, " + STUDENT_NAME + " Text, " + STUDENT_SURNAME + " Text, " + STUDENT_COURSE + " Text, " + STUDENT_MARK1 + " Integer, "
                + STUDENT_MARK2 + " Integer, " + STUDENT_MARK3 + " Integer, " + AVARAGE + " Integer)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if existS " + tablename);
        onCreate(db);

    }

    public void AddStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(STUDENT_ID, student.getStudent_ID());
        values.put(STUDENT_NAME, student.getStudent_name());
        values.put(STUDENT_SURNAME, student.getStudent_surname());
        values.put(STUDENT_COURSE, student.getStudent_course());
        values.put(STUDENT_MARK1, student.getStudent_mark1());
        values.put(STUDENT_MARK2, student.getStudent_mark2());
        values.put(STUDENT_MARK3, student.getStudent_mark3());
        values.put(AVARAGE, student.getStudent_average());

        db.insert(tablename, null, values);

        db.close();
    }

    public ArrayList<String> getStudents() {
        SQLiteDatabase db = this.getWritableDatabase();

        students=new ArrayList<>();


        // Select All Query
        String selectQuery = "SELECT * FROM " + tablename;
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {

                int StudID = cursor.getInt(0);
                String StudName = cursor.getString(1);
                String StudSurname = cursor.getString(2);
                String StudCourse=cursor.getString(3);
                int StudMrk1 = cursor.getInt(4);
                int StudMrk2 = cursor.getInt(5);
                int StudMrk3 = cursor.getInt(6);
                int StudAverage = cursor.getInt(7);


                String display ="Student ID: "+ StudID + "   " +"\n"+ "Name :" + StudName +"   "+ "Surname:" + StudSurname + "   "+"\n" +"Student Course:"+StudCourse +"  "+"\n"+" Mark1:"+StudMrk1 + "   " + " Mark2:" + StudMrk2 +
                       "  "+ " Mark3:" + StudMrk3 + "   " +"\n"+ "Student Average:" + StudAverage;

                students.add(display);
                System.out.println(display);
            }
            while (cursor.moveToNext());
        }
        return students;
   }


    public void UpdateStudent(int i, int average, int mark1, int mark2, int mark3, String name, String surname, String course) {
        ContentValues values = new ContentValues();

        SQLiteDatabase db = this.getWritableDatabase();

        values.put(STUDENT_NAME, name);
        values.put(STUDENT_SURNAME, surname);
        values.put(STUDENT_COURSE, course);
        values.put(STUDENT_MARK1, mark1);
        values.put(STUDENT_MARK2, mark2);
        values.put(STUDENT_MARK3, mark3);
        values.put(AVARAGE, average);

        String[] whereArgs = {String.valueOf(i)};

        db.update(this.tablename, values, this.STUDENT_ID + "= ?",whereArgs);

    }

    public int DeleteStudent(String x) {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] whereArgs = {x};

        int count = db.delete(this.tablename, this.STUDENT_ID + "=?", whereArgs);
        return count;

    }

    public Student getStudent(Student student) {
        SQLiteDatabase db = this.getReadableDatabase();


        String selectQuery = "SELECT * FROM " + tablename + " where " + STUDENT_ID + " = ? ";

        String args[] = {String.valueOf(student.getStudent_ID())};

        Cursor c = db.rawQuery(selectQuery, args);

        if (c.moveToFirst()) {
            student.setStudent_ID(c.getInt(c.getColumnIndex(STUDENT_ID)));
            student.setStudent_name(c.getString(c.getColumnIndex(STUDENT_NAME)));
            student.setStudent_surname(c.getString(c.getColumnIndex(STUDENT_SURNAME)));
            student.setStudent_course(c.getString(c.getColumnIndex(STUDENT_COURSE)));
            student.setStudent_mark1(c.getInt(c.getColumnIndex(STUDENT_MARK1)));
            student.setStudent_mark2(c.getInt(c.getColumnIndex(STUDENT_MARK2)));
            student.setStudent_mark3(c.getInt(c.getColumnIndex(STUDENT_MARK3)));
            student.setStudent_average(c.getInt(c.getColumnIndex(AVARAGE)));

        }
        return student;

    }
}

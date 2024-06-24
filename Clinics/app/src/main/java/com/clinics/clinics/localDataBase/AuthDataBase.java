package com.clinics.clinics.localDataBase;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.clinics.clinics.models.AuthModel;
import java.util.ArrayList;

public class AuthDataBase extends SQLiteOpenHelper {
    public static final String databaseName = DataBaseName.databaseName;

    public AuthDataBase(Context context){
        super(context,databaseName,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users (id integer primary key autoincrement, username text,password text, userValidity text)");
        db.execSQL("create table add_doctor (id integer primary key autoincrement, name text,national_id text, address text, phone_number text, medical_specialty text, gender text, marital_status text, date_of_birth text)");
        db.execSQL("create table add_patient (id integer primary key autoincrement, patient_name text,doctor_name text, phone_number text, gender text, date_of_birth text,price text)");
        db.execSQL("create table add_clinic (id integer primary key autoincrement, clinic_name text,clinic_specialty text, examination_price text, re_examination_price text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists users");
        db.execSQL("drop table if exists add_doctor");
        db.execSQL("drop table if exists add_patient");
        db.execSQL("drop table if exists add_clinic");
        onCreate(db);
    }

    public String insertData(String username ,String password ,String userValidity){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username",username);
        values.put("password",password);
        values.put("userValidity",userValidity);
        long result =  db.insert("users",null,values);
        if(result == -1)
            return  "Error";
        else{
            return  "Done";
        }
    }

    public ArrayList<AuthModel> getData(){
        ArrayList<AuthModel> arrayList = new ArrayList<AuthModel>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from users",null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            arrayList.add(new AuthModel(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3)
            ));
            cursor.moveToNext();
        }
        return  arrayList;
    }

    public void updateData( AuthModel addPatientModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username",addPatientModel.getUsername());
        values.put("userValidity",addPatientModel.getUserValidity());
        db.update("users",values,"id?",new String[]{addPatientModel.getId()+""});
    }
    public void deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("users","id?",new String[]{id});
    }
}

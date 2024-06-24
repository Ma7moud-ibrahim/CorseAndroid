package com.clinics.clinics.localDataBase;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.clinics.clinics.models.AddPatientModel;
import java.util.ArrayList;

public class AddPatientDataBase extends SQLiteOpenHelper {
    public static final String databaseName = DataBaseName.databaseName;

    public AddPatientDataBase(Context context){
        super(context,databaseName,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public String insertData(AddPatientModel addPatientModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("patient_name",addPatientModel.getPatientName());
        values.put("doctor_name",addPatientModel.getDoctorName());
        values.put("phone_number",addPatientModel.getPhoneNumber());
        values.put("gender",addPatientModel.getGender());
        values.put("date_of_birth",addPatientModel.getDateOfBirth());
        values.put("price",addPatientModel.getPrice());
        long result = db.insert("add_patient",null,values);
        if(result == -1)
            return "Error";
        else{
            return "New patient added";
        }
    }

    public ArrayList<AddPatientModel> getData(){
        ArrayList<AddPatientModel> arrayList = new ArrayList<AddPatientModel>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from add_patient",null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            arrayList.add(new AddPatientModel(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6)
            ));
            cursor.moveToNext();
        }
        return  arrayList;
    }

    public void updateData(AddPatientModel addPatientModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("patient_name",addPatientModel.getPatientName());
        values.put("doctor_name",addPatientModel.getDoctorName());
        values.put("phone_number",addPatientModel.getPhoneNumber());
        values.put("gender",addPatientModel.getGender());
        values.put("date_of_birth",addPatientModel.getDateOfBirth());
        values.put("price",addPatientModel.getPrice());
        db.update("add_patient",values,"id?",new String[]{addPatientModel.getId()+""});
    }
    public void deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("add_patient","id?",new String[]{id});
    }
}

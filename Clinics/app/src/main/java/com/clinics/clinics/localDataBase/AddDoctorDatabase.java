package com.clinics.clinics.localDataBase;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.clinics.clinics.models.AddDoctorModel;
import java.util.ArrayList;


public class AddDoctorDatabase extends SQLiteOpenHelper {
    public static final String databaseName = DataBaseName.databaseName;

    public AddDoctorDatabase(Context context){
        super(context,databaseName,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public String insertData(AddDoctorModel addDoctorModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",addDoctorModel.getName());
        values.put("national_id",addDoctorModel.getNationalID());
        values.put("address",addDoctorModel.getAddress());
        values.put("phone_number",addDoctorModel.getPhoneNumber());
        values.put("medical_specialty",addDoctorModel.getMedicalSpecialty());
        values.put("gender",addDoctorModel.getGender());
        values.put("marital_status",addDoctorModel.getMaritalStatus());
        values.put("date_of_birth",addDoctorModel.getDateOfBirth());
        long result = db.insert("add_doctor",null,values);
        if(result == -1)
            return "Error";
        else{
            return "New doctor added";
        }
    }

    public ArrayList<AddDoctorModel> getData(){
        ArrayList<AddDoctorModel> arrayList = new ArrayList<AddDoctorModel>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from add_doctor",null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            arrayList.add(new AddDoctorModel(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7),
                    cursor.getString(8)
            ));
            cursor.moveToNext();
        }
        return  arrayList;
    }

    public void updateData(AddDoctorModel addDoctorModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",addDoctorModel.getName());
        values.put("nationalID",addDoctorModel.getNationalID());
        values.put("address",addDoctorModel.getAddress());
        values.put("phoneNumber",addDoctorModel.getPhoneNumber());
        values.put("medicalSpecialty",addDoctorModel.getMedicalSpecialty());
        values.put("gender",addDoctorModel.getGender());
        values.put("maritalStatus",addDoctorModel.getMaritalStatus());
        values.put("dateOfBirth",addDoctorModel.getDateOfBirth());
        db.update("add_doctor",values,"id?",new String[]{addDoctorModel.getId()+""});
    }
    public void deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("add_doctor","id?",new String[]{id});
    }
}

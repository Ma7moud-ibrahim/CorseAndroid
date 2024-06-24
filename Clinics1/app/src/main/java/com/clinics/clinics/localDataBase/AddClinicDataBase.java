package com.clinics.clinics.localDataBase;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.clinics.clinics.models.AddClinicModel;
import java.util.ArrayList;

public class AddClinicDataBase extends SQLiteOpenHelper {
    public static final String databaseName =DataBaseName.databaseName;

    public AddClinicDataBase(Context context){
        super(context,databaseName,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public String insertData(AddClinicModel addClinicModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("clinic_name",addClinicModel.getClinicName());
        values.put("clinic_specialty",addClinicModel.getClinicSpecialty());
        values.put("examination_price",addClinicModel.getExaminationPrice());
        values.put("re_examination_price",addClinicModel.getReExaminationPrice());
        long result = db.insert("add_clinic",null,values);
        if(result == -1)
            return "Error";
        else{
            return "New clinic added";
        }
    }

    public ArrayList<AddClinicModel> getData(){
        ArrayList<AddClinicModel> arrayList = new ArrayList<AddClinicModel>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from add_clinic",null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            arrayList.add(new AddClinicModel(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4)
            ));
            cursor.moveToNext();
        }
        return  arrayList;
    }

    public void updateData(AddClinicModel addClinicModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("clinic_name",addClinicModel.getClinicName());
        values.put("clinic_specialty",addClinicModel.getClinicSpecialty());
        values.put("examination_price",addClinicModel.getExaminationPrice());
        values.put("re_examination_price",addClinicModel.getReExaminationPrice());
        db.update("add_clinic",values,"id?",new String[]{addClinicModel.getId()+""});
    }
    public void deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("add_clinic","id?",new String[]{id});
    }
}

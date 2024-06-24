package com.clinics.clinics.models;

import android.os.Parcel;
import android.os.Parcelable;

public class AddClinicModel  implements Parcelable {
    int id;
    final String clinicName ;
    final String clinicSpecialty ;
    final String examinationPrice ;
    final String reExaminationPrice;

    public AddClinicModel(int id, String clinicName, String clinicSpecialty, String examinationPrice, String reExaminationPrice) {
        this.id = id;
        this.clinicName = clinicName;
        this.clinicSpecialty = clinicSpecialty;
        this.examinationPrice = examinationPrice;
        this.reExaminationPrice = reExaminationPrice;
    }

    public AddClinicModel(String clinicName, String clinicSpecialty, String examinationPrice, String reExaminationPrice) {
        this.clinicName = clinicName;
        this.clinicSpecialty = clinicSpecialty;
        this.examinationPrice = examinationPrice;
        this.reExaminationPrice = reExaminationPrice;
    }

    protected AddClinicModel(Parcel in) {
        id = in.readInt();
        clinicName = in.readString();
        clinicSpecialty = in.readString();
        examinationPrice = in.readString();
        reExaminationPrice = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(clinicName);
        dest.writeString(clinicSpecialty);
        dest.writeString(examinationPrice);
        dest.writeString(reExaminationPrice);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AddClinicModel> CREATOR = new Creator<AddClinicModel>() {
        @Override
        public AddClinicModel createFromParcel(Parcel in) {
            return new AddClinicModel(in);
        }

        @Override
        public AddClinicModel[] newArray(int size) {
            return new AddClinicModel[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getClinicName() {
        return clinicName;
    }

    public String getClinicSpecialty() {
        return clinicSpecialty;
    }

    public String getExaminationPrice() {
        return examinationPrice;
    }

    public String getReExaminationPrice() {
        return reExaminationPrice;
    }
}

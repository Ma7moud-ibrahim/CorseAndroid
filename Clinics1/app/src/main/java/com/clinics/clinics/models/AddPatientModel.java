package com.clinics.clinics.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class AddPatientModel implements Parcelable {
    int id;
    final String patientName;
    final String doctorName;
    final String phoneNumber;
    final String gender;
    final String dateOfBirth;

    public AddPatientModel(int id, String patientName, String doctorName, String phoneNumber, String gender, String dateOfBirth) {
        this.id = id;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public AddPatientModel(String patientName, String doctorName, String phoneNumber, String gender, String dateOfBirth) {
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    protected AddPatientModel(Parcel in) {
        id = in.readInt();
        patientName = in.readString();
        doctorName = in.readString();
        phoneNumber = in.readString();
        gender = in.readString();
        dateOfBirth = in.readString();
    }

    public static final Creator<AddPatientModel> CREATOR = new Creator<AddPatientModel>() {
        @Override
        public AddPatientModel createFromParcel(Parcel in) {
            return new AddPatientModel(in);
        }

        @Override
        public AddPatientModel[] newArray(int size) {
            return new AddPatientModel[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(patientName);
        parcel.writeString(doctorName);
        parcel.writeString(phoneNumber);
        parcel.writeString(gender);
        parcel.writeString(dateOfBirth);
    }
}

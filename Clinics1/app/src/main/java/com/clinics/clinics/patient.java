package com.clinics.clinics;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import java.io.Serializable;

class patient implements Parcelable {
    public int age;
    public String name;
    public String desease;
    public String email;

    public patient(int age, String name, String desease, String email) {
        this.age = age;
        this.name = name;
        this.desease = desease;
        this.email = email;
    }

    protected patient(Parcel in) {
        age = in.readInt();
        name = in.readString();
        desease = in.readString();
        email = in.readString();
    }

    public static final Creator<patient> CREATOR = new Creator<patient>() {
        @Override
        public patient createFromParcel(Parcel in) {
            return new patient(in);
        }

        @Override
        public patient[] newArray(int size) {
            return new patient[size];
        }
    };

    @Override
    public String toString() {
        return "patient{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", desease='" + desease + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(age);
        parcel.writeString(name);
        parcel.writeString(desease);
        parcel.writeString(email);
    }
}
package com.clinics.clinics.models;

public class AddDoctorModel {
    int id;
    final String name ;
    final  String nationalID ;
    final   String address ;
    final  String phoneNumber;
    final  String medicalSpecialty ;
    final   String gender;
    final  String maritalStatus ;
    final String dateOfBirth ;

    public AddDoctorModel(String name, String nationalID, String address, String phoneNumber, String medicalSpecialty, String gender, String maritalStatus, String dateOfBirth) {
        this.name = name;
        this.nationalID = nationalID;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.medicalSpecialty = medicalSpecialty;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.dateOfBirth = dateOfBirth;
    }

    public AddDoctorModel(int id, String name, String nationalID, String address, String phoneNumber, String medicalSpecialty, String gender, String maritalStatus, String dateOfBirth) {
        this.id = id;
        this.name = name;
        this.nationalID = nationalID;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.medicalSpecialty = medicalSpecialty;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNationalID() {
        return nationalID;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMedicalSpecialty() {
        return medicalSpecialty;
    }

    public String getGender() {
        return gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }
}

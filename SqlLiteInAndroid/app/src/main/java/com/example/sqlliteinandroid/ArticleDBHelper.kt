package com.example.sqlliteinandroid

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ArticleDBHelper (context: Context):SQLiteOpenHelper(context ,DBNAME,null,DBVERSION) {



    override fun onCreate(db: SQLiteDatabase?) {
        val sql = "CREATE TABLE ${DB.TABLE_NAME} ("+
                "${DB.ID} INTEGER PRIMARY KEY," +
                "${DB.TITLE} TEXT," +
                "${DB.BODY} TEXT" +
                ")"
        db?.execSQL(sql)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    companion object{
        private const val DBNAME = "ArticleDBHelper"
        private const val DBVERSION = 1

    }
}
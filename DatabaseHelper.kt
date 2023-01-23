package com.example.weatherapp
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
class DatabaseHelper(context: Context): SQLiteOpenHelper(context, "Login.db" , null, 1) {
override fun onCreate(db: SQLiteDatabase?) {
db?.execSQL("Create table user(name text primary key, pass text)")
}
override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
db?.execSQL("drop table if exists user")
}
fun insert(name: String, pass: String): Boolean {
val db: SQLiteDatabase = this.writableDatabase
val values: ContentValues = ContentValues()
values.put("name",name)
values.put("pass",pass)
var ins = db.insert("user",null,values)

return !ins.equals(-1)
}
fun checkname(name: String): Boolean{
val db: SQLiteDatabase = this.readableDatabase
val cursor = db.rawQuery("Select * from user where name = '$name'", null)
if(cursor.count>0){
cursor.close()
return false
}
cursor.close()
return true
}
fun namepass(name: String,pass: String): Boolean {
val db: SQLiteDatabase = this.readableDatabase
val cursor = db.rawQuery("Select * from user where name='$name' and pass = '$pass'",
null)
if(cursor.count>0){
cursor.close()
return true
}
cursor.close()
return false
}
}

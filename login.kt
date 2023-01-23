package com.example.weatherapp
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
class login : AppCompatActivity() {
lateinit var helper: DatabaseHelper
override fun onCreate(savedInstanceState: Bundle?) {
super.onCreate(savedInstanceState)
setContentView(R.layout.activity_login)
helper = DatabaseHelper(this)
val e1 = findViewById<EditText>(R.id.lname)
val e2 = findViewById<EditText>(R.id.lpass)
val b1 = findViewById<Button>(R.id.button)
b1.setOnClickListener(object : View.OnClickListener {
override fun onClick(view: View?){
val name = e1.text.toString()
val pass = e2.text.toString()
val namepass = helper.namepass(name , pass)
if (namepass == true) {
Toast.makeText(applicationContext, "Login successfully",

Toast.LENGTH_SHORT)

.show()
val intent = Intent(applicationContext, home::class.java)
startActivity(intent)
}
else
Toast.makeText(applicationContext, "Wrong name or password",

Toast.LENGTH_SHORT).show()

}
})
}
}

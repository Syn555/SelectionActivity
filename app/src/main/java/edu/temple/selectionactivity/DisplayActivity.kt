package edu.temple.selectionactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DisplayActivity() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)
        val imageObject: ImageObject = intent.extras!!.get("extra_image") as ImageObject
        val name = imageObject.name
        val description = imageObject.description
        val imageView = findViewById<ImageView>(R.id.displayImageView)
        val textView = findViewById<TextView>(R.id.displayTextView)
        textView.setText(description)
        imageView.setImageResource(imageObject.id)
    }
}
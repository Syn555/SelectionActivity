package edu.temple.selectionactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
val images: IntArray = intArrayOf(
    R.drawable.watermelon,
    R.drawable.dragonfruit,
    R.drawable.orange,
    R.drawable.grapefuit,
    R.drawable.kiwi,
    R.drawable.coconut,
    R.drawable.strawberry,
    R.drawable.grape,
    R.drawable.pineapple,
    R.drawable.banana
)
class SelectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.title = "Selector"
        super.onCreate(savedInstanceState)
        setContentView(R.layout.`activity_select`)
        var names = resources.getStringArray(R.array.Fruits);
        var descriptions = resources.getStringArray(R.array.descriptions);
        var items: ArrayList<ImageObject> = ArrayList()
        for (i in images.indices) {
            var item = ImageObject(images[i], names[i], descriptions[i])
            items.add(item);
        }
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val imageView = findViewById<ImageView>(R.id.imageView)
        val textView = findViewById<TextView>(R.id.textView)
        recyclerView.layoutManager = GridLayoutManager(this, 3)
        val onClickListener = View.OnClickListener {
            val index = recyclerView.getChildAdapterPosition(it)
            val selectedImage = items[index];
            val displayActivity = DisplayActivity()
            val intent = Intent(this, DisplayActivity::class.java)
            intent.putExtra("extra_image", selectedImage as java.io.Serializable);
            startActivity(intent)
        }
        recyclerView.adapter = ImageAdapter(items, onClickListener)
    }
}
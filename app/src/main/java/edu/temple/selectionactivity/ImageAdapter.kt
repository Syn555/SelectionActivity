package edu.temple.selectionactivity

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView


class ImageAdapter (_items : ArrayList<ImageObject>, _image : View.OnClickListener) : RecyclerView.Adapter<ImageAdapter.ViewHolder>(){
    private val items = _items
    val image = _image
    class ViewHolder(_view: ImageView, ocl: View.OnClickListener) : RecyclerView.ViewHolder(_view) {
        val imageView = _view.apply { setOnClickListener(ocl) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ImageView(parent.context).apply { layoutParams = ViewGroup.LayoutParams(300, 300) }, image)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imageView.setImageResource(items[position].id)
    }

    override fun getItemCount(): Int {
        return items.size
    }

}
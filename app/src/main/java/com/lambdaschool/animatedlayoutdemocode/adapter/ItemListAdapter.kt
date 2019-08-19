package com.lambdaschool.sprint2_challenge

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.lambdaschool.animatedlayoutdemocode.ItemDetail
import com.lambdaschool.animatedlayoutdemocode.R
import com.lambdaschool.animatedlayoutdemocode.model.ShoppingItem
import kotlinx.android.synthetic.main.shopping_item_layout.view.*

import java.util.ArrayList

class ItemListAdapter(val dataList: List<ShoppingItem>) :
    RecyclerView.Adapter<ItemListAdapter.ViewHolder>() {

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    override fun getItemCount(): Int {
        return dataList.size
    }

    private var lastPosition = -1  // allows us to only animate while scrolling down

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val card = view.card_view as CardView
        val image = view.image as ImageView
        val name = view.name_text as TextView
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.shopping_item_layout, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        val data = dataList[i]
//        val formattedName = data.name.replace("_", " ").replace("[^A-Za-z ]", "")

        /*val re = Regex("[^A-Za-z_ ]")
        val formattedName = re.replace(data.name, "").replace("_", " ")*/

        viewHolder.name.text = data.formattedName
        viewHolder.image.setImageDrawable(viewHolder.image.getContext().getDrawable(data.drawableId))

        viewHolder.card.setOnClickListener { view ->
            val intent = Intent(view.context, ItemDetail::class.java)
            intent.putExtra(ItemDetail.ITEM_KEY, data)

            val optionsBundle: Bundle =
                ActivityOptions.makeSceneTransitionAnimation(view.context as Activity, viewHolder.image, "shared_image")
                    .toBundle()

            view.context.startActivity(intent, optionsBundle)
        }

        setEnterAnimation(viewHolder.card, i)
    }


    private fun setEnterAnimation(viewToAnimate: View, position: Int) {
        if (position > lastPosition) {
            val animation: Animation = AnimationUtils.loadAnimation(viewToAnimate.context, R.anim.hyperspace_jump)
            viewToAnimate.startAnimation(animation)
            lastPosition = position
        }
    }
}

package com.lambdaschool.animatedlayoutdemocode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.lambdaschool.animatedlayoutdemocode.model.ShoppingItem
import kotlinx.android.synthetic.main.activity_item_detail.*

class ItemDetail : AppCompatActivity() {

    companion object {
        const val ITEM_KEY = "SHOPPING_ITEM"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)

        val item = intent.getSerializableExtra(ITEM_KEY) as ShoppingItem

        item_name.text = item.formattedName
        item_image.setImageDrawable(ContextCompat.getDrawable(this, item.drawableId))
    }
}

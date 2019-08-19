package com.lambdaschool.animatedlayoutdemocode.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lambdaschool.animatedlayoutdemocode.R
import com.lambdaschool.animatedlayoutdemocode.model.ShoppingItem
import com.lambdaschool.sprint2_challenge.ItemListAdapter
import com.lambdaschool.sprint2_challenge.ShoppingItemConstants
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        list.layoutManager = layoutManager
        val itemListAdapter = ItemListAdapter(ShoppingItemConstants.generateItems())
        list.adapter = itemListAdapter
    }
}

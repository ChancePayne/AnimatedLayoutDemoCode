package com.lambdaschool.animatedlayoutdemocode.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.lambdaschool.animatedlayoutdemocode.R
import com.lambdaschool.animatedlayoutdemocode.fragment.ListFragment
import com.lambdaschool.animatedlayoutdemocode.model.ShoppingItem

class FragmentActivity : AppCompatActivity(), ListFragment.OnShoppingListFragmentInteractionListener {
    override fun onFragmentInteraction(item: ShoppingItem) {
        Toast.makeText(this, "Fragment Interacted ${item.formattedName}", Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
    }
}

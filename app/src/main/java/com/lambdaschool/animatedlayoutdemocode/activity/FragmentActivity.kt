package com.lambdaschool.animatedlayoutdemocode.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.lambdaschool.animatedlayoutdemocode.R
import com.lambdaschool.animatedlayoutdemocode.fragment.DetailFragment
import com.lambdaschool.animatedlayoutdemocode.fragment.ListFragment
import com.lambdaschool.animatedlayoutdemocode.model.ShoppingItem


// activity that will manage our fragments
class FragmentActivity : AppCompatActivity(), ListFragment.OnShoppingListFragmentInteractionListener {
    override fun onFragmentInteraction(item: ShoppingItem) {
        Toast.makeText(this, "Fragment Interacted ${item.formattedName}", Toast.LENGTH_SHORT).show()

        val dialogFragment: DetailFragment = DetailFragment()

        val bundle = Bundle()
        bundle.putSerializable(ItemDetail.ITEM_KEY, item)

        dialogFragment.arguments = bundle
        dialogFragment.show(supportFragmentManager, "Detail Fragment")

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
    }
}

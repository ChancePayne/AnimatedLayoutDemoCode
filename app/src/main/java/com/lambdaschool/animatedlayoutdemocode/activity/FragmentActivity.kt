package com.lambdaschool.animatedlayoutdemocode.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.lambdaschool.animatedlayoutdemocode.R
import com.lambdaschool.animatedlayoutdemocode.fragment.DetailFragment
import com.lambdaschool.animatedlayoutdemocode.fragment.ListFragment
import com.lambdaschool.animatedlayoutdemocode.model.ShoppingItem
import kotlinx.android.synthetic.main.activity_fragment.*


// activity that will manage our fragments
class FragmentActivity : AppCompatActivity(), ListFragment.OnShoppingListFragmentInteractionListener {
    override fun onFragmentInteraction(item: ShoppingItem) {
        Toast.makeText(this, "Fragment Interacted ${item.formattedName}", Toast.LENGTH_SHORT).show()

        // show fragment as dialog
        val dialogFragment: DetailFragment = DetailFragment()

        val bundle = Bundle()
        bundle.putSerializable(ItemDetail.ITEM_KEY, item)

        dialogFragment.arguments = bundle
        dialogFragment.show(supportFragmentManager, "Detail Fragment")

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        val fragment = ListFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_fragment_holder, fragment)
            .commit()
    }
}

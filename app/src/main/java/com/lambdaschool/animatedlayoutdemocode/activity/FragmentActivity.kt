package com.lambdaschool.animatedlayoutdemocode.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Explode
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
        /*val dialogFragment: DetailFragment = DetailFragment() // DetailFragment must extend DialogFragment

        val bundle = Bundle()
        bundle.putSerializable(ItemDetail.ITEM_KEY, item)

        dialogFragment.arguments = bundle
        dialogFragment.show(supportFragmentManager, "Detail Fragment")*/

        // show fragment in main window
        val fragment = DetailFragment()

        val bundle = Bundle()
        bundle.putSerializable(ItemDetail.ITEM_KEY, item)

        fragment.arguments = bundle
        fragment.enterTransition = Explode()
        fragment.exitTransition = Explode()

        if(secondary_fragment_holder == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_fragment_holder, fragment)
                .addToBackStack(null)
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.secondary_fragment_holder, fragment)
                .commit()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        val fragment = ListFragment()
        fragment.enterTransition = Explode()
        fragment.exitTransition = Explode()

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_fragment_holder, fragment)
            .commit()


    }
}

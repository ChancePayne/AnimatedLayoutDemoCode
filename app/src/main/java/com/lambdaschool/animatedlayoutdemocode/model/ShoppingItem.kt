package com.lambdaschool.animatedlayoutdemocode.model

import java.io.Serializable

class ShoppingItem(val name: String, val drawableId: Int, var selected: Boolean = false) : Serializable {
    val formattedName: String
        get() {
            val re = Regex("[^A-Za-z_ ]")
            return re.replace(this.name, "").replace("_", " ")
        }
}
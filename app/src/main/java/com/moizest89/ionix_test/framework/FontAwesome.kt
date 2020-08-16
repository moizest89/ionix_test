package com.moizest89.ionix_test.framework

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.moizest89.ionix_test.R

class FontAwesome : AppCompatTextView {

    var type = "" // "solid", "regular" or "brand"

    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        init(attrs)
    }
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init(attrs)
    }
    constructor(context: Context?) : super(context) {
        init(null)
    }

    private fun init(attrs: AttributeSet?) {
        if (attrs != null) {
            val a = context!!.obtainStyledAttributes(attrs, R.styleable.FontAwesome)
            if (a.hasValue(R.styleable.FontAwesome_type))
                type = a.getString(R.styleable.FontAwesome_type)!!
            a.recycle()
            if (type == "") type = "solid"
        }
        setIconType(type)
    }

    // Useful if you want to change between a regular and solid icon (example: star)
    fun setIconType(iconType : String){
        type = iconType

        typeface = when (type) {
            "regular" -> Typeface.createFromAsset(context!!.assets,"fontawesome/fa-regular-400.ttf")
            "solid" -> Typeface.createFromAsset(context!!.assets,"fontawesome/fa-solid-900.ttf")
            "brands" -> Typeface.createFromAsset(context!!.assets,"fontawesome/fa-brands-400.ttf")
            else -> Typeface.createFromAsset(context!!.assets,"fontawesome/fa-solid-900.ttf")
        }
    }
}
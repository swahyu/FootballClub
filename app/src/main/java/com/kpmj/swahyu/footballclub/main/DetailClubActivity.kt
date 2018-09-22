package com.kpmj.swahyu.footballclub.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import org.jetbrains.anko.*

class DetailClubActivity : AppCompatActivity() {

    private lateinit var img: ImageView
    private lateinit var name: TextView
    private lateinit var description: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_detail_club)
//
//         img = findViewById<ImageView>(R.id.club_image)
//         name = findViewById<TextView>(R.id.club_name)
//         description = findViewById<TextView>(R.id.club_describtion)

        linearLayout {
            gravity = Gravity.CENTER_HORIZONTAL
            orientation = LinearLayout.VERTICAL
            padding = dip(8)

            img = imageView {}.lparams(width = dip(100), height = dip(100))
            name = textView {}.lparams(width = wrapContent, height = wrapContent)
            description = textView {
                inputType = 131073
            }.lparams(width = matchParent, height = wrapContent) {
                topMargin = dip(16)
            }
        }

        val intent=intent
        img.setImageResource(intent.getIntExtra("IMAGE",0))
        name.text = intent.getStringExtra("NAME")
        description.text = intent.getStringExtra("DESCRIPTION")

    }

}


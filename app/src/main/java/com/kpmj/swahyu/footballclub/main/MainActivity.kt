package com.kpmj.swahyu.footballclub.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.kpmj.swahyu.footballclub.R
import com.kpmj.swahyu.footballclub.adapter.RecyclerViewAdapter
import com.kpmj.swahyu.footballclub.model.Item
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {

    private val items: MutableList<Item> = mutableListOf();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list= findViewById<RecyclerView>(R.id.recyclerViewClub)
        initData()

        list.layoutManager= LinearLayoutManager(this)
        list.adapter=  RecyclerViewAdapter(this,items){
//            val toast=Toast.makeText(applicationContext, it.name, Toast.LENGTH_LONG)
//            toast.show()
            startActivity(intentFor<DetailClubActivity>(
                    "NAME" to it.name,
                    "IMAGE" to it.image,
                    "DESCRIPTION" to it.description))
        }
    }

    private fun initData(){
        val name= resources.getStringArray(R.array.club_name)
        val image= resources.obtainTypedArray(R.array.club_image)
        val description= resources.getStringArray(R.array.club_description)
        items.clear();
        for (i in name.indices){
            items.add(Item(name[i] ,image.getResourceId(i,0),description[i]))
        }
        image.recycle()
    }

}


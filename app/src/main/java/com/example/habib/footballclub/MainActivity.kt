package com.example.habib.footballclub

import android.content.ClipData
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {
    private var items: MutableList<Items> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
        club_list.layoutManager = LinearLayoutManager(this)
        club_list.adapter = ViewAdapter(this,items){
            startActivity<DetailActivity>("name" to "${it.name}","desc" to "${it.desc}","logo" to it.image)
        }
    }

    private fun initData() {
        val name = resources.getStringArray(R.array.club_name)
        val desc = resources.getStringArray(R.array.club_desc)
        val image= resources.obtainTypedArray(R.array.club_image)
        items.clear()
        for(i in name.indices){
            items.add(Items(name[i],desc[i],image.getResourceId(i,0)))
        }
    }
}

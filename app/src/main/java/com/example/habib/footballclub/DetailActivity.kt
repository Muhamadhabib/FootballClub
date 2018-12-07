package com.example.habib.footballclub

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {
    private var name:String = ""
    private var desc:String = ""
    private var logo:Int = 1
    lateinit var nam:TextView
    lateinit var des:TextView
    lateinit var img:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout(){
            padding = dip(16)
            img = imageView().lparams(width=dip(200),height = dip(200)){
                gravity = Gravity.CENTER
            }
            nam = textView(){
                gravity = Gravity.CENTER
                textSize = 20f
            }.lparams(width = matchParent,height = wrapContent){
                topMargin = dip(16)
            }
            des = textView(){
                gravity = Gravity.CENTER
            }.lparams(width = matchParent,height = wrapContent){
                topMargin = dip(16)
            }
        }
        val intent = intent
        name = intent.getStringExtra("name")
        desc = intent.getStringExtra("desc")
        logo = intent.getIntExtra("logo",0)
        nam.text = name
        des.text = desc
        img.setImageResource(logo)
    }
}

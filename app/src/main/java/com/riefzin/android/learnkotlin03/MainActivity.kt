package com.riefzin.android.learnkotlin03

import android.graphics.Color
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import com.riefzin.android.learnkotlin03.R.color.colorAccent
import org.jetbrains.anko.*
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MainActivityUI().setContentView(this)
    }

    class MainActivityUI : AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>)= with(ui) {
            verticalLayout {
                padding = dip(16)
                // Edit Text

                val name = editText {
                    hint = "Nama Saya"
                }
                // Button Show Toast
                button("Click Me"){
                    backgroundColor = ContextCompat.getColor(context, colorAccent)
                    textColor = Color.WHITE
                    onClick { toast("Halo, ${name.text}!") }
                }.lparams(width = matchParent){
                    topMargin = dip(5)
                }

                // Button Show Alert
                button("Show Alert"){
                    backgroundColor = ContextCompat.getColor(context, colorAccent)
                    textColor = Color.WHITE
                    onClick {
                        alert("Selamat Pagi!", "Halo, ${name.text}!") {
                            yesButton { toast("Terimakasih...") }
                            noButton {  }
                        }.show()
                    }
                }.lparams(width = matchParent){
                    topMargin = dip(5)
                }

                // Button Show Selector
                button("Show Selector"){
                    backgroundColor = ContextCompat.getColor(context, colorAccent)
                    textColor = Color.WHITE
                    onClick {
                        val warna = listOf("Merah", "Putih", "Biru", "Hijau")
                        selector("Halo, ${name.text}! Apa warna yang kamu suka?", warna,
                                { dialogInterface, i ->
                                    toast("Okay, kamu memilih ${warna[i]}, ya?")
                                } )
                    }
                }.lparams(width = matchParent){
                    topMargin = dip(5  )
                }

                // Button Snackbar
                button("Show Snackbar"){
                    backgroundColor = ContextCompat.getColor(context, colorAccent)
                    textColor = Color.WHITE
                    onClick {
                        snackbar(name, "Halo, ${name.text}!")
                    }
                }.lparams(width = matchParent){
                    topMargin = dip(5)
                }

                // Button Show Progress Bar
                button("Show Progress Bar"){
                    backgroundColor = ContextCompat.getColor(context, colorAccent)
                    textColor = Color.WHITE
                    onClick {
                        indeterminateProgressDialog("Halo, ${name.text}! Tunggu Sebentar...").show()
                    }
                }.lparams(width = matchParent){
                    topMargin = dip(5)
                }

                // Button Go to Second Activity
                button("Go to Second Activity"){
                    backgroundColor = ContextCompat.getColor(context, colorAccent)
                    textColor = Color.WHITE

                    onClick {
                        startActivity<SecondActivity>("name" to "${name.text}")
                    }
                }.lparams(width = matchParent){
                    topMargin = dip(5)
                }
            }
        }
    }
}

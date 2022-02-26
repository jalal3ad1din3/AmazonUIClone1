package com.example.w

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import org.jsoup.Jsoup
import org.jsoup.nodes.Document


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        printUrlMatadata("url")

    }

    private fun printUrlMatadata(url: String) {
        val doc: Document =
            Jsoup.connect("https://kun.uz/en/news/2022/02/15/gulnara-karimovas-ill-gotten-assets-being-returned-to-uzbekistan")
                .post()
        val keywords: String = doc.select("meta[name=keywords]").first().attr("content");
        Log.d(TAG, "Meta keyword : " + keywords)
        val description: String = doc.select("meta[name=description]")[0].attr("content")
        Log.d(TAG, "Meta description :  $description")
    }

}
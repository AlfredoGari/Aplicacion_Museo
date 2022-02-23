package com.example.museo

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Splash : AppCompatActivity() {

    private var mp:MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(mp==null){
            mp = MediaPlayer.create(this, R.raw.inicio)
        }
        mp?.start()
        Thread.sleep(1500)
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
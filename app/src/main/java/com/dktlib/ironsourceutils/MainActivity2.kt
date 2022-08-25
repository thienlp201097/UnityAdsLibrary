package com.dktlib.ironsourceutils

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.dktlib.ironsourcelib.InterstititialCallback
import com.dktlib.ironsourcelib.ApplovinUtil

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val btn = findViewById<Button>(R.id.btn_2)
        btn.setOnClickListener {
                ApplovinUtil.loadAndShowInterstitialsWithDialogCheckTime(this,"loadandshow",1500,object : InterstititialCallback {
                    override fun onInterstitialReady() {

                    }

                    override fun onInterstitialClosed() {
                        startActivity(Intent(this@MainActivity2, MainActivity3::class.java))


                    }

                    override fun onInterstitialLoadFail(error: String) {
                        startActivity(Intent(this@MainActivity2, MainActivity3::class.java))


                    }

                    override fun onInterstitialShowSucceed() {

                    }
                })
        }
    }
    override fun onResume() {
        val bannerContainer = findViewById<FrameLayout>(R.id.banner_container)
        ApplovinUtil.showBanner(this,bannerContainer,"banner_main")
        super.onResume()
    }
}
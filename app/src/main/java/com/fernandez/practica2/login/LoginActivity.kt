package com.fernandez.practica2.login
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.fernandez.practica2.R
import com.fernandez.practica2.home.HomeActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity:AppCompatActivity() {
    var mInterstitialAd : InterstitialAd?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val actionBar = supportActionBar
        actionBar?.hide()

        MobileAds.initialize(this)
        val adRequest = AdRequest.Builder().build()
        adViewBanner.loadAd(adRequest)
        InterstitialAd.load(this,"ca-app-pub-3940256099942544/1033173712",
            adRequest,object : InterstitialAdLoadCallback() {

                override fun onAdFailedToLoad(adError: LoadAdError) {
                    Log.v("ADS_ADMOB","Intersticial - ERROR")
                    Log.v("ADS_ADMOB",adError.message)
                    mInterstitialAd = null
                }

                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    Log.v("ADS_ADMOB","Intersticial - SUCCESS")
                    mInterstitialAd = interstitialAd
                } })

        btnIniciarSesion.setOnClickListener {
            if(mInterstitialAd != null){
                mInterstitialAd?.show(this)
            }else{
                Log.v("ADS_ADMOB","Instersticial - NO ESTA INICIALIZADO")
            }
            startActivity(Intent(this, HomeActivity::class.java))

        }
    }

}
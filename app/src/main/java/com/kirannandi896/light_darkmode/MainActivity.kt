package com.kirannandi896.light_darkmode

import android.content.Context
import android.hardware.camera2.CameraManager
import android.media.AudioManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.widget.SwitchCompat
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    private lateinit var mCameraManager: CameraManager
    private lateinit var mAudioManager: AudioManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mCameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        mAudioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager

        mAudioManager.playSoundEffect(AudioManager.FX_FOCUS_NAVIGATION_UP, 100.0F)

        val switch = findViewById<SwitchCompat>(R.id.themeChanger)
        val bulb = findViewById<ImageView>(R.id.bulb)
        val back = findViewById<ConstraintLayout>(R.id.back)



        switch.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                mAudioManager.playSoundEffect(AudioManager.FX_KEY_CLICK, 100.0F)
                switch.text = "Turn Light Off".toString()
                switch.setTextColor(getColor(R.color.white))
                bulb.setImageDrawable(getDrawable(R.drawable.pic_bulbon))
                back.setBackground(getDrawable(R.drawable.day))
                mCameraManager.setTorchMode(mCameraManager.cameraIdList[0], true)
            }
            else {
                mAudioManager.playSoundEffect(AudioManager.FX_KEY_CLICK, 100.0F)
                switch.text = "Turn Light On".toString()
                switch.setTextColor(getColor(R.color.white))
                bulb.setImageDrawable(getDrawable(R.drawable.pic_bulboff))
                back.setBackground(getDrawable(R.drawable.night))
                mCameraManager.setTorchMode(mCameraManager.cameraIdList[0], false)
            }
        }

    }
}
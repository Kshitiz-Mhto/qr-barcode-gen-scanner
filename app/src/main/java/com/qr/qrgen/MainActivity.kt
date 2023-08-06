 package com.qr.qrgen

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidmads.library.qrgenearator.QRGContents
import androidmads.library.qrgenearator.QRGEncoder
import com.qr.qrgen.databinding.ActivityMainBinding

 class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGenerate.setOnClickListener {
            val text = binding.enterdText.text.toString()
            val qrEncoder: QRGEncoder = QRGEncoder(text, null, QRGContents.Type.TEXT, 800)
            qrEncoder.colorBlack
//            qrEncoder.colorWhite
            binding.qrCode.setImageBitmap(qrEncoder.getBitmap(6))
            binding.enterdText.setText("")
        }

        binding.btnNavigate.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

    }
}
package com.daniele.intent

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    private var valueReceived = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        valueReceived = intent?.getStringExtra(TAG) ?: ""  //nel caso in cui il TAG sia NULL, questo ci permette di non avere errore e di avere come valore di ritorno ""

        if (valueReceived.isNotEmpty()){
            received.text = "Ciao $valueReceived"
        }
    }

    companion object{
        fun sendIntent(context: Context, value: String){
            val intent = Intent(context, SecondActivity::class.java).apply {
                putExtra(TAG, value)
            }
            context.startActivity(intent)
        }

        private val TAG = SecondActivity::class.java.name + "value"

    }
}
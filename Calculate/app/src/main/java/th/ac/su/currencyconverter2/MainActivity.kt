package th.ac.su.currencyconverter2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var exchangeRate:Double? = null

    var CHANGE_REQOUEST_CODE = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnChangeRate = findViewById<Button>(R.id.btnEdit)
        var tvRateStatus = findViewById<TextView>(R.id.tvRateStatus)

        var btnConvert = findViewById<Button>(R.id.btnConvert)
        var edtUsd = findViewById<EditText>(R.id.edtUsd);
        var tvResult = findViewById<TextView>(R.id.tvResult)

        exchangeRate = 30.0

        btnChangeRate.setOnClickListener {

            var intent = Intent(this@MainActivity,ExchangeRateActivity::class.java)
            intent.putExtra("rate",exchangeRate!!)

            startActivityForResult(intent,CHANGE_REQOUEST_CODE)




        }

        btnConvert.setOnClickListener {

            var usd:Double = edtUsd.text.toString().toDouble()
            var thb = usd * exchangeRate!!

            tvResult.setText(thb.toString()+"THB")


        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode==CHANGE_REQOUEST_CODE && resultCode==Activity.RESULT_OK){
            val rate = data!!.getDoubleExtra("rate",-1.0)
            exchangeRate = rate

            tvRateStatus.setText("*1.00 USD = "+exchangeRate+"THB")
        }
    }



}

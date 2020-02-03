package th.ac.su.currencyconverter2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class ExchangeRateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exchange_rate)

        var btnSave = findViewById<Button>(R.id.btnSave)
        var edtRate = findViewById<EditText>(R.id.edtRate)

        var rate = intent.getDoubleExtra("rate",-1.0)

        edtRate.setText(rate.toString())

        btnSave.setOnClickListener {

            var intent = Intent()
            intent.putExtra("rate",edtRate.text.toString().toDouble())
            setResult(Activity.RESULT_OK,intent)
            finish()
        }

    }
}

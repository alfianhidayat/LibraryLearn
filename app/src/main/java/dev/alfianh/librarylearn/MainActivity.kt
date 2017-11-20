package dev.alfianh.librarylearn

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import dev.alfianh.mylibrary.LibraryActivity
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Log
import com.google.android.gms.common.api.CommonStatusCodes
import com.google.android.gms.vision.barcode.Barcode
import dev.alfianh.mylibrary.LibraryActivity.RC_BARCODE_CAPTURE


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        read_barcode.setOnClickListener { LibraryActivity.start(this@MainActivity, auto_focus.isChecked, use_flash.isChecked) }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode === RC_BARCODE_CAPTURE) {
            if (resultCode === CommonStatusCodes.SUCCESS) {
                if (data != null) {
                    val barcode = data.getParcelableExtra<Barcode>(LibraryActivity.BarcodeObject)
                    status_message.text = ("Success")
                    barcode_value.text = (barcode.displayValue)
                    Log.d(LibraryActivity.TAG, "Barcode read: " + barcode.displayValue)
                } else {
                    status_message.setText(R.string.barcode_failure)
                    Log.d(LibraryActivity.TAG, "No barcode captured, intent data is null")
                }
            } else {
                status_message.text = (String.format(getString(R.string.barcode_error),
                        CommonStatusCodes.getStatusCodeString(resultCode)))
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}

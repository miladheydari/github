package com.xapo.github.utils.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity


import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper


open class BaseActivity : AppCompatActivity() {


    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        val intent = Intent("PERMISSION_RECEIVER")
        intent.putExtra("requestCode", requestCode)
        intent.putExtra("permissions", permissions)
        intent.putExtra("grantResults", grantResults)
        sendBroadcast(intent)
    }
}

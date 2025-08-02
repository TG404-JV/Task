package com.tg.societymanagment.utils
import android.content.Context
import android.widget.Toast
object GetToast{
    fun showToast(message: String,context: Context)  {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

}
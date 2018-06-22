package br.com.leandro.arrowtypeclass.application

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen

class CustomApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        AndroidThreeTen.init(this)
    }
}

package com.droid.movieapprizwansheikh

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

/**
 * Created by RIZWAN on 12-Mar-22.
 */
class MoviesApp: Application() {

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }

}
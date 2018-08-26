package com.xapo.github

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.os.Build
import com.xapo.github.di.ApplicationComponent
import com.xapo.github.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import timber.log.Timber
import uk.co.chrisjenx.calligraphy.CalligraphyConfig
import javax.inject.Inject


class Github : Application(), HasActivityInjector {
    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    companion object {
        private lateinit var component: ApplicationComponent

    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingActivityInjector
    }

    override fun onCreate() {

        super.onCreate()


        component = DaggerApplicationComponent.builder()
                .application(this)
                .build()

        component.inject(this)

        CalligraphyConfig.initDefault(CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Roboto-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        )

        Timber.plant(Timber.DebugTree())



    }
}
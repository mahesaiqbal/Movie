package com.mahesaiqbal.movie

import android.app.Application
import com.mahesaiqbal.movie.core.di.databaseModule
import com.mahesaiqbal.movie.core.di.networkModule
import com.mahesaiqbal.movie.core.di.repositoryModule
import com.mahesaiqbal.movie.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

open class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}
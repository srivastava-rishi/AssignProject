package com.example.assigntask.di

import android.content.Context
import android.preference.Preference
import com.example.assigntask.app.AssignTask
import com.example.assigntask.data.preferences.PreferenceProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext applicationContext: Context): AssignTask {
        return applicationContext as AssignTask
    }

    @Singleton
    @Provides
    fun providePreferenceProvider(@ApplicationContext applicationContext: Context): PreferenceProvider{
        return PreferenceProvider(applicationContext)
    }
}
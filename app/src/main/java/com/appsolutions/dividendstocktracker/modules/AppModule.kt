package com.appsolutions.dividendstocktracker.modules

import android.content.Context
import androidx.room.Room
import com.appsolutions.dividendstocktracker.data.DividendApi
import com.appsolutions.dividendstocktracker.data.TickerDatabase
import com.appsolutions.dividendstocktracker.repository.DefaultRepository
import com.appsolutions.dividendstocktracker.repository.DividendRepository
import com.appsolutions.dividendstocktracker.util.DispatcherProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesDividendApi(): DividendApi = Retrofit.Builder()
        .baseUrl("https://api.polygon.io/v3/reference/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(DividendApi::class.java)

    @Singleton
    @Provides
    fun provideTickerDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        TickerDatabase::class.java,
        "ticker_db"
    ).build()

    @Singleton
    @Provides
    fun providesTickerDao(tickerDB: TickerDatabase) = tickerDB.getTickerDao()

    @Singleton
    @Provides
    fun providesDividendRepository(api: DividendApi) : DividendRepository = DefaultRepository(api)

    @Singleton
    @Provides
    fun providesDispatchers(): DispatcherProvider = object : DispatcherProvider{
        override val main: CoroutineDispatcher
            get() = Dispatchers.Main
        override val io: CoroutineDispatcher
            get() = Dispatchers.IO
        override val default: CoroutineDispatcher
            get() = Dispatchers.Default
        override val unconfined: CoroutineDispatcher
            get() = Dispatchers.Unconfined

    }
}
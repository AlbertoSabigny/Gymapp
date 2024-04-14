package com.mis.gymapp.data.network

import com.mis.gymapp.data.ExerciseRepositoryImpl
import com.mis.gymapp.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("X-RapidAPI-Key", "14eb6706ddmsh25ad8b0b3da8c1ap1f1014jsn6b3df9425426")
                    .addHeader("X-RapidAPI-Host", "exercisedb.p.rapidapi.com")
                    .build()
                chain.proceed(request)
            }
            .build()
    }




    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://exercisedb.p.rapidapi.com/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideExerciseApiService(retrofit: Retrofit): ExerciseApiService {
        return retrofit.create(ExerciseApiService::class.java)
    }

    @Provides
    fun provideRepository(apiService: ExerciseApiService): Repository {
        return ExerciseRepositoryImpl(apiService)
    }

}

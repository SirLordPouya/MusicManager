package ir.heydarii.musicmanager.base.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.heydarii.musicmanager.repository.dbinteractor.AlbumsDAO
import ir.heydarii.musicmanager.utils.AppDatabase
import javax.inject.Singleton

/**
 * Provides room database
 */
@InstallIn(SingletonComponent::class)
@Module
class RoomModule {

    @Singleton
    @Provides
    fun database(application: Application): AppDatabase = Room.databaseBuilder(
        application.applicationContext,
        AppDatabase::class.java,
        "Albums.db"
    ).build()

    @Singleton
    @Provides
    fun provideAlbumsDAO(appDatabase: AppDatabase): AlbumsDAO = appDatabase.albumsDAO()
}

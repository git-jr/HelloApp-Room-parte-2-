package br.com.alura.helloapp.di.module

import android.content.Context
import androidx.room.Room
import br.com.alura.helloapp.database.ContatoDao
import br.com.alura.helloapp.database.HelloAppDatabase
import br.com.alura.helloapp.database.UsuarioDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private const val DATABASE_NAME = "helloApp.db"

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): HelloAppDatabase {
        return Room.databaseBuilder(
            context,
            HelloAppDatabase::class.java,
            DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    fun provideContatoDao(db: HelloAppDatabase): ContatoDao {
        return db.contatoDao()
    }

    @Provides
    fun provideUsuarioDao(db: HelloAppDatabase): UsuarioDao {
        return db.usuarioDao()
    }
}
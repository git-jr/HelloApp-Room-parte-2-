package br.com.alura.helloapp.database

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.com.alura.helloapp.data.Contato
import br.com.alura.helloapp.data.Usuario
import br.com.alura.helloapp.database.converters.*

@Database(
    entities = [Contato::class, Usuario::class],
    version = 3,
    exportSchema = true,
    autoMigrations = [AutoMigration(2,3)]
)
@TypeConverters(Converters::class)
abstract class HelloAppDatabase : RoomDatabase() {
    abstract fun contatoDao(): ContatoDao
    abstract fun usuarioDao(): UsuarioDao
}
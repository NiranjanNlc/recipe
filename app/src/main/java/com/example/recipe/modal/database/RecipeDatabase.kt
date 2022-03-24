package com.example.recipe.modal.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.recipe.modal.dao.ReciepeDao
import com.example.recipe.modal.data.ConverterClass
import com.example.recipe.modal.data.RecipeItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [RecipeItem::class], version = 1)
@TypeConverters(ConverterClass::class)
abstract class ReciepeDataBase : RoomDatabase() {
    abstract fun reciepedDao(): ReciepeDao
    private class ReciepeDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    //do something here

                }
            }
        }
    }

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: ReciepeDataBase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): ReciepeDataBase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database]
            println("You have acces over here ")
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ReciepeDataBase::class.java,
                    "reciepe_database"
                ).addCallback(ReciepeDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }


    }
}
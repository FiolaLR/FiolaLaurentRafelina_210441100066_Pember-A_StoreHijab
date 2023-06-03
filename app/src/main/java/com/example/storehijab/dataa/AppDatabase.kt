package com.example.storehijab.dataa

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.storehijab.dataa.dao.penggunaDao
import com.example.storehijab.dataa.entity.pengguna

@Database(entities = [pengguna::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun PenggunaDao(): penggunaDao

    companion object{
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase{
            if (instance==null){
                instance = Room.databaseBuilder(context, AppDatabase::class.java,"app-database")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()

            }
            return instance!!
        }
    }

}
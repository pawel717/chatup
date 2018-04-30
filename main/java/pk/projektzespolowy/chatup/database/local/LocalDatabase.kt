package pk.projektzespolowy.chatup.database.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import pk.projektzespolowy.chatup.database.entities.User

@Database(entities = arrayOf(User::class), version = 1)
abstract class LocalDatabase : RoomDatabase()
{
    abstract fun userDataDao() : IUserDao

    companion object {
        private var INSTANCE: LocalDatabase? = null
        fun getInstance(context: Context) : LocalDatabase?
        {
            if(INSTANCE == null){
                synchronized(LocalDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            LocalDatabase::class.java, "database.db").build()
                }
            }

            return INSTANCE
        }
    }

    fun destroyInstance()
    {
        INSTANCE = null
    }
}
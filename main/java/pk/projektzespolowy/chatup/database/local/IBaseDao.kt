package pk.projektzespolowy.chatup.database.local

import android.arch.persistence.room.*

@Dao
interface IBaseDao <T>
{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg obj: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(obj: T)

    @Delete
    fun delete(obj: T)

    @Update
    fun update(obj: T)
}
package pk.projektzespolowy.chatup.database.local

import android.arch.persistence.room.*
import pk.projektzespolowy.chatup.database.entities.User

@Dao
interface IUserDao : IBaseDao<User>
{
    @Query("SELECT * from user where username = :username")
    fun getUser(username : String) : User
}
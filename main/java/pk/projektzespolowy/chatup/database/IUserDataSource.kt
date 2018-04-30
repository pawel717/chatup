package pk.projektzespolowy.chatup.database

import kotlinx.coroutines.experimental.Deferred
import pk.projektzespolowy.chatup.database.entities.User

interface IUserDataSource
{
    interface IUserListener
    {
        fun onSuccess(user : User)
        fun onFaliure(code: Int)
    }

    fun getUser(username : String, listener: IUserListener) : Deferred<User?>

    fun deleteUser(username : String)

    fun saveUser(user : User)

    fun refreshUser(username : User)
}
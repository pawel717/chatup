package pk.projektzespolowy.chatup.database

import pk.projektzespolowy.chatup.database.entities.User

interface IUserRepo
{
    fun getUser(username : String, listener: IUserDataSource.IUserListener) : User?
}
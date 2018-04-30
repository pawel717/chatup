package pk.projektzespolowy.chatup.login.manager

import android.content.Context
import kotlinx.coroutines.experimental.async
import pk.projektzespolowy.chatup.database.IUserDataSource
import pk.projektzespolowy.chatup.database.UserRepo
import pk.projektzespolowy.chatup.database.entities.User

class PoorLoginManager(val context : Context): ILoginManager, IUserDataSource.IUserListener
{
    override fun onSuccess(user: User) {
    }

    override fun onFaliure(code: Int) {
    }

    override fun logIn(username: String, password: String): Boolean
    {
        val repo = UserRepo(context)
        var dbUser : User? = null

        val value = repo.getUser(username,this@PoorLoginManager)
//        repo.getUser(username, object : IUserDataSource.IUserListener {
//            override fun onFaliure(code: Int) {
//                dbUser = null
//            }
//
//            override fun onSuccess(user: User) {
//
//                dbUser = user
//                if (username.equals(dbUser!!.username) && password.equals("1234"))
//                    return@logIn true
//                //  else
//                //     return false
//            }
//        })

        if(value != null) {
           // if (username.equals(dbUser!!.username) && password.equals("1234"))
                return true
          //  else
           //     return false
        }
         else return false
    }

}
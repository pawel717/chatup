package pk.projektzespolowy.chatup.database

import android.content.Context
import android.util.Log
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import pk.projektzespolowy.chatup.database.entities.User
import pk.projektzespolowy.chatup.database.local.UserLocalDataSource
import pk.projektzespolowy.chatup.database.remote.UserRemoteDataSource

class UserRepo(context : Context) : IUserRepo
{
    val localDataSource : IUserDataSource
    val remoteDataSource : IUserDataSource

    init
    {
        localDataSource = UserLocalDataSource(context)
        remoteDataSource = UserRemoteDataSource()
    }

    override fun getUser(username : String, listener : IUserDataSource.IUserListener) : User?
    //= runBlocking{
    {
        var user = User()
        user.username = "aaaa"
        user.password = "1234"
       localDataSource.saveUser(user)
    //Thread.sleep(2000)
        var result : User? = runBlocking {
            val rresult = localDataSource.getUser(username, listener)
            rresult.await()
        }

        return result
//        val job = launch {
//        localDataSource.saveUser(user)
//        val result = localDataSource.getUser(username, listener)
//        Log.d("UserRepo", result.await().toString())
//    }
//        return result


        //return localDataSource.getUser(username, listener)
    }
           // var dbUser: User? = null
            //val job = async {
             //   localDataSource.getUser(username, object : IUserDataSource.IUserListener {
              //      override fun onFaliure(code: Int) {
              //          dbUser = null
              //      }

                  //  override fun onSuccess(user: User) {
                   //     dbUser = user
                    //}
                //})
           // }

            //job.await()
        //return@runBlocking dbUser
        //}

}
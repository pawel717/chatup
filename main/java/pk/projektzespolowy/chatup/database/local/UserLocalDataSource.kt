package pk.projektzespolowy.chatup.database.local

import android.content.Context
import kotlinx.coroutines.experimental.*
import pk.projektzespolowy.chatup.R.string.username
import pk.projektzespolowy.chatup.database.IUserDataSource
import pk.projektzespolowy.chatup.database.entities.User
import pk.projektzespolowy.chatup.utils.AppExexutors

class UserLocalDataSource(context : Context) : IUserDataSource
{
    private val dao : IUserDao

    private val appExecutors : AppExexutors

    init
    {
        dao = LocalDatabase.getInstance(context)!!.userDataDao()
        appExecutors = AppExexutors()
    }

    override fun getUser(username: String, listener: IUserDataSource.IUserListener) : Deferred<User?> {
        return async(CommonPool) {
            Thread.sleep(2000)
            // for (i in 1..10000)
                //for(i in 1..10000)
                  //  print("aa")
            dao.getUser(username)
        }
    }
//        var user : User? = null
//        val runnable = Runnable {
//            user = dao.getUser(username)
//            appExecutors.mainThread().execute(Runnable {
//                if (user == null) {
//                    // This will be called if the table is new or just empty.
//                   // listener.onFaliure(500)
//                } else {
//                    //listener.onSuccess(user!!)
//                }
//            })
//        }
//
//        val job  = launch{appExecutors.diskIO().execute(runnable)}
//        job.join()


  //      return@runBlocking user

//        Thread(Runnable {
//            var user = dao.getUser(username)
//
//            if(user != null)
//                listener.onSuccess(user)
//            else
//                listener.onFaliure(501)
//
//        }).start()
 //   }

    override fun deleteUser(username: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun saveUser(user: User) {
        checkNotNull(user)
        val runnable = Runnable {
            dao.insert(user)
        }

        appExecutors.diskIO().execute(runnable)
    }

    override fun refreshUser(username: User) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
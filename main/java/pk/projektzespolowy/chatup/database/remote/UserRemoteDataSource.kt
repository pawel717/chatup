package pk.projektzespolowy.chatup.database.remote

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async
import pk.projektzespolowy.chatup.database.IUserDataSource
import pk.projektzespolowy.chatup.database.entities.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRemoteDataSource : IUserDataSource
{
    private val api : ChatUpApi

    init
    {
        api = ChatUpApi.create()
    }

    override fun getUser(username: String, listener: IUserDataSource.IUserListener): Deferred<User?> {

        api.getUser(username).enqueue(object : Callback<User> {

            override fun onResponse(call: Call<User>?, response: Response<User>?) {
                if (response != null && response.isSuccessful) {
                    listener.onSuccess(response.body()!!)
                } else {
                    listener.onFaliure(response!!.code())
                }
            }

            override fun onFailure(call: Call<User>?, t: Throwable?) {
                //response codes
                listener.onFaliure(500)
            }
        })
        return async(CommonPool) {
            api.getUser(username).execute().body()
        }
    }

    override fun deleteUser(username: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun saveUser(user: User) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun refreshUser(username: User) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
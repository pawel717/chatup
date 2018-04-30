package pk.projektzespolowy.chatup.database.remote

import pk.projektzespolowy.chatup.database.entities.User
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//moshi
interface ChatUpApi
{
    @GET("/users/{user}")
    fun getUser(@Path("user") username : String) : Call<User>

    companion object Factory
    {
        fun create() : ChatUpApi
        {
            val retrofit = Retrofit.Builder()
                    .baseUrl("https://api.github.com/")  // need to add
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            return retrofit.create(ChatUpApi::class.java)
        }
    }
}
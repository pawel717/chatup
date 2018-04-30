package pk.projektzespolowy.chatup.login.manager

interface ILoginManager
{
    fun logIn(username : String, password : String) : Boolean
}
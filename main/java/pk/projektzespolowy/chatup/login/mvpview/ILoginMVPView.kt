package pk.projektzespolowy.chatup.login.mvpview

import pk.projektzespolowy.chatup.mvpview.IMVPView

interface ILoginMVPView : IMVPView
{
    interface ILoginMVPViewListener
    {
        fun onLoginButtonClicked()
        fun OnPasswordEdited(id : Int) : Boolean
    }

    fun setListener(listener : ILoginMVPViewListener)
}
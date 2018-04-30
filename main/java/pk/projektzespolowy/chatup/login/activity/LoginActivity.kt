package pk.projektzespolowy.chatup.login.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.MainThread
import android.support.annotation.UiThread
import android.view.LayoutInflater
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import android.widget.Toast

import kotlinx.android.synthetic.main.login_mvp_view.*
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.withContext
import kotlinx.coroutines.experimental.android.UI
import pk.projektzespolowy.chatup.R
import pk.projektzespolowy.chatup.R.id.textview_password
import pk.projektzespolowy.chatup.login.manager.ILoginManager
import pk.projektzespolowy.chatup.login.manager.PoorLoginManager
import pk.projektzespolowy.chatup.login.mvpview.ILoginMVPView
import pk.projektzespolowy.chatup.login.mvpview.LoginMVPView
import java.util.concurrent.Executor
import kotlin.coroutines.experimental.CoroutineContext

/**
 * A login screen
 */

class LoginActivity() : AppCompatActivity(), ILoginMVPView.ILoginMVPViewListener
{

    lateinit var mvpView : ILoginMVPView
    lateinit var loginManager : ILoginManager

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        mvpView = LoginMVPView(LayoutInflater.from(this), null)
        setContentView(mvpView.getRootView())
        mvpView.setListener(this)

        loginManager = PoorLoginManager(mvpView.getRootView().context)
    }

    private fun isPasswordValid(password: String): Boolean {
        return password.length > 4
    }

    override fun onLoginButtonClicked()
    {
        launch(UI) {
            var bol : Boolean = false
            withContext(CommonPool){
                bol = loginManager.logIn(textview_login.text.toString(), textview_password.text.toString())

            }
            if(bol == true)
            {Toast.makeText(this@LoginActivity, "LOGGED", Toast.LENGTH_SHORT ).show()}
            else
            {  Toast.makeText(this@LoginActivity, "Wrong", Toast.LENGTH_SHORT ).show()}
        }
        //{Toast.makeText(this, "LOGGED", Toast.LENGTH_SHORT ).show()}
       // else
        //{  Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT ).show()}
    }

    override fun OnPasswordEdited(id : Int) : Boolean
    {
        if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL)
        {
            if (isPasswordValid(textview_password.text.toString()))
            {
                textview_password.error = getString(R.string.error_invalid_password)
                textview_password.requestFocus()
            }

            return true
        }

       return false
    }

}

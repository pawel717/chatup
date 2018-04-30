package pk.projektzespolowy.chatup.login.mvpview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import pk.projektzespolowy.chatup.R
import pk.projektzespolowy.chatup.login.mvpview.ILoginMVPView.ILoginMVPViewListener

class LoginMVPView(inflater : LayoutInflater, container : ViewGroup?) : ILoginMVPView
{
    private var listener : ILoginMVPViewListener? = null
    private val rootView : View
    private val buttonLogIn : Button
    private val textviewPassword : TextView

    init
    {
        rootView  = inflater.inflate(R.layout.login_mvp_view, container, false)

        buttonLogIn = rootView.findViewById(R.id.button_login)
        buttonLogIn.setOnClickListener(View.OnClickListener {
                    v -> listener?.onLoginButtonClicked() })

        textviewPassword = rootView.findViewById(R.id.textview_password)
        textviewPassword.setOnEditorActionListener(TextView.OnEditorActionListener { v, id, event ->
            if(listener != null)
                return@OnEditorActionListener listener!!.OnPasswordEdited(id)
            false
        })
    }

    override fun getRootView(): View
    {
        return rootView
    }

    override fun getViewState(): Bundle?
    {
        return null
    }

    override fun setListener(listener: ILoginMVPViewListener)
    {
        this.listener = listener
    }

}
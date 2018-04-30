package pk.projektzespolowy.chatup.mvpview

import android.os.Bundle
import android.view.View

interface IMVPView
{
    public fun getRootView() : View

    public fun getViewState() : Bundle?

}
package sport.tsse.com.sportapp.onboarding.forgotPassword

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import sport.tsse.com.sportapp.R.layout.fragment_forgot_password

/**
 * Created by mohammedali on 09/03/2017.
 */

class ForgotPasswordFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(fragment_forgot_password, container, false)


        return view
    }
}
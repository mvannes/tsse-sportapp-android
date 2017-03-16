package sport.tsse.com.sportapp.onboarding.login

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_login.*
import sport.tsse.com.sportapp.SingleFragmentNavigationActivity
import sport.tsse.com.sportapp.exercise.detail.ExerciseDetailActivity
import sport.tsse.com.sportapp.R
import sport.tsse.com.sportapp.onboarding.forgotPassword.ForgotPasswordActivity

/**
 * Created by mohammedali on 09/03/2017.
 */
class LoginFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        having_trouble.setOnClickListener {
            startActivity(Intent(activity, ForgotPasswordActivity::class.java))
        }

        loginButton.setOnClickListener {
            startActivity(Intent(activity, SingleFragmentNavigationActivity::class.java))
        }
    }
}

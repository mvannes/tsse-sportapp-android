package sport.tsse.com.sportapp

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_startup.*
import sport.tsse.com.sportapp.onboarding.login.LoginActivity
import sport.tsse.com.sportapp.onboarding.register.RegisterActivity

class StartupFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_startup, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        startNowButton.setOnClickListener {
            startActivity(Intent(activity, RegisterActivity::class.java))
        }

        loginTextView.setOnClickListener {
            startActivity(Intent(activity, LoginActivity::class.java))
        }
    }
}
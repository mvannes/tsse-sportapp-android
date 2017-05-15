package sport.tsse.com.sportapp.onboarding.register

import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import kotlinx.android.synthetic.main.activity_onboarding.*
import sport.tsse.com.sportapp.onboarding.SingleFragmentOnboardingActivity
import sport.tsse.com.sportapp.onboarding.register.username.RegisterUsernameFragment

class RegisterActivity : SingleFragmentOnboardingActivity() {

    override fun setToolbar(): Toolbar? {
        return toolbar
    }

    override fun createFragment(): Fragment {
        return RegisterUsernameFragment()
    }
}

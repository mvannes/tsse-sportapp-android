package sport.tsse.com.sportapp.onboarding.login

import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import kotlinx.android.synthetic.main.activity_onboarding_fragment.*
import sport.tsse.com.sportapp.onboarding.SingleFragmentOnboardingActivity

/**
 * tsse-sportapp-android
 *
 * @author Mitchell de Vries
 */
class LoginActivity : SingleFragmentOnboardingActivity() {
    override fun createFragment(): Fragment {
        return LoginFragment()
    }

    override fun setToolbar(): Toolbar? {
        return toolbar
    }

}
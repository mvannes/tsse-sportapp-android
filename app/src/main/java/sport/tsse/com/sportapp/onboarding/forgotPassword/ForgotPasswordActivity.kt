package sport.tsse.com.sportapp.onboarding.forgotPassword

import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import kotlinx.android.synthetic.main.activity_onboarding.*
import sport.tsse.com.sportapp.onboarding.SingleFragmentOnboardingActivity

class ForgotPasswordActivity : SingleFragmentOnboardingActivity() {
    override fun createFragment(): Fragment {
        return ForgotPasswordFragment()
    }

    override fun setToolbar(): Toolbar? {
        return toolbar
    }
}

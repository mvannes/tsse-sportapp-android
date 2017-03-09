package sport.tsse.com.sportapp

import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import sport.tsse.com.sportapp.onboarding.SingleFragmentOnboardingActivity

class StartupActivity : SingleFragmentOnboardingActivity() {
    override fun createFragment(): Fragment {
        return StartupFragment()
    }

    override fun setToolbar(): Toolbar? {
        return null
    }
}

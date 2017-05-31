package sport.tsse.com.sportapp.onboarding.register.completed

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_onboarding_completed.*
import sport.tsse.com.sportapp.R
import sport.tsse.com.sportapp.base.SingleFragmentNavigationActivity


class RegistrationCompletedFragment : Fragment(), RegistrationCompletedView {

    lateinit private var presenter: RegistrationCompletedPresenter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_onboarding_completed, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val actionbar = context as AppCompatActivity
        actionbar.supportActionBar?.setDisplayHomeAsUpEnabled(false)


        presenter = RegistrationCompletedPresenter(this)
        presenter.start()
    }

    override fun goToHome() {
        continueButton.setOnClickListener {
            val intent = Intent(activity, SingleFragmentNavigationActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
    }
}
package sport.tsse.com.sportapp.onboarding.register.email

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.onboarding_fab.*
import sport.tsse.com.sportapp.R
import sport.tsse.com.sportapp.onboarding.register.name.RegisterNameFragment


class RegisterEmailFragment : Fragment(), RegisterEmailContract.View {

    lateinit private var presenter: RegisterEmailContract.Presenter

    override fun setPresenter(presenter: RegisterEmailContract.Presenter) {
        this.presenter = presenter
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_onboarding_email_input, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fab.setOnClickListener({
            fragmentManager.beginTransaction()
                    .setCustomAnimations(
                            R.anim.enter_from_right_onboarding,
                            R.anim.exit_to_left_onboarding,
                            R.anim.enter_from_left_onboarding,
                            R.anim.exit_to_right_onboarding
                    )
                    .replace(R.id.fragmentContainer, RegisterNameFragment())
                    .addToBackStack(null)
                    .commit()
        })
    }
}
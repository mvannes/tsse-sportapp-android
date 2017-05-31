package sport.tsse.com.sportapp.onboarding.register.username

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_onboarding_username_input.*
import kotlinx.android.synthetic.main.onboarding_fab.*
import sport.tsse.com.sportapp.R
import sport.tsse.com.sportapp.data.User
import sport.tsse.com.sportapp.onboarding.register.name.RegisterNameFragment


class RegisterUsernameFragment : Fragment(), RegisterUsernameView {

    lateinit private var presenter: RegisterUsernamePresenter
    private var user: User = User()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_onboarding_username_input, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fab.setOnClickListener({
            presenter = RegisterUsernamePresenter(this, user, usernameWrapper?.editText!!.text.toString())
            presenter.start()
        })
    }

    override fun performUsernameCheck(valid: Boolean): Boolean {
        if (!valid) {
            usernameWrapper.isErrorEnabled = true
            usernameWrapper.error = resources.getString(R.string.validate_email_error_message)
            return false
        } else {
            usernameWrapper.isErrorEnabled = false
            usernameWrapper.error = ""
            return true
        }
    }

    override fun goToRegisterNameFragment(user: User) {
        fragmentManager.beginTransaction()
                .setCustomAnimations(
                        R.anim.enter_from_right_onboarding,
                        R.anim.exit_to_left_onboarding,
                        R.anim.enter_from_left_onboarding,
                        R.anim.exit_to_right_onboarding
                ).replace(R.id.fragmentContainer, RegisterNameFragment().newInstance(user))
                .addToBackStack(null)
                .commit()
    }
}
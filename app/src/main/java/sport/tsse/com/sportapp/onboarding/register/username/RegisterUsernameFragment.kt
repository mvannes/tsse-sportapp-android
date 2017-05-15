package sport.tsse.com.sportapp.onboarding.register.username

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
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
        presenter = RegisterUsernamePresenter(this)
        presenter.start()
    }

    override fun setUsernameOnTextChanged() {
        usernameInputEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                user.username = s.toString()
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
    }

    override fun goToRegisterNameFragment() {
        fab.setOnClickListener({
            fragmentManager.beginTransaction()
                    .setCustomAnimations(
                            R.anim.enter_from_right_onboarding,
                            R.anim.exit_to_left_onboarding,
                            R.anim.enter_from_left_onboarding,
                            R.anim.exit_to_right_onboarding
                    )
                    .replace(R.id.fragmentContainer, RegisterNameFragment().newInstance(user))
                    .addToBackStack(null)
                    .commit()
        })
    }
}
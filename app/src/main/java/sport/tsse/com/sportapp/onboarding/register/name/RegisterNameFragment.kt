package sport.tsse.com.sportapp.onboarding.register.name

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_onboarding_name_input.*
import kotlinx.android.synthetic.main.onboarding_fab.*
import sport.tsse.com.sportapp.R
import sport.tsse.com.sportapp.data.User
import sport.tsse.com.sportapp.onboarding.register.birthdate.RegisterBirthdateFragment


/**
 * Created by mohammedali on 09/03/2017.
 */

class RegisterNameFragment : Fragment(), RegisterNameView {

    private val ARG_USER: String? = "sport.tsse.com.sportapp.onboarding.register.name.RegisterNameFragment.user"

    lateinit private var presenter: RegisterNamePresenter

    fun newInstance(user: User): RegisterNameFragment {
        val registerNameFragment = RegisterNameFragment()

        val args = Bundle()
        args.putSerializable(ARG_USER, user)
        registerNameFragment.arguments = args

        return registerNameFragment
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_onboarding_name_input, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fab.setOnClickListener {
            presenter = RegisterNamePresenter(this, arguments?.getSerializable(ARG_USER) as User,
                    firstNameWrapper?.editText!!.text.toString(),
                    lastNameWrapper?.editText!!.text.toString())
            presenter.start()
        }
    }

    override fun performFirstNameCheck(validate: Boolean): Boolean {
        if (!validate) {
            firstNameWrapper.isErrorEnabled = true
            firstNameWrapper.error = resources.getString(R.string.validate_name_error_message)
            return false
        } else {
            firstNameWrapper.isErrorEnabled = false
            firstNameWrapper.error = ""
            return true
        }
    }

    override fun performLastNameCheck(validate: Boolean): Boolean {
        if (!validate) {
            lastNameWrapper.isErrorEnabled = true
            lastNameWrapper.error = resources.getString(R.string.validate_name_error_message)
            return false
        } else {
            lastNameWrapper.isErrorEnabled = false
            lastNameWrapper.error = ""
            return true
        }
    }

    override fun goToRegisterBirthdateFragment(user: User) {
        fragmentManager.beginTransaction()
                .setCustomAnimations(
                        R.anim.enter_from_right_onboarding,
                        R.anim.exit_to_left_onboarding,
                        R.anim.enter_from_left_onboarding,
                        R.anim.exit_to_right_onboarding
                )
                .replace(R.id.fragmentContainer, RegisterBirthdateFragment().newInstance(user))
                .addToBackStack(null)
                .commit()
    }
}
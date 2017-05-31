package sport.tsse.com.sportapp.onboarding.register.password

import android.app.ProgressDialog
import android.app.ProgressDialog.STYLE_SPINNER
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_onboarding_password_input.*
import kotlinx.android.synthetic.main.onboarding_fab.*
import sport.tsse.com.sportapp.R
import sport.tsse.com.sportapp.data.User
import sport.tsse.com.sportapp.network.Api
import sport.tsse.com.sportapp.onboarding.register.completed.RegistrationCompletedFragment


/**
 * Created by mohammedali on 09/03/2017.
 */

class RegisterPasswordFragment : Fragment(), RegisterPasswordView {

    private val ARG_USER: String = "sport.tsse.com.sportapp.onboarding.register.password.RegisterPasswordFragment.user"

    lateinit private var presenter: RegisterPasswordPresenter
    lateinit private var progressDialog: ProgressDialog

    fun newInstance(newUser: User): RegisterPasswordFragment {
        val registerPasswordFragment = RegisterPasswordFragment()

        val args = Bundle()
        args.putSerializable(ARG_USER, newUser)
        registerPasswordFragment.arguments = args

        return registerPasswordFragment
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_onboarding_password_input, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        progressDialog = ProgressDialog(activity)

        fab.setOnClickListener {
            presenter = RegisterPasswordPresenter(
                    this,
                    Api(),
                    arguments?.getSerializable(ARG_USER) as User,
                    passwordWrapper?.editText!!.text.toString()
            )
            presenter.start()
        }
    }

    override fun performPasswordCheck(valid: Boolean): Boolean {
        if (!valid) {
            passwordWrapper.isErrorEnabled = true
            passwordWrapper.error = resources.getString(R.string.validate_password_error_message)
            return false
        } else {
            passwordWrapper.isErrorEnabled = false
            passwordWrapper.error = ""
            return true
        }
    }

    override fun showProgress() {
        progressDialog.setCancelable(false)
        progressDialog.setProgressStyle(STYLE_SPINNER)
        progressDialog.setTitle(resources.getString(R.id.please_wait))
        progressDialog.setMessage(resources.getString(R.id.onboarding_post_message))
        progressDialog.show()
    }

    override fun hideProgress() {
        progressDialog.hide()
    }

    override fun showError(errorMessage: String) {
        AlertDialog.Builder(context)
                .setTitle("Error")
                .setMessage(errorMessage)
                .setPositiveButton(android.R.string.ok, null)
                .create()
                .show()
    }

    override fun goToRegistrationCompletedFragment() {
        fragmentManager.beginTransaction()
                .setCustomAnimations(
                        R.anim.enter_from_right_onboarding,
                        R.anim.exit_to_left_onboarding,
                        R.anim.enter_from_left_onboarding,
                        R.anim.exit_to_right_onboarding
                ).replace(R.id.fragmentContainer, RegistrationCompletedFragment())
                .addToBackStack(null)
                .commit()
    }
}

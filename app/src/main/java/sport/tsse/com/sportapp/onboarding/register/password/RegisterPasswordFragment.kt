package sport.tsse.com.sportapp.onboarding.register.password

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

/**
 * Created by mohammedali on 09/03/2017.
 */

class RegisterPasswordFragment : Fragment(), RegisterPasswordView {

    private val ARG_USER: String? = "sport.tsse.com.sportapp.onboarding.register.password.RegisterPasswordFragment.user"

    lateinit private var presenter: RegisterPasswordPresenter

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

        fab.setOnClickListener {
            presenter = RegisterPasswordPresenter(this,
                    Api(),
                    arguments?.getSerializable(ARG_USER) as User,
                    passwordWrapper?.editText!!.text.toString())
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
        progressBar.visibility = View.VISIBLE
        registerPasswordLayout.visibility = View.GONE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
        registerPasswordLayout.visibility = View.VISIBLE
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
    }
}

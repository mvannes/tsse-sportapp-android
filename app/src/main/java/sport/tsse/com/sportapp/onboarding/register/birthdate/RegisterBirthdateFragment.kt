package sport.tsse.com.sportapp.onboarding.register.birthdate

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_onboarding_birth_date_input.*
import kotlinx.android.synthetic.main.onboarding_fab.*
import sport.tsse.com.sportapp.R
import sport.tsse.com.sportapp.data.User
import sport.tsse.com.sportapp.onboarding.register.password.RegisterPasswordFragment
import java.util.*


/**
 * Created by mohammedali on 09/03/2017.
 */

class RegisterBirthdateFragment : Fragment(), RegisterBirthdateView {

    private val ARG_USER: String = "sport.tsse.com.sportapp.onboarding.register.birthdate.RegisterBirthdateFragment.user"

    lateinit private var presenter: RegisterBirthdatePresenter
    private var calendar = Calendar.getInstance()

    fun newInstance(newUser: User): RegisterBirthdateFragment {
        val registerBirthdateFragment = RegisterBirthdateFragment()

        val args = Bundle()
        args.putSerializable(ARG_USER, newUser)
        registerBirthdateFragment.arguments = args

        return registerBirthdateFragment
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_onboarding_birth_date_input, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setBirthdateFromDatePicker()

        fab.setOnClickListener {
            presenter = RegisterBirthdatePresenter(this, arguments?.getSerializable(ARG_USER) as User, calendar)
            presenter.start()
        }
    }

    private fun setBirthdateFromDatePicker() {
        val calendar: Calendar = Calendar.getInstance()
        calendar.timeInMillis = System.currentTimeMillis()
        birthdateDatePicker.maxDate = calendar.timeInMillis

        birthdateDatePicker.init(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        ) {
            _, year, month, dayOfMonth ->
            calendar.set(year, month, dayOfMonth)
        }
    }

    override fun gotoRegisterPasswordFragment(user: User) {
        fragmentManager.beginTransaction()
                .setCustomAnimations(
                        R.anim.enter_from_right_onboarding,
                        R.anim.exit_to_left_onboarding,
                        R.anim.enter_from_left_onboarding,
                        R.anim.exit_to_right_onboarding
                )
                .replace(R.id.fragmentContainer, RegisterPasswordFragment().newInstance(user))
                .addToBackStack(null)
                .commit()
    }
}


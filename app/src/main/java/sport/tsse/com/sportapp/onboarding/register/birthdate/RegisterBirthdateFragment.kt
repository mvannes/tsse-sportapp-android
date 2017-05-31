package sport.tsse.com.sportapp.onboarding.register.birthdate

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
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

        val now = System.currentTimeMillis() - 1000
        birthdateDatePicker.maxDate = now

        fab.setOnClickListener {
            presenter = RegisterBirthdatePresenter(
                    this,
                    arguments?.getSerializable(ARG_USER) as User,
                    getDateFromDatePicker(birthdateDatePicker))
            presenter.start()
        }
    }

    private fun getDateFromDatePicker(datePicker: DatePicker): java.util.Date {
        val day = datePicker.dayOfMonth
        val month = datePicker.month
        val year = datePicker.year

        val calendar = Calendar.getInstance()
        calendar.set(year, month, day)

        return calendar.time
    }

    override fun gotoRegisterPasswordFragment(user: User) {
        fragmentManager.beginTransaction()
                .setCustomAnimations(
                        R.anim.enter_from_right_onboarding,
                        R.anim.exit_to_left_onboarding,
                        R.anim.enter_from_left_onboarding,
                        R.anim.exit_to_right_onboarding
                ).replace(R.id.fragmentContainer, RegisterPasswordFragment().newInstance(user))
                .addToBackStack(null)
                .commit()
    }
}
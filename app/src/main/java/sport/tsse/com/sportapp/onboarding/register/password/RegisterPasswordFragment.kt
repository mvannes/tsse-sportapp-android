package sport.tsse.com.sportapp.onboarding.register.password

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.onboarding_fab.*
import sport.tsse.com.sportapp.R

/**
 * Created by mohammedali on 09/03/2017.
 */

class RegisterPasswordFragment : Fragment(), RegisterPasswordView {

    lateinit private var presenter: RegisterPasswordPresenter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_onboarding_password_input, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = RegisterPasswordPresenter(this)
        presenter.start()

    }

    override fun finishRegistration() {
        fab.setOnClickListener({ view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        })
    }
}

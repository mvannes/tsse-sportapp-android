package sport.tsse.com.sportapp.onboarding.register

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.onboarding_fab.*
import sport.tsse.com.sportapp.R


/**
 * Created by mohammedali on 09/03/2017.
 */

class RegisterBirthDateFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_onboarding_birth_date_input, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fab.setOnClickListener({
            fragmentManager.beginTransaction()
                    .setCustomAnimations(
                            R.anim.enter_from_right,
                            R.anim.exit_to_left,
                            R.anim.enter_from_left,
                            R.anim.exit_to_right
                    )
                    .replace(R.id.fragmentContainer, RegisterPasswordFragment())
                    .addToBackStack(null)
                    .commit()
        })
    }
}


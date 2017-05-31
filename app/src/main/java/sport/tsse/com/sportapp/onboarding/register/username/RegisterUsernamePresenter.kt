package sport.tsse.com.sportapp.onboarding.register.username

import android.util.Patterns
import sport.tsse.com.sportapp.Presenter
import sport.tsse.com.sportapp.data.User


/**
 * Created by mohammedali on 30/03/2017.
 */
class RegisterUsernamePresenter(private val view: RegisterUsernameView,
                                private val user: User,
                                private val input: String
) : Presenter {

    override fun start() {
        validate(input)
    }

    private fun validate(email: String) {
        if (view.performUsernameCheck(looksLikeValidEmail(email))) {
            user.username = email
            view.goToRegisterNameFragment(user)
        }
    }

    private fun looksLikeValidEmail(arg: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(arg).matches()
    }
}
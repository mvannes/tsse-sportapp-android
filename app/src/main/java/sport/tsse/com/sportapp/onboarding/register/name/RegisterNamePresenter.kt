package sport.tsse.com.sportapp.onboarding.register.name

import sport.tsse.com.sportapp.Presenter
import sport.tsse.com.sportapp.data.User


/**
 * Created by mohammedali on 30/03/2017.
 */
class RegisterNamePresenter(private val view: RegisterNameView,
                            private val user: User,
                            private val firstName: String,
                            private val lastName: String
) : Presenter {

    override fun start() {
        validate()
    }

    private fun validate() {
        if (view.performFirstNameCheck(allowSubmission(firstName)) && view.performLastNameCheck(allowSubmission(lastName))) {
            user.firstName = firstName
            user.lastName = lastName
            view.goToRegisterBirthdateFragment(user)
        }
    }

    private fun allowSubmission(name: String): Boolean {
        return name.isNotEmpty()
    }
}
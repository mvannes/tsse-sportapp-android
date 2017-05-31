package sport.tsse.com.sportapp.onboarding.register.birthdate

import sport.tsse.com.sportapp.Presenter
import sport.tsse.com.sportapp.data.User


/**
 * Created by mohammedali on 30/03/2017.
 */
class RegisterBirthdatePresenter(private val view: RegisterBirthdateView,
                                 private val user: User,
                                 private val birthdate: java.util.Date
) : Presenter {

    override fun start() {
        user.birthdate = birthdate.time
        user.displayName = user.firstName
        view.gotoRegisterPasswordFragment(user)
    }
}
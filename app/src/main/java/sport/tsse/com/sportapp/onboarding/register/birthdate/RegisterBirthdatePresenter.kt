package sport.tsse.com.sportapp.onboarding.register.birthdate

import sport.tsse.com.sportapp.Presenter
import sport.tsse.com.sportapp.data.User
import java.util.*


/**
 * Created by mohammedali on 30/03/2017.
 */
class RegisterBirthdatePresenter(private val view: RegisterBirthdateView,
                                 private val user: User,
                                 private val calendar: Calendar
) : Presenter {

    override fun start() {
        user.birthdate = calendar.time
        view.gotoRegisterPasswordFragment(user)
    }
}
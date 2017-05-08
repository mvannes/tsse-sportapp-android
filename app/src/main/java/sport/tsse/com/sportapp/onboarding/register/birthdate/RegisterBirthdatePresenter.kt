package sport.tsse.com.sportapp.onboarding.register.birthdate

import sport.tsse.com.sportapp.Presenter


/**
 * Created by mohammedali on 30/03/2017.
 */
class RegisterBirthdatePresenter(private val registerBirthdateView: RegisterBirthdateView) : Presenter {

    override fun start() {
        registerBirthdateView.gotoRegisterPasswordFragment()
    }
}
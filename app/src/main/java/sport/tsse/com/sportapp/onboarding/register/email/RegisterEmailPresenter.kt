package sport.tsse.com.sportapp.onboarding.register.email

import sport.tsse.com.sportapp.Presenter


/**
 * Created by mohammedali on 30/03/2017.
 */
class RegisterEmailPresenter(private val registerEmailView: RegisterEmailView) : Presenter {

    override fun start() {
        registerEmailView.goToRegisterNameFragment()
    }
}
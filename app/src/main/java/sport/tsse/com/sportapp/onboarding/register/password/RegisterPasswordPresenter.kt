package sport.tsse.com.sportapp.onboarding.register.password

import sport.tsse.com.sportapp.Presenter


/**
 * Created by mohammedali on 30/03/2017.
 */
class RegisterPasswordPresenter(private val registerPasswordView: RegisterPasswordView) : Presenter {

    override fun start() {
        registerPasswordView.finishRegistration()
    }

}
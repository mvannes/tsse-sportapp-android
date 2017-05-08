package sport.tsse.com.sportapp.onboarding.register.name

import sport.tsse.com.sportapp.Presenter


/**
 * Created by mohammedali on 30/03/2017.
 */
class RegisterNamePresenter(private val registerNameView: RegisterNameView) : Presenter {

    override fun start() {

        registerNameView.goToRegisterBirthdateFragment()
    }

}
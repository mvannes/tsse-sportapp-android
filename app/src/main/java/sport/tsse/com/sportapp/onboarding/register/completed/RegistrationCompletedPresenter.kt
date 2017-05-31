package sport.tsse.com.sportapp.onboarding.register.completed

import sport.tsse.com.sportapp.base.BasePresenter


/**
 * Created by mohammedali on 30/03/2017.
 */
class RegistrationCompletedPresenter(private val view: RegistrationCompletedView) : BasePresenter {

    override fun start() {
        view.goToHome()
    }

}
package sport.tsse.com.sportapp.onboarding.register.completed

import sport.tsse.com.sportapp.Presenter


/**
 * Created by mohammedali on 30/03/2017.
 */
class RegistrationCompletedPresenter(private val view: RegistrationCompletedView) : Presenter {

    override fun start() {
        view.goToHome()
    }

}
package sport.tsse.com.sportapp.onboarding.register.username

import sport.tsse.com.sportapp.Presenter


/**
 * Created by mohammedali on 30/03/2017.
 */
class RegisterUsernamePresenter(private val registerUsernameView: RegisterUsernameView) : Presenter {

    override fun start() {
        registerUsernameView.goToRegisterNameFragment()
        registerUsernameView.setUsernameOnTextChanged()
    }
}
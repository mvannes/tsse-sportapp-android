package sport.tsse.com.sportapp.onboarding.register.birthdate


/**
 * Created by mohammedali on 30/03/2017.
 */
class RegisterBirthdatePresenter(private val registerBirthdateView: RegisterBirthdateContract.View): RegisterBirthdateContract.Presenter {

    init {
        registerBirthdateView.setPresenter(this)
    }
    override fun start() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
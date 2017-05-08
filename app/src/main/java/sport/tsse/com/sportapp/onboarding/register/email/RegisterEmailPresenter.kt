package sport.tsse.com.sportapp.onboarding.register.email


/**
 * Created by mohammedali on 30/03/2017.
 */
class RegisterEmailPresenter(private val registerEmailView: RegisterEmailContract.View): RegisterEmailContract.Presenter {

    init {
        registerEmailView.setPresenter(this)
    }

    override fun start() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
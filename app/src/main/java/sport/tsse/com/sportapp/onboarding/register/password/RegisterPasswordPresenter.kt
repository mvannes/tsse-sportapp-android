package sport.tsse.com.sportapp.onboarding.register.password


/**
 * Created by mohammedali on 30/03/2017.
 */
class RegisterPasswordPresenter(private val registerPasswordView: RegisterPasswordContract.View) : RegisterPasswordContract.Presenter {

    init {
        registerPasswordView.setPresenter(this)
    }

    override fun start() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
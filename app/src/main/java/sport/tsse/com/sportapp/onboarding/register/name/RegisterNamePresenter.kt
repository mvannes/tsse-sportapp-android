package sport.tsse.com.sportapp.onboarding.register.name


/**
 * Created by mohammedali on 30/03/2017.
 */
class RegisterNamePresenter(private val registerNameView: RegisterNameContract.View): RegisterNameContract.Presenter {

    init {
        registerNameView.setPresenter(this)
    }
    override fun start() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
package sport.tsse.com.sportapp.onboarding.register

interface BaseView<in T : BasePresenter> {

    fun setPresenter(presenter: T)
}
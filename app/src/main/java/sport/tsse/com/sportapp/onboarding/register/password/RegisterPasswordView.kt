package sport.tsse.com.sportapp.onboarding.register.password


/**
 * Created by mohammedali on 30/03/2017.
 */
interface RegisterPasswordView {

    fun goToRegistrationCompletedFragment()

    fun performPasswordCheck(valid: Boolean): Boolean

    fun showProgress()

    fun hideProgress()

    fun showError(errorMessage: String)
}
package sport.tsse.com.sportapp.onboarding.register.password

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sport.tsse.com.sportapp.base.BasePresenter
import sport.tsse.com.sportapp.data.User
import sport.tsse.com.sportapp.network.Api
import java.util.regex.Pattern


/**
 * Created by mohammedali on 30/03/2017.
 */
class RegisterPasswordPresenter(private val view: RegisterPasswordView,
                                private val api: Api,
                                private val user: User,
                                private val password: String
) : BasePresenter, Callback<User> {

    override fun start() {
        validate()
    }

    private fun validate() {
        if (view.performPasswordCheck(allowSubmission(password))) {
            view.showProgress()
            user.password = password
            api.service.saveUser(user).enqueue(this)
        }
    }

    private fun allowSubmission(password: String): Boolean {
        return strongPassword(password)
    }

    fun strongPassword(pass: String): Boolean {
        val expression = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})"
        val pattern = Pattern.compile(expression)
        val m = pattern.matcher(pass)
        if (m.find())
            return true
        return false
    }

    override fun onResponse(call: Call<User>?, response: Response<User>?) {
        if (response?.isSuccessful!!) {
            view.hideProgress()
            view.goToRegistrationCompletedFragment()
        } else {
            view.hideProgress()
            view.showError(response.message().plus("Your email address is already being used!"))
        }
    }

    override fun onFailure(call: Call<User>?, t: Throwable?) {
        view.hideProgress()
        view.showError(t?.message!!)
    }
}
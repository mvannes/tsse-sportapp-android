package sport.tsse.com.sportapp.onboarding.register.password

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sport.tsse.com.sportapp.Presenter
import sport.tsse.com.sportapp.data.User
import sport.tsse.com.sportapp.network.Api


/**
 * Created by mohammedali on 30/03/2017.
 */
class RegisterPasswordPresenter(private val view: RegisterPasswordView,
                                private val api: Api,
                                private val user: User,
                                private val password: String
) : Presenter, Callback<User> {

    override fun start() {
        validate()
    }

    private fun validate() {
        if (view.performPasswordCheck(allowSubmission(password))) {
            user.password = password
            view.showProgress()
            api.service.saveUser(user).enqueue(this)
        }
    }

    private fun allowSubmission(password: String): Boolean {
        return password.length > 7
    }

    private fun onSuccess() {
        view.hideProgress()
        view.goToRegistrationCompletedFragment()
    }

    override fun onResponse(call: Call<User>?, response: Response<User>?) {
        if (response?.isSuccessful!!) {
            onSuccess()
        }
    }

    override fun onFailure(call: Call<User>?, t: Throwable?) {
        onFailure(t!!)
    }

    private fun onFailure(t: Throwable) {
        view.hideProgress()
        view.showError(t.message!!)
    }

}
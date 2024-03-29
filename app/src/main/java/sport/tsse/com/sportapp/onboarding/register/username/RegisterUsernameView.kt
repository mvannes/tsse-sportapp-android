package sport.tsse.com.sportapp.onboarding.register.username

import sport.tsse.com.sportapp.data.User


/**
 * Created by mohammedali on 30/03/2017.
 */
interface RegisterUsernameView {

    fun performUsernameCheck(valid: Boolean): Boolean

    fun goToRegisterNameFragment(user: User)
}
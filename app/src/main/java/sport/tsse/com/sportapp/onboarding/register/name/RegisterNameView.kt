package sport.tsse.com.sportapp.onboarding.register.name

import sport.tsse.com.sportapp.data.User


/**
 * Created by mohammedali on 30/03/2017.
 */
interface RegisterNameView {

    fun performFirstNameCheck(validate: Boolean): Boolean

    fun performLastNameCheck(validate: Boolean): Boolean

    fun goToRegisterBirthdateFragment(user: User)
}
package sport.tsse.com.sportapp.onboarding.register

import sport.tsse.com.sportapp.onboarding.register.BasePresenter
import sport.tsse.com.sportapp.onboarding.register.BaseView


/**
 * Created by mohammedali on 30/03/2017.
 */
interface RegisterContract {

    interface View: BaseView<Presenter>

    interface Presenter: BasePresenter
}
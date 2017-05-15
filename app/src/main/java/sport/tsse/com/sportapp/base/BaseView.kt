package sport.tsse.com.sportapp.base

/**
 * Created by Michael on 30/03/2017.
 */
interface BaseView {

    fun showProgress()

    fun hideProgress()

    fun showError(errorMessage: String)
}
package sport.tsse.com.sportapp.base

/**
 * Created by Michael on 30/03/2017.
 */
interface BaseView<in T> {

    fun showProgress()

    fun hideProgress()

    fun showError(errorMessage: String)

    fun populateView(items: List<T>)
}
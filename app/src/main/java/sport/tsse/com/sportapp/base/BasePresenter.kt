package sport.tsse.com.sportapp.base

import sport.tsse.com.sportapp.data.Exercise

/**
 * Created by Michael on 30/03/2017.
 */
interface BasePresenter<T> {

    fun start()

    fun onSuccess(items: List<T>)

    fun onFailure(t: Throwable)

}
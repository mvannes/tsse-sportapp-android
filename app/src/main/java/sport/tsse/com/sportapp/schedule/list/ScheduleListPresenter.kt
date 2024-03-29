package sport.tsse.com.sportapp.schedule.list

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sport.tsse.com.sportapp.base.BasePresenter
import sport.tsse.com.sportapp.data.Schedule
import sport.tsse.com.sportapp.network.Api
import java.util.*

/**
 * BasePresenter for ScheduleList view.
 *
 * Created by Michael on 30/03/2017.
 */
class ScheduleListPresenter(private val view: ScheduleListView, private val api: Api):
        BasePresenter, Callback<List<Schedule>> {
    override fun start() {
        view.populateView(emptyList())
        view.showProgress()
        api.service.getAllSchedules().enqueue(this)
    }

    override fun onResponse(call: Call<List<Schedule>>?, response: Response<List<Schedule>>?) {
        if (response!!.isSuccessful) {
            val schedules = response.body()
            view.populateView(schedules)
            view.hideProgress()
        }
    }

    override fun onFailure(call: Call<List<Schedule>>?, t: Throwable?) {
        view.hideProgress()
        view.showError(t?.message!!)
    }
}
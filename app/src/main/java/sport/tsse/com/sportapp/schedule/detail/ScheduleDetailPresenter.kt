package sport.tsse.com.sportapp.schedule.detail

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sport.tsse.com.sportapp.base.BasePresenter
import sport.tsse.com.sportapp.data.Schedule
import sport.tsse.com.sportapp.network.Api

/**
 * Created by Michael on 15/05/2017.
 */
class ScheduleDetailPresenter(
    private val view: ScheduleDetailView,
    private val api: Api,
    private val scheduleId: Long
): BasePresenter, Callback<Schedule> {

    override fun start() {
        view.showProgress()
        api.service.getSchedule(scheduleId).enqueue(this)
    }

    override fun onFailure(call: Call<Schedule>?, t: Throwable?) {
        view.hideProgress()
        view.showError(t?.message!!)
    }

    override fun onResponse(call: Call<Schedule>?, response: Response<Schedule>?) {
        if (response!!.isSuccessful) {
            val schedule: Schedule = response.body()
            view.populateView(schedule)
            view.hideProgress()
        }
    }
}
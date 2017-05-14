package sport.tsse.com.sportapp.schedule.list

import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sport.tsse.com.sportapp.base.BasePresenter
import sport.tsse.com.sportapp.data.Schedule
import sport.tsse.com.sportapp.network.Api

/**
 * BasePresenter for ScheduleList view.
 *
 * Created by Michael on 30/03/2017.
 */
class ScheduleListPresenter(private val view: ScheduleListView, private val api: Api):
        BasePresenter<Schedule>, Callback<List<Schedule>> {

    override fun onSuccess(items: List<Schedule>) {
        view.populateView(items)    }

    override fun onFailure(t: Throwable) {
        Toast.makeText(view.getContext(), t.message, Toast.LENGTH_LONG).show()
    }

    override fun start() {
        view.populateView(emptyList())
        api.service.getAllSchedules().enqueue(this)
    }

    override fun onResponse(call: Call<List<Schedule>>?, response: Response<List<Schedule>>?) {
        if (response!!.isSuccessful) {
            onSuccess(response.body())
        }
    }

    override fun onFailure(call: Call<List<Schedule>>?, t: Throwable?) {
        onFailure(t!!)
    }
}
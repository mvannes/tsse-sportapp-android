package sport.tsse.com.sportapp.schedule.list

import android.content.Context
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sport.tsse.com.sportapp.PresenterInterface
import sport.tsse.com.sportapp.data.Schedule
import sport.tsse.com.sportapp.network.Api

/**
 * Presenter for ScheduleList view.
 *
 * Created by Michael on 30/03/2017.
 */
class ScheduleListPresenter(private val view: ScheduleListViewInterface):
        PresenterInterface, Callback<List<Schedule>> {
    val api: Api                  = Api()
    init {
        view.setPresenter(this)
    }

    override fun start() {
        view.populateView(emptyList())
        api.service.getAllSchedules().enqueue(this)
    }

    override fun onResponse(call: Call<List<Schedule>>?, response: Response<List<Schedule>>?) {
        if (response!!.isSuccessful) {
            Toast.makeText(view.getContext(), "het werkt", Toast.LENGTH_LONG).show()
            var schedules = response.body()
            view.populateView(schedules)
        }
    }

    override fun onFailure(call: Call<List<Schedule>>?, t: Throwable?) {
        Toast.makeText(view.getContext(), t?.message, Toast.LENGTH_LONG).show()
    }
}
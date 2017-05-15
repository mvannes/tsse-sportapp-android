package sport.tsse.com.sportapp.schedule.list

import android.content.Intent
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sport.tsse.com.sportapp.Presenter
import sport.tsse.com.sportapp.PresenterView
import sport.tsse.com.sportapp.data.Schedule
import sport.tsse.com.sportapp.network.Api
import sport.tsse.com.sportapp.schedule.add.ScheduleCreationActivity
import sport.tsse.com.sportapp.schedule.add.ScheduleCreationView

/**
 * Presenter for ScheduleList view.
 *
 * Created by Michael on 30/03/2017.
 */
class ScheduleCreationPresenter(private val view: ScheduleCreationView, private val api: Api):
        Presenter, Callback<Schedule> {
    override fun start() {
    }

    public fun saveSchedule(schedule: Schedule) {
        api.service.saveSchedule().enqueue(this)
    }

    override fun onResponse(call: Call<Schedule>?, response: Response<Schedule>?) {
        if (response!!.isSuccessful) {
            var schedule: Schedule = response.body()
            var intent: Intent = Intent(view.getContext(), ScheduleCreationActivity::class.java)
            view.passIntent(intent) // Changeup target class

        }
    }

    override fun onFailure(call: Call<Schedule>?, t: Throwable?) {
        Toast.makeText(view.getContext(), t?.message, Toast.LENGTH_LONG).show()
    }
}
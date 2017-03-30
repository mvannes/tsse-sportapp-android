package sport.tsse.com.sportapp.schedule.list

import android.support.design.R
import android.util.Log
import sport.tsse.com.sportapp.PresenterInterface
import sport.tsse.com.sportapp.ViewInterface
import sport.tsse.com.sportapp.data.PersonalSchedule
import sport.tsse.com.sportapp.data.Schedule
import java.util.*

/**
 * Created by Michael on 30/03/2017.
 */
class ScheduleListPresenter(private val view: ViewInterface): PresenterInterface {
    init {
        view.setPresenter(this)
    }

    override fun start() {
        //retrofit
        loadSchedules()
    }

    private fun loadSchedules()
    {
        var schedule: Schedule = Schedule(1, "try", "describe", emptyList(), 5)
        var schedules: List<PersonalSchedule> = listOf(PersonalSchedule(1, schedule, Date(), Date(2017, Calendar.JANUARY, 1)),PersonalSchedule(2, schedule, Date(), Date()))
        // Something retrofit.
        view.populateView(schedules) // Resolve this by extending the generic viewinterface.
    }
}
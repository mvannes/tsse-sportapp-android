package sport.tsse.com.sportapp.schedule.list

import sport.tsse.com.sportapp.PresenterInterface
import sport.tsse.com.sportapp.data.PersonalSchedule
import sport.tsse.com.sportapp.data.Schedule
import java.util.*

/**
 * Created by Michael on 30/03/2017.
 */
class ScheduleListPresenter(private val view: ScheduleListViewInterface): PresenterInterface {
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
        var schedules: List<Schedule> = listOf(
            schedule,
            schedule
        )
        // Something retrofit.
        view.populateView(schedules)
    }
}
package sport.tsse.com.sportapp.schedule.list

import android.content.Context
import sport.tsse.com.sportapp.PresenterView
import sport.tsse.com.sportapp.data.Schedule

/**
 * Created by Michael on 06/04/2017.
 */
interface ScheduleListView : PresenterView {
    fun populateView(schedules: List<Schedule>)

    fun getContext(): Context
}
package sport.tsse.com.sportapp.schedule.list

import android.content.Context
import sport.tsse.com.sportapp.ViewInterface
import sport.tsse.com.sportapp.data.Schedule

/**
 * Created by Michael on 06/04/2017.
 */
interface ScheduleListViewInterface: ViewInterface {
    fun populateView(schedules: List<Schedule>);

    fun getContext(): Context;
}
package sport.tsse.com.sportapp.schedule.detail

import sport.tsse.com.sportapp.base.BaseView
import sport.tsse.com.sportapp.data.Schedule

/**
 * Created by Michael on 15/05/2017.
 */
interface ScheduleDetailView: BaseView {
    fun populateView(schedule: Schedule)
}

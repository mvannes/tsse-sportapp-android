package sport.tsse.com.sportapp.schedule.list

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item_schedule.view.*
import sport.tsse.com.sportapp.R
import sport.tsse.com.sportapp.data.PersonalSchedule
import sport.tsse.com.sportapp.data.Schedule
import sport.tsse.com.sportapp.schedule.list.ScheduleAdapter.ScheduleViewHolder
import java.text.DateFormat
import java.util.*

/**
 * tsse-sportapp-android
 *
 * @author Michael van Nes
 */
class ScheduleAdapter(val schedules: List<PersonalSchedule>,
                      val listener: (PersonalSchedule) -> Unit) : RecyclerView.Adapter<ScheduleViewHolder>() {

    override fun onBindViewHolder(holder: ScheduleViewHolder?, position: Int) {
        holder?.bind(schedules[position], listener)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ScheduleViewHolder {
        return ScheduleViewHolder(LayoutInflater.from(parent?.context)
                .inflate(R.layout.list_item_schedule, parent, false))
    }

    override fun getItemCount() = schedules.size

    class ScheduleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(schedule: PersonalSchedule, listener: (PersonalSchedule) -> Unit) = with(itemView) {
            val formatter: DateFormat = DateFormat.getDateInstance()

            scheduleNameTextView.text = schedule.schedule.name
            startDateTextView.text    = formatter.format(schedule.startDate)
            endDateTextView.text      = formatter.format(schedule.endDate)
            // If our schedule's end date in the past, it is old and must be displayed as such.
            if (schedule.endDate.before(Date())) {
                itemView.setBackgroundColor(R.color.grey)
                itemView.alpha = 25F
            }
            setOnClickListener { listener(schedule) }
        }
    }
}
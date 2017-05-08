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
 * Adapter for showing a list of Schedules.
 *
 * @author Michael van Nes
 */
class ScheduleAdapter(val schedules: List<Schedule>,
                      val listener: (Schedule) -> Unit) : RecyclerView.Adapter<ScheduleViewHolder>() {

    override fun onBindViewHolder(holder: ScheduleViewHolder?, position: Int) {
        holder?.bind(schedules[position], listener)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ScheduleViewHolder {
        return ScheduleViewHolder(LayoutInflater.from(parent?.context)
                .inflate(R.layout.list_item_schedule, parent, false))
    }

    override fun getItemCount() = schedules.size

    class ScheduleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(schedule: Schedule, listener: (Schedule) -> Unit) = with(itemView) {
            val formatter: DateFormat = DateFormat.getDateInstance()

            scheduleNameTextView.text = schedule.name
            startDateTextView.text    = formatter.format(Date()) // Give a Schedule a start date.
            endDateTextView.text      = formatter.format(Date()) // Give a Schedule an end date
            // If our schedule's end date in the past, it is old and must be displayed as such.
            if (false) { // This will be usefull once we move to using Personal schedules.
                 itemView.setBackgroundColor(R.color.grey)
                 itemView.alpha = 25F
            }
            setOnClickListener { listener(schedule) }
        }
    }
}
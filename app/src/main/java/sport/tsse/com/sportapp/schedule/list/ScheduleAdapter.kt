package sport.tsse.com.sportapp.schedule.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item_schedule.view.*
import sport.tsse.com.sportapp.R
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
            scheduleNameTextView.text = schedule.name
            setOnClickListener { listener(schedule) }
        }
    }
}
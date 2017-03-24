package sport.tsse.com.sportapp.schedule.list

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_schedule_list.*
import sport.tsse.com.sportapp.R
import sport.tsse.com.sportapp.schedule.add.ScheduleCreationActivity

/**
 * tsse-sportapp-android
 *
 * @author Mitchell de Vries
 */
class ScheduleListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_schedule_list, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fabAddSchedule.setOnClickListener {
            startActivity(Intent(context, ScheduleCreationActivity::class.java))
        }
    }
}
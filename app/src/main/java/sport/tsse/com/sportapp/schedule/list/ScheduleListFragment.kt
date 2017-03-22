package sport.tsse.com.sportapp.schedule.list

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import sport.tsse.com.sportapp.R

/**
 * tsse-sportapp-android
 *
 * @author Mitchell de Vries
 */
class ScheduleListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_schedule_list, container, false)
    }
}
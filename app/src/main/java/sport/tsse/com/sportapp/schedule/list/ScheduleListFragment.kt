package sport.tsse.com.sportapp.schedule.list

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_schedule_list.*
import sport.tsse.com.sportapp.PresenterInterface
import sport.tsse.com.sportapp.R
import sport.tsse.com.sportapp.ViewInterface
import sport.tsse.com.sportapp.data.PersonalSchedule
import sport.tsse.com.sportapp.data.Schedule
import sport.tsse.com.sportapp.home.HomeFragment
import sport.tsse.com.sportapp.schedule.add.ScheduleCreationActivity

/**
 * tsse-sportapp-android
 *
 * @author Mitchell de Vries
 */
class ScheduleListFragment : Fragment(), ScheduleListViewInterface {
    lateinit private var presenter: PresenterInterface

    override fun setPresenter(presenter: PresenterInterface) {
        this.presenter = presenter
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_schedule_list, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        fabAddSchedule.setOnClickListener {
            startActivity(Intent(context, ScheduleCreationActivity::class.java))
        }
        presenter.start()

        scheduleList.layoutManager = LinearLayoutManager(context)
    }

    override fun onResume() {
        super.onResume()
        presenter.start()
    }

     override fun populateView(schedules: List<Schedule>){
        scheduleList.adapter = ScheduleAdapter(schedules) {
            startActivity(Intent(context, HomeFragment::class.java))
        }
    }
}
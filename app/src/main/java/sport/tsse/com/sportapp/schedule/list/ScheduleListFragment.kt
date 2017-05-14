package sport.tsse.com.sportapp.schedule.list

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_schedule_list.*
import sport.tsse.com.sportapp.R
import sport.tsse.com.sportapp.data.Schedule
import sport.tsse.com.sportapp.home.HomeFragment
import sport.tsse.com.sportapp.network.Api
import sport.tsse.com.sportapp.schedule.add.ScheduleCreationActivity

/**
 * tsse-sportapp-android
 *
 * @author Mitchell de Vries
 */
class ScheduleListFragment : Fragment(), ScheduleListView {
    override fun showProgress() {
        TODO("not implemented")
    }

    override fun hideProgress() {
        TODO("not implemented")
    }

    override fun showError(errorMessage: String) {
        TODO("not implemented")
    }

    private lateinit var presenter: ScheduleListPresenter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_schedule_list, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        fabAddSchedule.setOnClickListener {
            startActivity(Intent(context, ScheduleCreationActivity::class.java))
        }
        presenter = ScheduleListPresenter(this, Api());
        presenter.start()

        scheduleList.layoutManager = LinearLayoutManager(context)
    }

    override fun onResume() {
        super.onResume()
        presenter.start()
    }

     override fun populateView(items: List<Schedule>){
        scheduleList.adapter = ScheduleAdapter(items) {
            startActivity(Intent(context, HomeFragment::class.java))
        }
    }
}
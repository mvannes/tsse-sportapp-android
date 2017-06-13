package sport.tsse.com.sportapp.schedule.list

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_schedule_list.*
import sport.tsse.com.sportapp.R
import sport.tsse.com.sportapp.data.Schedule
import sport.tsse.com.sportapp.network.Api
import sport.tsse.com.sportapp.schedule.add.ScheduleCreationActivity
import sport.tsse.com.sportapp.schedule.detail.ScheduleDetailActivity

/**
 * tsse-sportapp-android
 *
 * @author Mitchell de Vries
 */
class ScheduleListFragment : Fragment(), ScheduleListView {

    private lateinit var presenter: ScheduleListPresenter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_schedule_list, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
//        fabAddSchedule.setOnClickListener {
//            startActivity(Intent(context, ScheduleCreationActivity::class.java))
//        }
        scheduleList.layoutManager = LinearLayoutManager(context)
        presenter                  = ScheduleListPresenter(this, Api());
        presenter.start()
    }

     override fun populateView(schedules: List<Schedule>) {
        scheduleList.adapter = ScheduleAdapter(schedules) {
            s ->
            startActivity(ScheduleDetailActivity.newIntent(context, s.id))
        }
    }

    override fun showProgress() {
        if (isAdded) {
            scheduleListProgress.visibility = View.VISIBLE
            scheduleList.visibility = View.GONE
        }
    }

    override fun hideProgress() {
        if (isAdded) {
            scheduleListProgress.visibility = View.GONE
            scheduleList.visibility = View.VISIBLE
        }
    }

    override fun showError(errorMessage: String) {
        if (isAdded) {
            AlertDialog.Builder(context)
                .setTitle("Error")
                .setMessage(errorMessage)
                .setPositiveButton(android.R.string.ok, null)
                .create()
                .show()
        }
    }
}

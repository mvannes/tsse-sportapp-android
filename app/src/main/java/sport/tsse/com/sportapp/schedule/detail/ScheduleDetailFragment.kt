package sport.tsse.com.sportapp.schedule.detail

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_schedule_detail.*
import sport.tsse.com.sportapp.R
import sport.tsse.com.sportapp.data.Schedule
import sport.tsse.com.sportapp.network.Api

/**
 * Created by Michael on 15/05/2017.
 */
class ScheduleDetailFragment(val scheduleId: Long): Fragment(), ScheduleDetailView {

    private lateinit var presenter: ScheduleDetailPresenter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_schedule_detail, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        presenter = ScheduleDetailPresenter(this, Api(), scheduleId)
        presenter.start()
    }

    override fun showProgress() {
        if (isAdded) {
            scheduleDetailProgress.visibility = View.VISIBLE
            scheduleDetailInformation.visibility = View.GONE
        }
    }

    override fun hideProgress() {
        if (isAdded) {
            scheduleDetailProgress.visibility = View.GONE
            scheduleDetailInformation.visibility = View.VISIBLE
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

    override fun populateView(schedule: Schedule) {
        scheduleNameTextView.text = schedule.name
    }

}
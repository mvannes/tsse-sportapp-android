package sport.tsse.com.sportapp.schedule.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import sport.tsse.com.sportapp.R
import sport.tsse.com.sportapp.base.SingleFragmentActivity

class ScheduleDetailActivity : SingleFragmentActivity() {

    override fun createFragment(): Fragment {
        val scheduleId = intent.getLongExtra(EXTRA_SCHEDULE_ID, -1)

        return ScheduleDetailFragment.newInstance(scheduleId)
    }

    override fun setToolbarTitle(): String {
        return getString(R.string.title_schedule_details)
    }

    companion object {
        private val EXTRA_SCHEDULE_ID = "sport.tsse.com.sportapp.schedule.detail.schedule_id"

        fun newIntent(packageContext: Context, scheduleId: Long): Intent {
            val intent = Intent(packageContext, ScheduleDetailActivity::class.java)
            intent.putExtra(EXTRA_SCHEDULE_ID, scheduleId)
            return intent
        }
    }
}

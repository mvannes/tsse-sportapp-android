package sport.tsse.com.sportapp.schedule.detail

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import sport.tsse.com.sportapp.R

class ScheduleDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        Log.d("WTF?", intent.extras.toString())
        val scheduleId: Long = intent.getLongExtra("scheduleId", -1)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, ScheduleDetailFragment(scheduleId))
            .commit()
    }
}

package sport.tsse.com.sportapp.schedule.add

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import sport.tsse.com.sportapp.R

/**
 * tsse-sportapp-android
 *
 * @author Mitchell de Vries
 */
class ScheduleCreationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, ScheduleCreationFragment())
                .commit()
    }
}
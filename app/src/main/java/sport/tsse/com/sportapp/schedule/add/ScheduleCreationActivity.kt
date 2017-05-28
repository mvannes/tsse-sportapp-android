package sport.tsse.com.sportapp.schedule.add

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.fragment_schedule_add.*
import sport.tsse.com.sportapp.R
import sport.tsse.com.sportapp.workout.add.AddWorkoutActivity

/**
 * tsse-sportapp-android
 *
 * @author Mitchell de Vries
 */
class ScheduleCreationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_schedule_add)

        addWorkoutButton.setOnClickListener {
            startActivity(Intent(this, AddWorkoutActivity::class.java))
        }
    }
}
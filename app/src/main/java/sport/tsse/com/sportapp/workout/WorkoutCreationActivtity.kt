package sport.tsse.com.sportapp.workout

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import sport.tsse.com.sportapp.R

/**
 * tsse-sportapp-android
 *
 * @author Mitchell de Vries
 */
class WorkoutCreationActivtity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_add_workout)
    }
}
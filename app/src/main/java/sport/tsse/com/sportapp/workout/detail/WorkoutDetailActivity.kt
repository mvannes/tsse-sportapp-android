package sport.tsse.com.sportapp.workout.detail

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import sport.tsse.com.sportapp.R
import sport.tsse.com.sportapp.base.SingleFragmentActivity

/**
 * Created by mitchelldevries on 18/05/2017.
 */
class WorkoutDetailActivity : SingleFragmentActivity() {

    override fun createFragment(): Fragment {
        val workoutId = intent.getIntExtra(EXTRA_WORKOUT_ID, 0)

        return WorkoutDetailFragment.newInstance(workoutId)
    }

    override fun setToolbarTitle(): String {
        return getString(R.string.title_workout_details)
    }

    companion object {
        val EXTRA_WORKOUT_ID = "sport.tsse.com.sportapp.workout.detail.workout_id"

        fun newIntent(packageContext: Context, workoutId: Int): Intent {
            val intent = Intent(packageContext, WorkoutDetailActivity::class.java)
            intent.putExtra(EXTRA_WORKOUT_ID, workoutId)
            return intent
        }
    }
}
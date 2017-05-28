package sport.tsse.com.sportapp.exercise.detail

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import sport.tsse.com.sportapp.R
import sport.tsse.com.sportapp.base.SingleFragmentActivity

class ExerciseDetailActivity : SingleFragmentActivity() {
    override fun createFragment(): Fragment {
        val exerciseId = intent.getIntExtra(EXTRA_EXERCISE_ID, 0)

        return ExerciseDetailFragment.newInstance(exerciseId)
    }

    override fun setToolbarTitle(): String {
        return getString(R.string.title_exercise_details)
    }

    companion object {
        val EXTRA_EXERCISE_ID = "sport.tsse.com.sportapp.exercise.detail.exercise_id"

        fun newIntent(packageContext: Context, exerciseId: Int): Intent {
            val intent = Intent(packageContext, ExerciseDetailActivity::class.java)
            intent.putExtra(EXTRA_EXERCISE_ID, exerciseId)
            return intent
        }
    }
}

package sport.tsse.com.sportapp.workout.add

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import sport.tsse.com.sportapp.R
import sport.tsse.com.sportapp.base.SingleFragmentActivity

/**
 * Created by mitchelldevries on 28/05/2017.
 */
class AddWorkoutActivity : SingleFragmentActivity() {

    companion object {
        fun newIntent(packageContext: Context): Intent {
            return Intent(packageContext, AddWorkoutActivity::class.java)
        }
    }
    override fun createFragment(): Fragment {
        return AddWorkoutFragment()
    }

    override fun setToolbarTitle(): String {
        return getString(R.string.title_add_workout)
    }
}
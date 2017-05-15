package sport.tsse.com.sportapp.schedule.add

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_add_schedule.*
import sport.tsse.com.sportapp.Presenter
import sport.tsse.com.sportapp.R
import sport.tsse.com.sportapp.data.Schedule
import sport.tsse.com.sportapp.home.HomeFragment
import sport.tsse.com.sportapp.network.Api
import sport.tsse.com.sportapp.schedule.list.ScheduleAdapter
import sport.tsse.com.sportapp.schedule.list.ScheduleCreationPresenter
import sport.tsse.com.sportapp.schedule.list.ScheduleListPresenter
import sport.tsse.com.sportapp.workout.WorkoutCreationActivtity

/**
 * Created by Michael on 11/05/2017.
 */
class ScheduleCreationFragment: Fragment(), ScheduleCreationView {
    private lateinit var presenter: ScheduleCreationPresenter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_add_schedule, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        presenter = ScheduleCreationPresenter(this, Api());
        presenter.start()
        addWorkoutButton.setOnClickListener {
            saveSchedule()
        }
    }

    private fun saveSchedule() {
        var schedule: Schedule = Schedule(
            -1, // Why does this need an id?
            nameEditText.text.toString(),
            descriptionEditText.text.toString(),
            emptyList<String>(), // Make this a list of workouts once workout is implemented.
            weeklyTrainingsEditText.text.toString().toInt()
        )
        presenter.saveSchedule(schedule)
    }

    override fun onResume() {
        super.onResume()
        presenter.start()
    }

    override fun passIntent(intent: Intent) {
        startActivity(intent)
    }
}
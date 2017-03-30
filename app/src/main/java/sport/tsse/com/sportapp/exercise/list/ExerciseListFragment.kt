package sport.tsse.com.sportapp.exercise.list

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_exercise_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sport.tsse.com.sportapp.R
import sport.tsse.com.sportapp.data.Exercise
import sport.tsse.com.sportapp.exercise.detail.ExerciseDetailActivity
import sport.tsse.com.sportapp.network.GymApi

/**
 * tsse-sportapp-android
 *
 * @author Mitchell de Vries
 */
class ExerciseListFragment : Fragment(), Callback<List<Exercise>> {

    private var exercises: List<Exercise> = emptyList()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_exercise_list, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val api = GymApi()
        api.service.getAllExercises().enqueue(this)
        updateUi()
    }


    private fun updateUi() {
        if (exercises.isNotEmpty()) {
            exerciseListEmptyTextView.visibility = View.GONE
        } else {
            exerciseListEmptyTextView.visibility = View.VISIBLE
        }

        exerciseListRecyclerView.apply {
            setHasFixedSize(true)
            val linearLayoutManager = LinearLayoutManager(context)
            layoutManager = linearLayoutManager
            adapter = ExerciseAdapter(exercises) {
                startActivity(Intent(context, ExerciseDetailActivity::class.java))
            }
        }
    }

    override fun onResponse(call: Call<List<Exercise>>?, response: Response<List<Exercise>>?) {
        if (response!!.isSuccessful) {
            exercises = response.body()
            updateUi()
            Log.d("onResponse: ", response.raw().toString())
        }
    }

    override fun onFailure(call: Call<List<Exercise>>?, t: Throwable?) {
        Toast.makeText(context, t?.message, Toast.LENGTH_LONG).show()
        Log.e("TAG", "onFailure", t)
    }
}
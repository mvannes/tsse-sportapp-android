package sport.tsse.com.sportapp.schedule.add

import android.content.Context
import android.content.Intent
import sport.tsse.com.sportapp.PresenterView

/**
 * Created by Michael on 11/05/2017.
 */
interface ScheduleCreationView: PresenterView {
    fun getContext(): Context

    fun passIntent(intent: Intent)
}
package sport.tsse.com.sportapp.data

import java.util.*

/**
 * @author Michael van Nes
 */
data class PersonalSchedule(val user: Int, // This is an int while our user class is not implemented
                            val schedule: Schedule,
                            val startDate: Date,
                            val endDate: Date
)

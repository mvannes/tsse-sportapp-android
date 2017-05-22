package sport.tsse.com.sportapp.data

/**
 * @author Michael van Nes
 */
data class Schedule(val id: Long,
                    val name: String,
                    val description: String,
                    val workouts: List<Workout>,
                    val amountOfTrainingsPerWeek: Int
)

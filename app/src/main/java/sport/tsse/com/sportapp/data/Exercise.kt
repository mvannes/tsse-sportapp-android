package sport.tsse.com.sportapp.data

import java.io.Serializable

/**
 * tsse-sportapp-android
 *
 * @author Mitchell de Vries
 */
data class Exercise(val id: Int,
                    val name: String,
                    val description: String,
                    val category: String) : Serializable
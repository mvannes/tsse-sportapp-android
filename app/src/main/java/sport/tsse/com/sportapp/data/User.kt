package sport.tsse.com.sportapp.data

import java.io.Serializable

/**
 * Created by mohammedali on 30/03/2017.
 */
data class User(val user_id: Int = 0,
                var birthdate: Long = 0L,
                var displayName: String = "",
                var enabled: Boolean = false,
                var firstName: String = "",
                var lastName: String = "",
                var password: String = "",
                var status: String = "",
                var username: String = ""

) : Serializable
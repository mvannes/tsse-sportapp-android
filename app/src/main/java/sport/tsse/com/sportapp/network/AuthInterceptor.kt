package sport.tsse.com.sportapp.network

import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Response

/**
 * tsse-sportapp-android
 *
 * @author Mitchell de Vries
 */
class AuthInterceptor(val username: String,
                      val password: String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain?): Response {
        val credentials = Credentials.basic(username, password)
        val request = chain!!.request()

        val authenticationRequest = request
                .newBuilder()
                .header("Authorization", credentials)
                .header("Accept", "application/json")
                .build()

        return chain.proceed(authenticationRequest)

    }

}
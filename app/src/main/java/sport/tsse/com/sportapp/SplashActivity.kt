package sport.tsse.com.sportapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import sport.tsse.com.sportapp.onboarding.startUp.StartupActivity

/**
 * tsse-sportapp-android
 *
 * @author Mitchell de Vries
 */
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Handler().postDelayed({
            startActivity(Intent(this, StartupActivity::class.java))
            finish()
        }, 1800)
    }
}
package sport.tsse.com.sportapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.fragment_get_started.*
import kotlinx.android.synthetic.main.fragment_sign_up.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_sign_up)

        button_log_in.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}

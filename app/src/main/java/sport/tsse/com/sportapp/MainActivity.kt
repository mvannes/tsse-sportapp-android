package sport.tsse.com.sportapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.fragment_get_started.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_get_started)

        login_text_view.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}

package sport.tsse.com.sportapp.onboarding.register

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_onboarding.*
import sport.tsse.com.sportapp.R
import sport.tsse.com.sportapp.onboarding.register.email.RegisterEmailFragment

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)
        initActionBar()

        var fragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)

        if (fragment == null) {
            fragment = createFragment()
            supportFragmentManager.beginTransaction()
                    .add(R.id.fragmentContainer, fragment)
                    .commit()
        }
    }

    private fun createFragment(): Fragment {
        val fragment = RegisterEmailFragment()
        return fragment
    }

    private fun initActionBar() {
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowTitleEnabled(false)

            toolbar?.setNavigationOnClickListener({
                onBackPressed()
            })
        }
    }
}

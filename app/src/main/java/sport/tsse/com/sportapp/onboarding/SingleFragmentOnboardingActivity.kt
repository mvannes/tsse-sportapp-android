package sport.tsse.com.sportapp.onboarding

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import sport.tsse.com.sportapp.R

abstract class SingleFragmentOnboardingActivity : AppCompatActivity() {

    abstract fun createFragment(): Fragment

    abstract fun setToolbar(): Toolbar?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding_fragment)
        initActionBar()

        var fragment = supportFragmentManager.findFragmentById(R.id.fragment_container)

        if (fragment == null) {
            fragment = createFragment()
            supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit()
        }
    }
    
    private fun initActionBar() {
        setSupportActionBar(setToolbar())
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }
}

package sport.tsse.com.sportapp.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_fragment.*
import sport.tsse.com.sportapp.R
import sport.tsse.com.sportapp.data.storage.DbSchema

/**
* tsse-sportapp-android
*
* @author Mitchell de Vries
*/
abstract class SingleFragmentActivity : AppCompatActivity() {

    abstract fun createFragment(): Fragment

    abstract fun setToolbarTitle(): String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        initActionBar()

        var fragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)

        if (fragment == null) {
            fragment = createFragment()
            supportFragmentManager.beginTransaction()
                    .add(R.id.fragmentContainer, fragment)
                    .commit()
        }
    }

    private fun initActionBar() {
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowTitleEnabled(false)

            toolbar.setNavigationOnClickListener({
                onBackPressed()
            })
        }
        titleToolbar.text = setToolbarTitle()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.home) {
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}
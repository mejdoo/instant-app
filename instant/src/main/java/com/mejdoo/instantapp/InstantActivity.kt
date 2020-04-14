package com.mejdoo.instantapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.instantapps.InstantApps
import kotlinx.android.synthetic.main.activity_instant.*

class InstantActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instant)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_instant, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_download -> {
                showInstallPrompt()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showInstallPrompt() {
        val postInstall = Intent(Intent.ACTION_MAIN)
            .addCategory(Intent.CATEGORY_DEFAULT)
            .setPackage(BuildConfig.APPLICATION_ID)

        // The request code is passed to startActivityForResult().
        InstantApps.showInstallPrompt(this, postInstall, REQUEST_CODE, /* referrer= */ null)
    }

    companion object {
        const val REQUEST_CODE = 1
    }
}

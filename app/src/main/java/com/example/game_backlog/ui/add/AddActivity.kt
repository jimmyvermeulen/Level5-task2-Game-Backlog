package com.example.game_backlog.ui.add

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.game_backlog.R
import com.example.game_backlog.model.Game

import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.content_add.*
import java.util.*

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        setSupportActionBar(toolbar)
        initViews()
    }

    private fun initViews() {
        fab.setOnClickListener { onSaveClick() }
    }

    private fun onSaveClick() {

        if(etTitle.text.toString().isNotBlank() &&
            etPlatform.text.toString().isNotBlank() &&
            etDay.text.toString().isNotBlank() &&
            etMonth.text.toString().isNotBlank() &&
            etYear.text.toString().isNotBlank())
        {
            if(etYear.text.toString().toInt() >= 0 &&
                    etMonth.text.toString().toInt() in 1..12 &&
                    etDay.text.toString().toInt() in 1..31) {
                //Add day, month and year to calendar to create a date object
                val calendar = Calendar.getInstance()
                calendar.set(
                    etYear.text.toString().toInt(),
                    etMonth.text.toString().toInt() - 1,
                    etDay.text.toString().toInt()
                )
                val game = Game(etTitle.text.toString(), etPlatform.text.toString(), calendar.time)

                val resultIntent = Intent()
                resultIntent.putExtra(EXTRA_GAME, game)
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            }
            else{
                Toast.makeText(this, getString(R.string.msg_invalid_date), Toast.LENGTH_SHORT).show()
            }
        }
        else {
            Toast.makeText(this, getString(R.string.msg_empty_game), Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        const val EXTRA_GAME = "EXTRA_GAME"
    }

}

package com.example.musicplaylist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.TransitionAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val items = (1..20).map { "item $it" }
    private val adapter = SimpleAdapter(items)
    var rebuilt = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        songList.adapter = adapter
        songList.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        root.setTransitionListener(object : TransitionAdapter() {
            override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
                if (currentId == R.id.middle) {
                    root.postDelayed({
                        root.setTransition(R.id.middleToEnd)
                    }, 500)
                }
            }


        })
    }
}
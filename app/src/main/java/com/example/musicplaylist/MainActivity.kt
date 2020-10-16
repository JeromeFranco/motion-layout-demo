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
    private val items = (1..20).map { "Song $it" }
    private val adapter = SimpleAdapter(items)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        songList.adapter = adapter

        backButton.setOnClickListener {
            root.setTransition(R.id.startToMiddle)
            root.transitionToStart()
        }

        root.setTransitionListener(object : TransitionAdapter() {
            override fun onTransitionStarted(
                motionLayout: MotionLayout?,
                startId: Int,
                endId: Int
            ) {
                if (startId == R.id.start) {
                    window.statusBarColor = resources.getColor(R.color.neutral_000)
                }
            }
            override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
                if (currentId == R.id.middle) {
                    window.statusBarColor = resources.getColor(R.color.yellow)
                    root.postDelayed({
                        root.setTransition(R.id.middleToEnd)
                    }, 500)
                }
            }
        })
    }
}
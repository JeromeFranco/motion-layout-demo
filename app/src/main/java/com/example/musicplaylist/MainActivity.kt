package com.example.musicplaylist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.TransitionAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val items = (1..20).map { "Song $it" }
    private val adapter = SimpleAdapter(items)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        songList.adapter = adapter

        root.setTransitionListener(object : TransitionAdapter() {
            override fun onTransitionStarted(
                motionLayout: MotionLayout?,
                startId: Int,
                endId: Int
            ) {
                if (endId == R.id.start) {
                    window.statusBarColor = resources.getColor(R.color.neutral_000)
                }
            }

            override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
                if (currentId == R.id.middle && motionLayout?.progress == 1f) {
                    window.statusBarColor = resources.getColor(R.color.yellow)
                    // Workaround to fix issue where scrolling the recycle view doesn't trigger the transition
                    root.setTransition(R.id.middleToEnd)
                }
            }
        })
    }
}
/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.android.kharada.kotlinmvpandroidtv.ui.error

import android.view.Gravity
import com.android.kharada.kotlinmvpandroidtv.R

/*
 * BrowseErrorActivity shows how to use ErrorFragment
 */
class BrowseErrorActivity : android.app.Activity() {

    private var mErrorFragment: ErrorFragment? = null
    private var mSpinnerFragment: SpinnerFragment? = null

    /**
     * Called when the activity is first created.
     */
    public override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testError()
    }

    private fun testError() {
        mErrorFragment = ErrorFragment()
        fragmentManager.beginTransaction().add(R.id.main_browse_fragment, mErrorFragment).commit()

        mSpinnerFragment = BrowseErrorActivity.SpinnerFragment()
        fragmentManager.beginTransaction().add(R.id.main_browse_fragment, mSpinnerFragment).commit()

        val handler = android.os.Handler()
        handler.postDelayed({
            fragmentManager.beginTransaction().remove(mSpinnerFragment).commit()
            mErrorFragment!!.setErrorContent()
        }, TIMER_DELAY.toLong())
    }

    class SpinnerFragment : android.app.Fragment() {
        override fun onCreateView(inflater: android.view.LayoutInflater, container: android.view.ViewGroup?,
                                  savedInstanceState: android.os.Bundle): android.view.View? {
            val progressBar = android.widget.ProgressBar(container!!.context)
            if (container is android.widget.FrameLayout) {
                val layoutParams = android.widget.FrameLayout.LayoutParams(SPINNER_WIDTH, SPINNER_HEIGHT, Gravity.CENTER)
                progressBar.layoutParams = layoutParams
            }
            return progressBar
        }
    }

    companion object {
        private val TIMER_DELAY = 3000
        private val SPINNER_WIDTH = 100
        private val SPINNER_HEIGHT = 100
    }
}

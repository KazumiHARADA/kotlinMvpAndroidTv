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

import android.os.Bundle
import android.util.Log
import android.view.View
import com.android.kharada.kotlinmvpandroidtv.R

/*
 * This class demonstrates how to extend ErrorFragment
 */
class ErrorFragment : android.support.v17.leanback.app.ErrorFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate")
        super.onCreate(savedInstanceState)
        title = resources.getString(R.string.app_name)
    }

    internal fun setErrorContent() {
        imageDrawable = resources.getDrawable(R.drawable.lb_ic_sad_cloud)
        message = resources.getString(R.string.error_fragment_message)
        setDefaultBackground(TRANSLUCENT)

        buttonText = resources.getString(R.string.dismiss_error)
        buttonClickListener = View.OnClickListener { fragmentManager.beginTransaction().remove(this@ErrorFragment).commit() }
    }

    companion object {
        private val TAG = "ErrorFragment"
        private val TRANSLUCENT = true
    }
}

package com.lnavmon.practica1.iu.settings

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.lnavmon.practica1.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences_settings, rootKey)
    }
}
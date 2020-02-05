package com.example.containerview

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Person(
    var firstName : String,
    var lastName : String,
    var address : String
    ) : Parcelable
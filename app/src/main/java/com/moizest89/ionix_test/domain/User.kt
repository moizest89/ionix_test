package com.moizest89.ionix_test.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserInformation(
    @SerializedName("email")
    var email: String = "",
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("phone_number")
    var phoneNumber: String = ""
): Parcelable
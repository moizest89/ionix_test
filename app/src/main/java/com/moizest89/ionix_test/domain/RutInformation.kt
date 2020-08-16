package com.moizest89.ionix_test.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class RutInformationResponse(
    @SerializedName("description")
    var description: String? = "",
    @SerializedName("responseCode")
    var responseCode: Int? = 0,
    @SerializedName("result")
    var result: Result? = Result()
) : Parcelable

@Parcelize
data class Result(
    @SerializedName("items")
    var items: List<Item>? = listOf()
): Parcelable

@Parcelize
data class Item(
    @SerializedName("detail")
    var detail: Detail? = Detail(),
    @SerializedName("name")
    var name: String? = ""
): Parcelable

@Parcelize
data class Detail(
    @SerializedName("email")
    var email: String? = "",
    @SerializedName("phone_number")
    var phoneNumber: String? = ""
): Parcelable
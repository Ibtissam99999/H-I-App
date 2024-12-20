package com.example.hi.data

import android.os.Parcel
import android.os.Parcelable

data class ShippedItem(var command: String, var status: String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(command)
        parcel.writeString(status)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<ShippedItem> {
        override fun createFromParcel(parcel: Parcel): ShippedItem {
            return ShippedItem(parcel)
        }

        override fun newArray(size: Int): Array<ShippedItem?> {
            return arrayOfNulls(size)
        }
    }
}

package pl.skipcode.basekotlinapp.utils.tools.parcel

import android.os.Parcelable

interface ParcelableProviderInterface {
    fun from(from: Any): Parcelable
}
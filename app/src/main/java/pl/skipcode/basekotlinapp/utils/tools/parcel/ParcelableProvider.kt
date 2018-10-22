package pl.skipcode.basekotlinapp.utils.tools.parcel

import android.os.Parcelable
import org.parceler.Parcels

class ParcelableProvider : ParcelableProviderInterface {

    override fun from(from: Any): Parcelable =
            Parcels.wrap(from)
}
package com.mahesaiqbal.movie.core.domain.model

import android.os.Parcel
import android.os.Parcelable

data class Movie(
    val id: Int,
    val backdropPath: String,
    val originalLanguage: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val voteAverage: Double,
    val voteCount: Int,
    val isFavorite: Boolean
) : Parcelable {
    constructor(parcel: Parcel) : this(
        id = parcel.readInt(),
        backdropPath = parcel.readString().toString(),
        originalLanguage = parcel.readString().toString(),
        overview = parcel.readString().toString(),
        popularity = parcel.readDouble(),
        posterPath = parcel.readString().toString(),
        releaseDate = parcel.readString().toString(),
        title = parcel.readString().toString(),
        voteAverage = parcel.readDouble(),
        voteCount = parcel.readInt(),
        isFavorite = parcel.readByte() != 0.toByte()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(backdropPath)
        parcel.writeString(originalLanguage)
        parcel.writeString(overview)
        parcel.writeDouble(popularity)
        parcel.writeString(posterPath)
        parcel.writeString(releaseDate)
        parcel.writeString(title)
        parcel.writeDouble(voteAverage)
        parcel.writeInt(voteCount)
        parcel.writeByte(if (isFavorite) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Movie> {
        override fun createFromParcel(parcel: Parcel): Movie {
            return Movie(parcel)
        }

        override fun newArray(size: Int): Array<Movie?> {
            return arrayOfNulls(size)
        }
    }
}
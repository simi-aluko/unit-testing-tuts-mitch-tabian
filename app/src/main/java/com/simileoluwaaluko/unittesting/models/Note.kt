package com.simileoluwaaluko.unittesting.models

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

/**
 * Created by The Awesome Simileoluwa Aluko on 2020-03-30.
 */

@Entity(tableName = "notes")
class Note : Parcelable {

    @PrimaryKey(autoGenerate = true)
    var id = 0

    @NonNull
    @ColumnInfo(name = "title")
    var title: String?

    @ColumnInfo(name = "content")
    var content: String? = null

    @ColumnInfo(name = "timestamp")
    var timestamp: String? = null

    constructor(@NonNull title: String, content: String?, timestamp: String?) {
        this.title = title
        this.content = content
        this.timestamp = timestamp
    }

    @Ignore
    constructor(id: Int,@NonNull title: String, content: String?, timestamp: String?) {
        this.id = id
        this.title = title
        this.content = content
        this.timestamp = timestamp
    }

    @Ignore
    constructor(note: Note) {
        id = note.id
        title = note.title
        content = note.content
        timestamp = note.timestamp
    }

    constructor(`in`: Parcel) {
        id = `in`.readInt()
        title = `in`.readString()!!
        content = `in`.readString()
        timestamp = `in`.readString()
    }

    override fun toString(): String {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}'
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(id)
        dest.writeString(title)
        dest.writeString(content)
        dest.writeString(timestamp)
    }

    override fun equals(other: Any?): Boolean {
        if (other == null) {
            return false
        }
        if (javaClass != other.javaClass) {
            return false
        }
        val note = other as Note
        return note.id == id && note.title == title && note.content == content
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + title.hashCode()
        result = 31 * result + (content?.hashCode() ?: 0)
        result = 31 * result + (timestamp?.hashCode() ?: 0)
        return result
    }

    companion object {
        val CREATOR: Parcelable.Creator<Note> = object : Parcelable.Creator<Note> {
            override fun createFromParcel(`in`: Parcel): Note? {
                return Note(`in`)
            }

            override fun newArray(size: Int): Array<Note?> {
                return arrayOfNulls(size)
            }
        }
    }
}
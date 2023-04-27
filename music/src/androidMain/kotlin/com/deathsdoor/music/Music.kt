package com.deathsdoor.music

import org.jaudiotagger.audio.AudioFile
import org.jaudiotagger.audio.AudioFileIO
import org.jaudiotagger.tag.FieldKey
import org.jaudiotagger.tag.Tag
import java.io.File

actual class Music internal actual constructor(filePath: String) {
    private val audioFile: AudioFile = AudioFileIO.read(
        File(filePath).also {
            if(!it.exists()) throw IllegalArgumentException("Leider File does not exist on device for file path : $filePath")
        }
    )

    private val tag: Tag get() = if(tagOrCreate && valueOrDefault) audioFile.tagOrCreateAndSetDefault else if(tagOrCreate && !valueOrDefault) audioFile.tagOrCreateDefault else audioFile.tag

    private fun saveChanges() = audioFile.commit()

    actual var tagOrCreate : Boolean = false
    actual var valueOrDefault : Boolean = false

    actual var name:String get() = tag.getFirst(FieldKey.TITLE)
        set(value) {
            tag.setField(FieldKey.TITLE,value)
            saveChanges()
        }

    actual var artists: List<String> get() = tag.getAll(FieldKey.ARTIST)
        set(value) {
            tag.setField(FieldKey.ARTIST,*value.toTypedArray())
            saveChanges()
        }

    actual var album: String get() = tag.getFirst(FieldKey.ALBUM)
        set(value) {
            tag.setField(FieldKey.ALBUM, value)
            saveChanges()
        }

    actual var albumArtists: List<String>
        get() = tag.getAll(FieldKey.ALBUM_ARTIST)
        set(value) {
            tag.setField(FieldKey.ALBUM_ARTIST,*value.toTypedArray())
            saveChanges()
        }
}
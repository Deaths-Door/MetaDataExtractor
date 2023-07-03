package com.deathsdoor.metadataextractor.music

import com.deathsdoor.uri.URI
import org.jaudiotagger.audio.AudioFile
import org.jaudiotagger.audio.AudioFileIO
import org.jaudiotagger.tag.FieldKey
import org.jaudiotagger.tag.Tag
import java.io.File
import kotlin.time.Duration.Companion.milliseconds

actual class MusicMetadataExtractor actual constructor(file: String) {
    private val audioFile: AudioFile = run {
        val fileInstance = File(file)
        if(!fileInstance.exists()) throw IllegalArgumentException("Leider File does not exist on device for file path : $file")
        AudioFileIO.read(fileInstance)
    }

    private val tag: Tag get() = audioFile.tagOrCreateAndSetDefault

    private fun saveChanges() = audioFile.commit()

    actual var name : String get() = tag.getFirst(FieldKey.TITLE)
        set(value) {
            tag.setField(FieldKey.TITLE,value)
            saveChanges()
        }

    actual var artwork : URI?
        get() {
            val image = tag.firstArtwork?.imageUrl
            return if(image == null) null else URI.parse(image)
        }
        set(value) {

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

    actual var albumArtists: List<String> get() = tag.getAll(FieldKey.ALBUM_ARTIST)
        set(value) {
            tag.setField(FieldKey.ALBUM_ARTIST,*value.toTypedArray())
            saveChanges()
        }

    actual var lyrics : String get() = tag.getFirst(FieldKey.LYRICS)
        set(value) {
            tag.setField(FieldKey.LYRICS,value)
            saveChanges()
        }

    actual val trackLength : Long get() = audioFile.audioHeader.trackLength.milliseconds.inWholeMilliseconds

}
package com.deathsdoor.music

actual class Music internal actual constructor(filePath: String) {
    actual var tagOrCreate: Boolean = true
    actual var valueOrDefault: Boolean = true
    actual var name: String
        get() = TODO("Not yet implemented")
        set(value) {}
    actual var artists: List<String>
        get() = TODO("Not yet implemented")
        set(value) {}
    actual var album: String
        get() = TODO("Not yet implemented")
        set(value) {}
    actual var albumArtists: List<String>
        get() = TODO("Not yet implemented")
        set(value) {}
}
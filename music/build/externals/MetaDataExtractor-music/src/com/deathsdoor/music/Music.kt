package com.deathsdoor.music

actual class Music internal actual constructor(filePath: String) {

    //  val trackArtwork : String?
    //  val trackLength : Double
    actual var tagOrCreate: Boolean
        get() = TODO("Not yet implemented")
        set(value) {}
    actual var valueOrDefault: Boolean
        get() = TODO("Not yet implemented")
        set(value) {}
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
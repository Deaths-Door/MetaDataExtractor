package com.deathsdoor.music

expect class Music internal constructor(filePath : String) {
    //Options
    var tagOrCreate : Boolean
    var valueOrDefault : Boolean

    //Tags
    var name: String

    var artists: List<String>

    var album: String
    var albumArtists: List<String>

    //  val trackArtwork : String?
    //  val trackLength : Double
}
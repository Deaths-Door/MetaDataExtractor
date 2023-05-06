package com.deathsdoor.metadataextractor.music

import com.deathsdoor.metadataextractor.base.MetadataExtractor

fun MetadataExtractor.music(filePath: String) = Music(filePath)

expect class Music constructor(filePath : String) {
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
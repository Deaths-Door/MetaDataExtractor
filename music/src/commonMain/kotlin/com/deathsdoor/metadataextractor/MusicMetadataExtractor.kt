package com.deathsdoor.metadataextractor.music

import com.deathsdoor.uri.URI

expect class MusicMetadataExtractor constructor(file : String){
    var name: String
    var artwork: URI?


    var artists: List<String>

    var album: String
    var albumArtists: List<String>

    var lyrics: String

    val trackLength: Long
}
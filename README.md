# MusicManager
An Android application to learn latest technologies in android world!

[![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=21)
[![Build Status](https://travis-ci.org/SirLordPouya/MusicManager.svg?branch=master)](https://travis-ci.org/SirLordPouya/MusicManager)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/67a4e8c3a6c240eea8bab676e83c1dbc)](https://www.codacy.com/app/SirLordPouya/MusicManager?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=SirLordPouya/MusicManager&amp;utm_campaign=Badge_Grade)

<p align="center">
<img src="https://raw.githubusercontent.com/SirLordPouya/MusicManager/master/shots/appicon.png" width="250">
</p>

MusicManager is an Android application for those who want to get familiar with the latest technologies in Android World.

<img src="https://raw.githubusercontent.com/SirLordPouya/MusicManager/master/shots/Screenshot_2.png" width="250"> <img src="https://raw.githubusercontent.com/SirLordPouya/MusicManager/master/shots/Screenshot_3.png" width="250"> <img src="https://raw.githubusercontent.com/SirLordPouya/MusicManager/master/shots/Screenshot_4.png" width="250">

## Description

### How app works

This application is designed to find singers and their top albums. I used the api from last.fm website (you can find the details in the api section).
There are 4 main pages:

1.  Saved albums : shows albums saved by user. works also in offline mode
2.  Search artist
3.  Top albums : shows top albums of the selected artist.
4.  Album details : shows details of the selected album

### Technologies and Architecture

Technologies that have been used in this projects are :

*   MVVM
*   Room
*   ViewModel
*   Dark/Light Mode
*   DI via Hilt
*   Retrofit
*   Kotlin Coroutines
*   Kotlin
*   LiveData
*   Navigation
*   Single Activity
*   Safe Args
*   DiffUtils
*   Binding
*   Paging3

### API

All the api's has provided by the last.fm website. for more information please visit their website.

### Design Note
Unfortunately the API that I used is not reliable enough. there is no integer unique identifier for albums,
or artists. The mbid field is a string id and as we know its not as good as integers for being used as a Primary Key.
And also you can find lots of cases that even this field is null!
That's why I have used names(Artists, Albums, Tracks) to retrieve and save data in the room database.

## License

MusicManager is released under the Apache License 2.0. See [LICENSE](https://github.com/SirLordPouya/MusicManager/blob/master/LICENSE.md) for details.

Copyright (c) 2019 Pouya Heydari
package ir.heydarii.musicmanager.repository.network

import ir.heydarii.musicmanager.pojos.albumdetails.AlbumDetailsResponseModel
import ir.heydarii.musicmanager.pojos.searchartist.ArtistResponseModel
import ir.heydarii.musicmanager.pojos.topalbums.ArtistTopAlbumsResponseModel
import ir.heydarii.musicmanager.utils.Constants.Companion.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Retrofit interface to call the needed apis
 */
interface RetrofitAlbumsInterface {

    @GET("?method=artist.search&format=json")
    suspend fun findArtist(
        @Query("artist") artist: String,
        @Query("page") pageNumber: Int,
        @Query("api_key") apiKey: String = API_KEY
    ): ArtistResponseModel

    @GET("?method=artist.gettopalbums&format=json")
    suspend fun getTopAlbumsByArtist(
        @Query("artist") artist: String,
        @Query("page") pageNumber: Int,
        @Query("api_key") apiKey: String = API_KEY
    ): ArtistTopAlbumsResponseModel

    @GET("?method=album.getinfo&format=json")
    suspend fun getAlbumDetails(
        @Query("artist") artist: String,
        @Query("album") albumName: String,
        @Query("api_key") apiKey: String = API_KEY
    ): AlbumDetailsResponseModel
}

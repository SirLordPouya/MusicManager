package ir.heydarii.musicmanager.repository.local

import androidx.room.*
import ir.heydarii.musicmanager.pojos.savedalbums.AlbumEntity
import ir.heydarii.musicmanager.pojos.savedalbums.AlbumTracks
import ir.heydarii.musicmanager.pojos.savedalbums.TrackEntity

/**
 * All Room queries are in this class
 */
@Dao
interface AlbumsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAlbum(albumEntity: AlbumEntity)

    @Query("SELECT * FROM albums")
    suspend fun getAllAlbums(): List<AlbumEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTracks(vararg tracks: TrackEntity)

    @Query("SELECT * FROM tracks")
    suspend fun getAllTracks(): List<TrackEntity>

    @Transaction
    @Query("SELECT * FROM albums WHERE artistName = :artistName and albumName = :albumName LIMIT 1")
    suspend fun getSpecificAlbum(artistName: String, albumName: String): AlbumTracks

    @Query("SELECT COUNT(*)>0 from albums WHERE artistName =:artistName and albumName =:albumName")
    suspend fun doesAlbumExists(artistName: String, albumName: String): Boolean

    @Query("DELETE from albums where artistName = :artistName and albumName =:albumName")
    suspend fun removeAlbum(artistName: String, albumName: String)
}

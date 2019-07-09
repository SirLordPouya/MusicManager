package ir.heydarii.musicmanager.features.savedalbums

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.orhanobut.logger.Logger
import io.reactivex.disposables.CompositeDisposable
import ir.heydarii.musicmanager.base.BaseViewModel
import ir.heydarii.musicmanager.base.di.DaggerDataRepositoryComponent
import ir.heydarii.musicmanager.pojos.AlbumDatabaseEntity
import ir.heydarii.musicmanager.repository.DataRepository

class SavedAlbumsViewModel : BaseViewModel() {

    private val dataRepository: DataRepository = DaggerDataRepositoryComponent.create().getDataRepository()
    private val composite = CompositeDisposable()
    private val albumsList = MutableLiveData<List<AlbumDatabaseEntity>>()


    /**
     * Fetches all albums from database
     */
    fun getAllAlbums() {
        composite.add(
                dataRepository.getAllSavedAlbums()
                .subscribe({
                    albumsList.value = it
                }, {
                    Logger.d(it)
                    //TODO : Handle the error
                })
        )
    }

    /**
     * returns an immutable instance of live data
     */
    fun getAlbumList(): LiveData<List<AlbumDatabaseEntity>> {
        return albumsList
    }


    /**
     * disposing the disposables
     */
    override fun onCleared() {
        super.onCleared()
        composite.dispose()
    }
}
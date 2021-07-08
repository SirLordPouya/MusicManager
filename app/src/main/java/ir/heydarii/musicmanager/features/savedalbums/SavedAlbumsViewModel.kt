package ir.heydarii.musicmanager.features.savedalbums

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import ir.heydarii.musicmanager.base.BaseViewModel
import ir.heydarii.musicmanager.pojos.AlbumEntity
import ir.heydarii.musicmanager.pojos.AlbumTracks
import ir.heydarii.musicmanager.repository.DataRepository
import ir.heydarii.musicmanager.utils.ViewNotifierEnums
import javax.inject.Inject

/**
 * ViewModel for SavedAlbums view
 */
@HiltViewModel
class SavedAlbumsViewModel @Inject constructor(private val dataRepository: DataRepository) :
    BaseViewModel() {

    private val composite = CompositeDisposable()
    private val albumsList = MutableLiveData<List<AlbumTracks>>()

    /**
     * Fetches all albums from database
     */
    fun getAllAlbums() {
        composite.add(
            dataRepository.getAllSavedAlbums()
                .subscribe({
                    if (it.isEmpty())
                        viewNotifier.value = ViewNotifierEnums.EMPTY_STATE
                    else
                        albumsList.value = it
                }, {
                    viewNotifier.value = ViewNotifierEnums.ERROR_GETTING_DATA
                })
        )
    }

    /**
     * returns an immutable instance of live data
     */
    fun getAlbumList(): LiveData<List<AlbumTracks>> {
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

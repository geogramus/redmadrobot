package ru.geogram.redmadrobottimetracker.app.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.geogram.domain.repositories.AuthRepository
import ru.geogram.redmadrobottimetracker.app.presentation.viewstates.ViewState
import ru.geogram.redmadrobottimetracker.app.presentation.viewstates.Data
import ru.geogram.redmadrobottimetracker.app.presentation.viewstates.ErrorViewState
import javax.inject.Inject


class UserFragmentViewModel @Inject constructor(private val authService: AuthRepository) : BaseViewModel() {

    val check: MutableLiveData<ViewState> = MutableLiveData()

    init {
        userInfo()
    }

    fun userInfo() {
        val disposable = authService
            .getProfile()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                check.postValue(Data(it))
            },
                {
                    check.postValue(
                        ErrorViewState(
                            it,
                            authService.getProfileFromDatabase()
                        )
                    )
                    it.printStackTrace()
                })

        safeSubscribe { disposable }
    }
}
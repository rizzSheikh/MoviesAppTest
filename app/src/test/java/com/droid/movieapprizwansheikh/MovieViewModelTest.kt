package com.droid.movieapprizwansheikh

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.droid.movieapprizwansheikh.data.model.Data
import com.droid.movieapprizwansheikh.data.repository.MoviesRepository
import com.droid.movieapprizwansheikh.viewmodel.MoviesViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.MockitoAnnotations


/**
 * Created by RIZWAN on 12-Mar-22.
 */
@RunWith(JUnit4::class)
@ExperimentalCoroutinesApi
class MovieViewModelTest {

    @Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    var repository: MoviesRepository? = null

    private var viewModel: MoviesViewModel? = null

    @Mock
    var observer: Observer<Data>? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = MoviesViewModel()
        viewModel?.moviesData?.observeForever(observer!!)
    }


}
package com.marlonncarvalhosa.climafcil

import com.marlonncarvalhosa.climafcil.domain.usecase.GetWeatherUseCase
import com.marlonncarvalhosa.climafcil.presentation.ui.state.WeatherState
import com.marlonncarvalhosa.climafcil.presentation.viewmodel.WeatherViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.test.*
import org.junit.Before
import org.junit.Test
import io.mockk.coEvery
import io.mockk.mockk
import org.junit.After
import org.junit.Assert.assertEquals

@ExperimentalCoroutinesApi
class WeatherViewModelTest {

    private lateinit var getWeatherUseCase: GetWeatherUseCase
    private lateinit var viewModel: WeatherViewModel

    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setUp() {
        getWeatherUseCase = mockk()
        viewModel = WeatherViewModel(getWeatherUseCase)
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `fetchWeather should update state to Success when use case returns data`() = runTest {
        // Arrange
        val weather = Weather(
            location = mockk(),
            current = mockk(),
            forecast = mockk()
        )
        val flow = flowOf(Result.success(weather))
        coEvery { getWeatherUseCase(any(), any()) } returns flow

        val viewModel = WeatherViewModel(getWeatherUseCase)

        // Act
        viewModel.fetchWeather("apiKey", "city")
        advanceUntilIdle()

        // Assert
        val stateFlow = viewModel.weatherState.value
        assertEquals(WeatherState.Success(weather), stateFlow)
    }


    @Test
    fun `fetchWeather should update state to Error when use case returns error`() = runTest {
        // Arrange
        val exception = Exception("Network error")
        val flow = flowOf(Result.failure<Weather>(exception))
        coEvery { getWeatherUseCase(any(), any()) } returns flow

        val viewModel = WeatherViewModel(getWeatherUseCase)

        // Act
        viewModel.fetchWeather("apiKey", "city")
        advanceUntilIdle()

        // Assert
        val stateFlow = viewModel.weatherState.value
        assertEquals(WeatherState.Error(exception), stateFlow)
    }

}
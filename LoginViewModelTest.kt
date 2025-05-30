// Testa login
// frontend/kotlin/src/test/java/com/amipet/LoginViewModelTest.kt

package com.amipet

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.amipet.ui.login.LoginViewModel
import com.amipet.data.repository.AuthRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*

class LoginViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val authRepository = mock(AuthRepository::class.java)
    private val viewModel = LoginViewModel(authRepository)

    @Test
    fun testLoginSuccess() = runBlocking {
        `when`(authRepository.login("user@email.com", "password123")).thenReturn(true)

        val result = viewModel.login("user@email.com", "password123")

        assertTrue(result)
        verify(authRepository).login("user@email.com", "password123")
    }

    @Test
    fun testLoginFailure() = runBlocking {
        `when`(authRepository.login("user@email.com", "wrong")).thenReturn(false)

        val result = viewModel.login("user@email.com", "wrong")

        assertFalse(result)
    }
}

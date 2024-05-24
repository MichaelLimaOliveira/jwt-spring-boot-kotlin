package com.jwt.jwt.repository

import com.jwt.jwt.model.Role
import com.jwt.jwt.model.User
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

import java.util.*

class UserRepositoryTest {
    private val encoder = BCryptPasswordEncoder()
    private val userRepository = UserRepository(encoder)

    @Test
    fun `Should be get all users` () {
        val users = userRepository.findALl()

        assertEquals(3, users.size)
    }

    @Test
    fun `Should be get a user by id`() {
        val user = User(
            id = UUID.randomUUID(),
            password = "passTest",
            email = "testEmail@gmail.com.br",
            role = Role.USER
        )
        userRepository.save(user)
        val foundUser = userRepository.findById(user.id)

        assertEquals(/* expected = */ foundUser?.id, /* actual = */ user.id)
    }


    @Test
    fun `Should not be get not found user` () {
        val user = User(
            id = UUID.randomUUID(),
            password = "passTest",
            email = "testEmail@gmail.com.br",
            role = Role.USER
        )
        userRepository.save(user)
        val foundUser = userRepository.findById(UUID.randomUUID())

        assertNull(foundUser)
    }
}
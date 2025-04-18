package model

import kotlin.test.Test
import kotlin.test.assertEquals

class UserInfoTest {

    @Test
    fun testNewInstance() {
        val userInfo: UserInfo = UserInfo("u1", "p1", 0.0)
        assertEquals(userInfo, userInfo, "1. Devera ser instanciavel corretamente")
    }

    @Test
    fun testSetUser() {
        val expected: String = "nu1"
        val userInfo: UserInfo = UserInfo("u1", "p1", 0.0)
        userInfo.user = expected
        assertEquals(expected, userInfo.user, "2. 'username' devera ser alteravel")
    }

    @Test
    fun testSetPassword() {
        val expected: String = "np1"
        val userInfo: UserInfo = UserInfo("u1", "p1", 0.0)
        userInfo.password = expected
        assertEquals("HASH1p000", userInfo.password, "3. 'password' devera ser alteravel")
    }

    @Test
    fun testSetCredit() {
        val expected: Double = 1.0
        val userInfo: UserInfo = UserInfo("u1", "p1", 0.0)
        userInfo.credit = expected
        assertEquals(expected, userInfo.credit, "4. 'credit' devera ser alteravel")
    }

    @Test
    fun testGetUser() {
        val expected: String = "nu1"
        val userInfo: UserInfo = UserInfo(expected, "p1", 0.0)
        assertEquals(expected, userInfo.user, "5. 'username' devera ser obtido corretamente")
    }

    @Test
    fun testGetPassword() {
        val expected: String = "HASH1p000"
        val userInfo: UserInfo = UserInfo("u1", "p1", 0.0)
        assertEquals(expected, userInfo.password, "6. Metodo 'getPassword()' devera ser executado corretamente")
    }

    @Test
    fun testGetCredit() {
        val expected: Double = 1.0
        val userInfo: UserInfo = UserInfo("u1", "p1", expected)
        assertEquals(expected, userInfo.credit, "7. Metodo 'getCredit()' devera ser executado corretamente")
    }
}

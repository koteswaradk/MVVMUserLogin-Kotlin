package com.hcl.login.assignement.view

import com.hcl.login.assignement.util.LoginValidator
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4::class)
class MainActivityUnitTest{

    private val checkSuccess=true

    @Test
    fun isValidUserNameTest(){
       val usernamevalidcheck=LoginValidator.isValidUserName("kote9kote")
        assertEquals(checkSuccess,usernamevalidcheck)

    }
      @Test
      fun isValidPasswordTest(){
          val passwordvalidcheck=LoginValidator.isValidPassword("91k876")
          assertEquals(checkSuccess,passwordvalidcheck)

      }
    @Test
    fun isLoginValidTest(){
        val ressult= LoginValidator.isLoginvalid("kote","1234")
        assertEquals(checkSuccess,ressult)
    }

}
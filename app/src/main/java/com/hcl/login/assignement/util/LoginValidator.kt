package com.hcl.login.assignement.util

import java.util.regex.Matcher
import java.util.regex.Pattern

object LoginValidator {

    private val USERNAME_PATTERN = "^[a-zA-Z]*$"
    private val PASSWORD_PATTERN = "^[0-9]*$"
    private val usernamepattern: Pattern = Pattern.compile(USERNAME_PATTERN)
    private val passwordpattern: Pattern = Pattern.compile(PASSWORD_PATTERN)
    fun isValidUserName(username: String): Boolean {
        val matcher: Matcher = usernamepattern.matcher(username)
        return matcher.matches()
    }
    fun isValidPassword(password: String): Boolean {
        val matcher: Matcher = passwordpattern.matcher(password)
        return matcher.matches()
    }
    fun isLoginvalid(usernmae: String, userpassword: String): Boolean {
        return (usernmae.equals("kote") && userpassword.equals("1234"))
    }
}

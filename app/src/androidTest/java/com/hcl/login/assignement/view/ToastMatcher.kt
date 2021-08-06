package com.hcl.login.assignement.view

import android.os.IBinder
import android.view.WindowManager
import androidx.test.espresso.Root
import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher

class ToastMatcher: TypeSafeMatcher<Root?>() {
    override fun describeTo(description: Description?) {
       description?.appendText("is Toast")
    }
    override fun matchesSafely(item: Root?): Boolean {
      val type: Int? =item?.windowLayoutParams?.get()?.type
        if (type==WindowManager.LayoutParams.TYPE_TOAST){
           val windowToken:IBinder= item.decorView.windowToken
            val appToken:IBinder=item.decorView.applicationWindowToken
            return windowToken==appToken
        }
        return false
    }

}

/*: TypeSafeMatcher<Root?>() {
    override fun describeTo(description: Description?) {
        description?.appendText("is toast")
    }
    override fun matchesSafely(item: Root?): Boolean {
        val type: Int? =item?.windowLayoutParams?.get()?.type
        if (type==WindowManager.LayoutParams.TYPE_TOAST){
            val windowToken:IBinder= item.decorView.windowToken
            val appToken:IBinder= item.decorView.applicationWindowToken
            return windowToken == appToken

        }

        return false
    }
}*/
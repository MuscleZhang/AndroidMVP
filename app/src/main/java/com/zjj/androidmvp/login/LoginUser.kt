package com.zjj.androidmvp.login

import android.util.Log
import com.zjj.androidmvp.bean.UserBean

class LoginUser : ILogin {
    override fun login(name: String, callback: LoginCallback) {
        Thread {
            kotlin.run {
                Thread.sleep(2000)
                var user = UserBean("zjj")
                Log.d("zjjtag", "name:" + name)
                if (name.equals("zjj")) {
                    Log.d("zjjtag", " LoginUser onSuc:")
                    callback.onSuc(user)
                } else {
                    Log.d("zjjtag", " LoginUser onFailed:")
                    callback.onFailed(user)
                }
            }
        }.start()
    }
}
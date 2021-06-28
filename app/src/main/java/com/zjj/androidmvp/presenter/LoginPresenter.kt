package com.zjj.androidmvp.presenter

import android.os.Handler
import android.os.Looper
import android.util.Log
import com.zjj.androidmvp.bean.UserBean
import com.zjj.androidmvp.login.LoginCallback
import com.zjj.androidmvp.login.LoginUser
import com.zjj.androidmvp.view.ILoginView

class LoginPresenter(var loginView: ILoginView) {
    var userLogin = LoginUser()
    lateinit var mBean: UserBean
//    lateinit var loginView: ILoginView
    lateinit var mHandler: Handler
    var isSuc:Boolean = false
    init {
        mHandler = Handler(Looper.getMainLooper())
    }
    fun login() {
        Log.d("zjjtag", "LoginPresenter login")
        userLogin.login(loginView.getName(),object :LoginCallback{
            override fun onSuc(bean: UserBean) {
                mBean = bean;
                isSuc = true
                mHandler.post { loginView.showTips() }
            }

            override fun onFailed(bean: UserBean) {
                mBean = bean
                isSuc = false
            }
        })
    }
}

interface LogCallback {
    fun suc()
    fun failed()
}
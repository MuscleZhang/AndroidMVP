package com.zjj.androidmvp.login

import com.zjj.androidmvp.bean.UserBean

interface ILogin {
    // 模拟登录请求
    fun login(name: String, callback: LoginCallback)

}
// 登录后的回调
interface LoginCallback {
    fun onSuc(bean: UserBean)
    fun onFailed(bean: UserBean)
}
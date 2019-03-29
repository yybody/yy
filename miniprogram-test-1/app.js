//app.js
App({
  onLaunch: function () {
    // 展示本地存储能力
    var logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs)
    //执行登录
    wx.login({
      success: (res) => {

        const url = 'http://127.0.0.1:8080/wenxin?code=' + res.code
        //发送请求
        wx.request({
          url: url,
          method: "GET",
          success: (res) => {
            // this.setData({
            //   token : res.data.session_key + "-" + res.data.openid
            // }),  
            wx.setStorageSync('token', res.data.session_key + "-" + res.data.openid)
          }

        })
      },
      fail: () => {
        //登录失败
      }
    })
         
 //在页面加载时判断用户的key是否过期，如果过期则执行相应操作
  this.check()
   
  },
  globalData: {
    userInfo: null
  },
  //定时触发判断session-id是否过期
  check(){

    setInterval(function(){
      wx.checkSession({

        success: (res) => {


        }
        ,
        fail: (res) => {
          console.log("已过期" + res)
           this.loginServer()
        }
      })

    }, 10000)

  },


loginServer(){

  //执行登录
  wx.login({
    success: (res) => {

      const url = 'http://127.0.0.1:8080/wenxin?code=' + res.code
      //发送请求
      wx.request({
        url: url,
        method: "GET",
        success: (res) => {
          // this.setData({
          //   token : res.data.session_key + "-" + res.data.openid
          // }),  
          wx.setStorageSync('token', res.data.session_key + "-" + res.data.openid)
        }

      })
    },
    fail: () => {
      //登录失败
    }
  })

}  
  
})
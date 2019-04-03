//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    
    userInfo: "",
    isShow:"",
    userShow:"",
    userShow2: ""


  },
 
  //事件处理函数
  
  onLoad: function () {

    const openid = wx.getStorageSync('token')
     //去get app()获取 openid判断是否是商家
    
      wx.request({
        url: 'http://192.168.43.49:8080/food_controller/powerServlet?openid='+openid,
       
        success:(res)=>{
          console.log(res.data)
          
          if (res.data) {
            wx.setStorageSync("user",false)
            this.setData({
              userShow: "block"
              
            })
          } else {
            wx.setStorageSync("user", true)
            this.setData({
              userShow: "none"
            })
          }
        }

      })
    


    //判断用户是否授权
    wx.getSetting({
      success: (res) => {
        if (res.authSetting["scope.userInfo"]) {
          this.setData({

            isShow: "none",
            userShow2: "block"

          }),//获取用户信息
            wx.getUserInfo({
              success: (data) => {
              
                this.setData({
                  
                  userInfo: data.userInfo
                })
              }
            })
            wx
            //如果是用户
            if(wx.getStorageSync('user')){
              this.timeTo()
            }else{
             wx.showToast({
               title: '请商家登录商家页面',
             })
            }

        } else {
        
          this.setData({

            isShow: "block",
            userShow2: "none"

          })

        }

      }
    })
  },
//渲染视图
  renderer(){
    //判断用户是否授权
    wx.getSetting({
      success: (res) => {
        if (res.authSetting["scope.userInfo"]) {
          this.setData({

            isShow: "none"

          }),//获取用户信息
            wx.getUserInfo({
              success: (data) => {

                this.setData({
                  userInfo: data.userInfo
                }) 
                //如果是用户
                if (wx.getStorageSync('user')) {
                  this.timeTo()
                } else {
                  this.setData({
                    userShow2: "block",
                   

                  })
                  wx.showToast({
                    title: '请商家登录商家页面',
                  })
                }
               
              }
            })
            

        } else {
          wx.showModal({
            title: '提示',
            content: '你已经取消授权',
          })
          this.setData({
          
            isShow: "block"

          })

        }

      }
    })
  },
//点击后渲染视图，隐藏按钮
authorization(res){
  
    this.renderer() 
  },

onShow(){
 
  
  },

//设置定时器跳转
timeTo:function(){

 const time =   setTimeout(function () {
     
    wx.redirectTo({
      url: '/pages/main/main',
    })
  }, 100)
  

},
//login页面
navigateToLogin(){

  wx.redirectTo({
    url: '/pages/merchant/login',
  })
}


})

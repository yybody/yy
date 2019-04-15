//index.js
//获取应用实例
const app = getApp()
var user="";
Page({
  data: {
    
    userInfo: "",
    isShow:"",
    userShow:"",
    userShow2: ""


  },
 
  //事件处理函数
  
  onLoad: function () {
  
    
    //执行登录
    wx.login({
      success: (res) => {
        console.log(res.code)
        const url = 'http://192.168.43.49:8080/food_controller/getSessionKeyServlet?code=' + res.code
        //发送请求
        wx.request({
          url: url,
          method: "GET",
          success: (res) => {
            console.log("返回值" + res.data)
       
            if (res.data) {
              user=false
              this.setData({
                userShow: "block"

              })
            } else {
              user=true
              this.setData({
                userShow: "none"
              })
            }
          }

        })
      },
      fail: () => {
        //登录失败
        console.log("登录失败")
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
            if(user){
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
                if (user) {
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

// login2:(e)=>{
//   const openid = wx.getStorageSync('token')
//   console.log("openid" + openid)
//   //去get app()获取 openid判断是否是商家

//   wx.request({
//     url: 'http://192.168.43.49:8080/food_controller/powerServlet?openid=' + openid,

//     success: (res) => {
//       console.log(res.data)

//       if (res.data) {
//         wx.setStorageSync("user", false)
//         this.setData({
//           userShow: "block"

//         })
//       } else {
//         wx.setStorageSync("user", true)
//         this.setData({
//           userShow: "none"
//         })
//       }
//     }

//   })
// },
login3:(e)=>{
 
},

onShow(){
 wx.login({
   
   success:(res)=>{
     const url = 'http://192.168.43.49:8080/food_controller/powerServlet?code=' + res.code
     wx.request({
       url: url,
       header: {
         "Content-Type": "application/x-www-form-urlencoded"
       },
       success:(res)=>{
         
         wx.setStorageSync('token', res.data.session_key + "-" + res.data.openid)
         console.log("我的opendid"+wx.getStorageSync("token"))
       }
     })
   }
 })


  
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

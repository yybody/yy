Page({
  
  data:{
    openid:wx.getStorageSync("token")
  },
  
  
  formSubmit:function(e){
    
    console.log('form发生了submit事件，携带数据为：', e.detail.value)
    const value = e.detail.value
    const a = "192.168.43.49/food_controller/addSouponServlet";
    wx.request({
      url: 'http://192.168.43.50:8080/food_controller/SellerLogin',
      method:'post',
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      data:value,
      success(e){
        console.log(e)
        //判斷登录请求是否通过
          if(e.data[0].data==1){
             wx.redirectTo({
               url: '/pages/merchant/homePage'
             })
          }
      },fail(e){
        wx.showToast({
          title: '网络问题请求失败',
        })
      }
    })
  }
 
})
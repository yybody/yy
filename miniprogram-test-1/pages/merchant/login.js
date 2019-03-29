Page({
  data:{
  },
  formSubmit:function(e){
    console.log('form发生了submit事件，携带数据为：', e.detail.value)
    const value = e.detail.value
    const a = "192.168.43.49/food_controller/addSouponServlet";
    wx.request({
      url: 'http://192.168.43.49:8080/food_controller/addSouponServlet',
      method:'post',
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      data:value,
      success(e){
        //判斷登录请求是否通过
          if(e.data){
             wx.redirectTo({
               url: '/pages/merchant/homePage'
             })
          }
      },fail(e){
        console.log(e)
      }
    })
  }
 
})
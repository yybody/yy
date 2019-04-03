// pages/merchant/Edit/edit.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
      value:"我的数据",
      openid:""
  },
  formSubmit(res){
   
    console.log('form发生了submit事件，携带数据为：', res.detail.value)
    wx.request({
      url: 'http://192.168.43.49:8080/food_controller/updateSellerServlet',
      data: res.detail.value,
      header:{
        "Content-Type": "application/x-www-form-urlencoded"
      },
      method:'post',
      success:(res)=>{
        if(res.data==1){
         
          console.log("请求成功" + res)
        }else{
          console.log(res)
          console.log("服务器出错" + res)
        }
        
        
      },fail:()=>{
        console.log("网络出错"+res)
      }
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      openid: wx.getStorageSync('token')
    })
    
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})
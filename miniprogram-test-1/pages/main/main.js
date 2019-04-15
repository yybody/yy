// pages/main/main.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userInfo:{},
    imgUrls: [
      'https://images.unsplash.com/photo-1551334787-21e6bd3ab135?w=640',
      'https://images.unsplash.com/photo-1551214012-84f95e060dee?w=640',
      'https://images.unsplash.com/photo-1551446591-142875a901a1?w=640'
    ],

    interval: 3000,
    autoplay: true,
    indicator: true,
    activecolor: '#876541',
    indicatorcolor: '#567890',
    seller:{}

  },
  formSubmit(e){

    console.log('form发生了submit事件，携带数据为：', e.detail.value.openid)
    let openid = e.detail.value.openid
    wx.navigateTo({
      url: '/pages/main/shopItem/shopitem?openid='+openid,
    })

  },

  //跳转到我的主页
requestTo(){
 wx.navigateTo({
   url: '/pages/main/home',
 })
},
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    wx.request({
      url: 'http://192.168.43.49:8080/food_controller/selectAllSeller',
      header:{
        "Content-Type": "application/x-www-form-urlencoded"
      },
      success:(res)=>{
        console.log(res.data[0])
         this.setData({
           seller: res.data
         })
      }

    })
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
     wx.getUserInfo({

       success:(res)=>{
         
         this.setData({
           userInfo:res.userInfo
         })
       }
     })
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
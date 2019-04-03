// pages/merchant/homeFound/found.js

Page({
  
  /**
   * 页面的初始数据
   */
  data: {
    nums:"",//每一种劵的数量
    type:"",//劵的类型
    indicatorDots: false,
    autoplay: false,
    interval: 5000,
    duration: 1000

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
    const openid = wx.getStorageSync('token')
    
    wx.request({
      url: 'http://192.168.43.49:8080/food_controller/souponNumServlet?openid='+openid,
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      success: (res) => {
        console.log(res)
        this.setData({
          type: res.data
        })
      }
    })
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    const openid = wx.getStorageSync('token')
    //请求数据
    wx.request({
      url: 'http://192.168.43.49:8080/food_controller/SelectAllSoupon?openid='+openid,
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      success: (res) => {
        console.log(res)
        this.setData({
          nums: res.data
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
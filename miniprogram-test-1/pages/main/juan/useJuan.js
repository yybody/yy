// pages/main/juan/useJuan.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    quan: "",
    isShow:0
  },
  //获取可以使用的
getUse(){
  this.setData({
    isShow:1
  })
  wx.request({
    url: 'http://192.168.43.49:8080/food_controller/canUseSoupon',
    header: {
      "Content-Type": "application/x-www-form-urlencoded"
    },
    success:(res)=>{
     console.log(res)
      this.setData({
        quan: res.data
      })
    },fail:(res)=>{
      console.log(res)
    }
  })
},
 //获取失效的
getShi(){
  this.setData({
    isShow: 0
  })
  wx.request({
    url: 'http://192.168.43.49:8080/food_controller/outSoupon',
    header: {
      "Content-Type": "application/x-www-form-urlencoded"
    },
    success: (res) => {
      console.log(res)
      this.setData({
        quan:res.data
      })
      
    }, fail: (res) => {
      console.log(res)
    }
  })

},

changes(event){
  console.log(event.detail)
  this.setData({
    im: event.detail
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
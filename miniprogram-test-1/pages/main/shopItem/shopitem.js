// pages/main/shopItem/shopitem.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
     quan:""
  },
   //领劵
  formSubmit(e) {
    console.log('form发生了submit事件，携带数据为：', e.detail.value)
    wx.request({
      url: 'http://192.168.43.49:8080/food_controller/userGetSoupon',
      method:'post' ,
      data:e.detail.value,
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      success: (res) => {
        if (res.data == 1) {

          wx.showToast({
            title: '领取成功',
          })
        }
        else {
          wx.showToast({
            title: '劵领取完了',
          })
        }


      }, fail: () => {
        wx.showToast({
          title: '网络出错',
        })
      }
    })
  },
 


  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    const openid = options.openid
    wx.request({
      url: 'http://192.168.43.49:8080/food_controller/selectSouponBySeller?openid='+openid,
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
     success:(res)=>{
        console.log(res)  
        this.setData({
          quan:res.data
        })
     }
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
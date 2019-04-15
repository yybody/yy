// pages/merchant/homePage.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
   
  },
  /*扫一扫 */
  sys(e) {
    wx.scanCode({
      onlyFromCamera: true,
      success: (res) => {
        console.log(res.result)
        wx.request({
          url: 'http://192.168.43.49:8080/food_controller/setOut',
          header: {
            "Content-Type": "application/x-www-form-urlencoded"
          },
          method:"post",
          data:{"id":res.result},
          success:(res)=>{
          if(res.data==1){
            wx.showToast({
              title: '扫描成功',
            })
          }

          },fail(res){
            wx.showToast({
              title: '请求失败',
            })

          }


        })
      }
    })

  },
  hint(){

   wx.showModal({
     title: '提示',
     content: '后续功能暂未开放',
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
    wx.getUserInfo({
      success: (data) => {
        this.setData({
          userInfo: data.userInfo
        })
      }
    })
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
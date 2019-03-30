// pages/merchant/homrCreat/creat.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
      date:"",
      items:""
     
  },
   
  //获取时间显示
  bindDateChange(res){
    
    this.setData({
      date: res.detail.value
      
    })


  },
  //获取提交数据
  formSubmit(res){
    
    console.log('form发生了submit事件，携带数据为：', res.detail.value)
  
    wx.request({
      url: 'http://192.168.43.49:8080/food_controller/addSouponServlet',
      method: 'post',
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      data: res.detail.value,
      success: (res) => {
        console.log(res)
      },
      fail: (res) => { console.log(res) }
    })

  },
  
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {


     wx.request({
       url: 'http://192.168.43.49:8080/food_controller/addSouponServlet',
       method: 'get',
       header: {
         "Content-Type": "application/x-www-form-urlencoded"
       },
       success: (res) => {
         this.setData({
           
         })
       },
       fail: (res) => { console.log(res) }
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
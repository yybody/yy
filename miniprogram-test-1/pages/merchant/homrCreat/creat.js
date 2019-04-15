
 // pages/merchant/homrCreat/creat.js
 const open = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
      date:"",
      items:"",
     openid:"",
    typeIndex:""
  },
  
  bindPickerChange(res){
    console.log(res)
    const i = res.detail.value;
    this.setData({
      typeIndex: i


    })
  },
   
  //获取时间显示
  bindDateChange(res){
    
    this.setData({
      date: res.detail.value,
      
      
    })


  },
  //获取提交数据
  formSubmit(res){
    
    
    
    
    console.log('form发生了submit事件，携带数据为：', res.detail.value )
    wx.request({
      url: 'http://192.168.43.49:8080/food_controller/addSouponServlet',
      method: 'post',
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      data: res.detail.value,
      success: (res) => {
        console.log(res)
        if(res.data=='ok'){
          wx.showToast({
            title: '提交成功',
          })
        }else{

          wx.showToast({
            title: '服务器出错',
          })

        }
      },
      fail: (res) => {
        wx.showToast({
          title: '网络问题提交出错',
        }) }
    })

  },
  
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      openid:wx.getStorageSync("token")
    })
    
    wx.request({
      url: 'http://192.168.43.49:8080/food_controller/selectType',
      method: 'get',
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      success: (res) => {
         console.log(res.data)
        this.setData({
          items: res.data
        })
      },
      fail: (res) => { console.log("失败",res) }
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
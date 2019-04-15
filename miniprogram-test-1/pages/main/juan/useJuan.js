// pages/main/juan/useJuan.js
var QRCode = require('../../../utils/weapp-qrcode.js');
var qrcode;
Page({

  /**
   * 页面的初始数据
   */
  data: {
    quan: "",
    isShow:0,
    viablelength:"",
    unviablelength:"",
    isshow: "block"
    
  },
  //获取可以使用的
getUse(){
  this.setData({
    isShow:1
  })
  const openid = wx.getStorageSync("token")
  wx.request({
    url: 'http://192.168.43.49:8080/food_controller/canUseSoupon?openid='+openid,
    header: {
      "Content-Type": "application/x-www-form-urlencoded"
    },
    success:(res)=>{
     console.log(res)
      this.setData({
        isshow: "block",
        quan: res.data,
        viablelength:res.data.length
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
  const openid = wx.getStorageSync("token")
  wx.request({
    
    url: 'http://192.168.43.49:8080/food_controller/outSoupon?openid=' + openid,
    header: {
      "Content-Type": "application/x-www-form-urlencoded"
    },
    success: (res) => {
      console.log(res)
      this.setData({
        quan:res.data,
        unviablelength: res.data.length,
        isshow:"none"
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
    /*2维码*/
    qrcode = new QRCode('canvas', {
      text: "",
      width: 150,
      height: 150,
      colorDark: "#000000",
      colorLight: "#ffffff",
      correctLevel: QRCode.CorrectLevel.H,
    });
   
  },
  tapHandler: function (e) {
    qrcode.makeCode(e.target.dataset.code);  //用元素对应的code更新二维码
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    this.getShi();
    this.getUse();
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

  },
  //点击按钮生成二维码
  popup(event){
    console.log("asd")
    wx.showModal({
      title: '提示',
      content: '是否使用',
      success: function (e) {
        if (e.confirm) {
          console.log(event.target.dataset.code)
          qrcode.makeCode(event.target.dataset.code);  //用元素对应的code更新二维码
        } else {
          console.log("shibai")
        }


      }
    })
  }
  
  
})
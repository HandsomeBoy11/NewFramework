package com.helw.m.anew.framework.network.retrofit;

/**
 * Created by hh on 2017/5/12.
 */

public interface NetUrl {

//"http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLcMyeay2hSDPFsGicRDtN8HcXacFLmGicIOYYmVmdPFq4cQA4U5YGkkqmCqdjtuzoC5kQGae2KXhpw/132";
    //String image="Q0j4TwGTfTLcMyeay2hSDPFsGicRDtN8HcXacFLmGicIOYYmVmdPFq4cQA4U5YGkkqmCqdjtuzoC5kQGae2KXhpw/132";
    String image="rest/contentSection/getInvitationHomePageList";

//    String home="home";
    String home="home";
    String order="order";

    String login="service/user/login?";
    String capture="service/user/getCaptcha?";
    String checkcapture="service/user/checkCaptcha?";
    String register="service/user/register?";

    //订单
    String getorder="CommonOrder/orderList?";                   // 获取订单列表
    String getOrderDetail = "CommonOrder/orderDetail?";         // 获取订单详情
    String receiveOrder = "CommonOrder/instantService?";         // 接收订单.
    String refuseOrder = "CommonOrder/refuseOrder?";            // 拒绝接单.
    String finishOrder = "CommonOrder/finishOrder?";            // 结束订单.
    String deleteOrder = "CommonOrder/deleteOrder?";            // 删除订单.
    String deleteFinishOrder = "CommonOrder/deleteOverOrder?";  // 删除已完成订单.
    String cancelOrder = "CommonOrder/cancelOrder?";            // 取消订单.
    String peiSong = "CommonOrder/immediateDelivery?";          // 立即配送

    // 用户信息
    String getPersonInfo = "Owner/getUserinfo?";                 // 获取用户信息.
    String getEvaluateData = "Owner/commentlist?";               // 获取我的评价信息.
    // 钱包
    String getWalletHome = "Owner/walletHome";                   // 获取钱包数据
    // 订单消息
    String getOrderMessage = "Owner/messages";


    String getIncomeData = "Owner/walletHome?";                 // 获取用户收益信息.
    String getIncomeList = "Owner/walletDetail?";                 // 获取用户收益列表.
    // TODO: 2017/12/20 地址错误
    String changePW = "Owner/commentlist?";                      // 修改密码.
    String getVersionInfo = "version/get?";                      // 获取版本信息.
    String advice = "xtsz/opinion/commit?";                      // 意见反馈

    String updatename="Owner/modifyUserinfo?";
    // 上传头像
    String upPhoto = "service/user/uploadPhoto";
}

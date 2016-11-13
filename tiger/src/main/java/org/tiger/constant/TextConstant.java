package org.tiger.constant;


/**
 * Created by Administrator on 2015/1/15 0015.
 */
public interface TextConstant {
    /**
     * 业务处理成功
     */
    int DEAL_SUCCESS = 0;
    /**
     * 业务处理失败
     */
    int DEAL_FAIL = -1;
    /**
     * 服务器异常
     */
    int SERVER_ERROR = 500;
    /**
     * 无效的AccessToken
     */
    int INVALID_ACCESS_TOKEN = 501;
    /**
     * 参数不足
     */
    int PARAM_NOT_ENOUGH = 502;
    /**
     * 参数检查不通过
     */
    int PARAM_CHECK_FAIL = 503;
    /**
     * 公钥过期
     */
    int PUBLICKEY_OVERDUE = 565;
    /**
     * 账号或密码不正确
     */
    int ACCOUNT_OR_PASSWORD_ERROR = 504;
    /**
     * token过期
     */
    int ACCESS_TOKEN_OVERDUE = 505;
    /**
     * 用户不存在
     */
    int USER_NOT_EXIST = 506;
    /**
     * 用户已存在
     */
    int USER_EXIST = 507;
    //订单已被接
    int ORDER_ALREADY_BEEN_TAKEN = 508;
    //订单信息不正确
    int ORDER_INFO_NOT_CORRECT = 509;
    //账号未通过认证
    int ACCOUNT_UN_PASS_VERIFY = 510;
    //已经抢过订单
    int YOU_ALREADY_GRAB = 511;
    //司机没有抢这个订单
    int DRIVER_NOT_GRAB_THE_ORDER = 512;
    //不在可抢单的状态
    int UN_CORRECT_ORDER_STATUS = 513;
    //订单已经评价过
    int ORDER_EVALUATED = 514;
    //不满足评价条件
    int NOT_MEET_CONDITION = 515;
    //支付密码不正确
    int PAY_PASSWORD_NOT_CORRECT = 520;
    //余额不足
    int BALANCE_NOT_ENOUGH = 521;
    //没有设置支付密码
    int PAY_PASSWORD_NEVER_SET = 522;
    //订单已经支付过，不能重复支付
    int ORDER_PAIED = 523;
    //查询信息不存在
    int SEARCH_INFO_NOT_EXIST = 524;
    //交易记录不存在
    int TRADE_RECORD_NOT_EXIST = 525;
    /**
     * 验证码不正确
     */
    int CAPTCHA_NOT_CORRECT = 526;
    /**
     * 邀请码或者帐号不正确
     */
    int CODE_OR_ACCOUNT_NOT_CORRECT = 527;
    /**
     * 已经接受过邀请
     */
    int ALREADY_ACCEPTED_INVITE = 528;
    /**
     * 订单状态不满足条件
     */
    int ORDER_STATUS_UN_FIT = 529;
    /**
     * 地址只允许创建一条
     */
    int ADDRESS_ONLY_ONE_ALLOWED = 530;
    /**
     * 优惠券不存在
     */
    int USER_COUPON_NOT_EXIST = 531;
    /**
     * 优惠券不可使用
     */
    int USER_COUPON_CAN_NOT_USE = 532;
    /**
     * 听单线路不存在
     */
    int LISTEN_LINE_NOT_EXIST = 533;
    /**
     * 系统维护中
     */
    int SYSTEM_MAINTAINING = 534;

    int addPrizeLog = 789;
    int SEND_MESSAGE_ALL = 756;
    int CODE_SEND_BUSSY = 871;

    int ALIPAY = 888;
    int WXPAY = 999;
    int WX_H5_PAY = 1111;

    int INIT_TIMER_TASK = 1314;

    String TelRegister = "易翔一元寻宝注册验证";
    String LOOKUPPASSWORD = "易翔一元寻宝密码找回验证";
    String LUCK_NUMBER_QUEUE = "LUCKNUMBERQUEUE";
    String PHONE_LOGIN = "登陆验证";
    String CHECK_IN = "CHECK_IN";


}

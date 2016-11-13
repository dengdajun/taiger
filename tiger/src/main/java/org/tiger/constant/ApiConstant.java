package org.tiger.constant;

/**
 * @author 小兵哥哥
 * @date 2015年08月
 */
public interface ApiConstant {

    interface Status {
        /**
         * 操作成功
         */
        int SUCCESS = 1;
        /**
         * 操作失败
         */
        int FAIL = 2;
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
         * 密码不正确
         */
        int PASSWORD_ERROR = 504;
        /**
         * access_Token过期
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

        /**
         * 参数类型错误
         */
        int PARAM_TYPE_ERORR = 508;

        /**
         * 不能再次修改性别了
         */
        int GENDER_IMMUTABLE = 509;

        /**
         * 短信验证码发送失败
         */
        int SMS_SEND_FAIL = 510;

        /**
         * 没有快递员角色
         */
        int NO_COURIER_ROLE = 511;

        /**
         * 用户未登录
         */
        int USER_NOT_LOGIN = 512;

        /**
         * 手机号码格式错误
         */
        int ACCOUNT_ERROR = 513;

        /**
         * 请求资源不存在
         */
        int RESOURCE_NOT_EXISTS = 514;

        /**
         * 还没有资格抢
         */
        int ILLEGAL_OPERATION = 515;

        /**
         * 账号被禁用
         */
        int USER_ACCOUNT_FORBIDDEN = 516;

        /**
         * 活动已经结束
         */
        int ACTIVITY_NOT_GOING = 517;

        /**
         * 非法用户
         */
        int SURE_REDBAG_ILLEGAL_OPERATION = 523;

        int SURE_REDBAG_NOT_EXIST = 524;

        int SMALL_REDBAG_EXPIRE = 525;

        int SMALL_REDBAG_GOT = 526;


        /**
         * 地址已经存在
         */
        int ADDRESS_EXISTS = 516;

        /**
         * 重复评价
         */
        int ALREADY_EVALUATED = 517;

        /**
         * 短信验证码错误
         */
        int SMS_CODE_ERROR = 518;

        /**
         * 短信验证码过期
         */
        int SMS_CODE_EXPIRED = 519;


        /**
         * 超过当日获取验证码次数上限
         */
        int SMS_CODE_LIMITED = 520;

        /**
         * 少于最低提现金额
         */
        int TOO_LITTLE_MONEY = 521;

        /**
         * 用户尚未评价
         */
        int USER_NOT_EVALUATE = 522;

        /**
         * 系统维护中
         */
        int SYSTEM_MAINTAINING = 534;

        /**
         * 交易金额不合法
         */
        int ILLEGAL_TRADE_MONEY = 535;

        /**
         * 错误的订单类型
         */
        int BILL_TYPE_ERROR = 550;

        /**
         * 他的红包被抢完了
         */
        int REDBAG_NOT_HAVE = 551;

        /**
         * 成功抢到啦
         */
        int ROB_REDBAG_SUCCESS = 552;

        /**
         * 成功抢到啦 只是你要和我说拜拜啦
         */
        int ROB_SUCCESS_BUT_LEAVE = 553;

        /**
         * 不能抢自己发的红包
         */
        int ROB_ONESELF_REFUSE = 554;

        /**
         * 订单取消失败，已经被抢了
         */
        int BILL_CANCEL_FAIL = 555;

        /**
         * 所抢红包金额已经超限
         */
        int ROB_REDBAG_PRICE_UP_LINE = 556;
        /**
         * 支付金额不合法
         */
        int PAY_MONEY_ERROR = 557;

        /**
         * 兑换码错误
         */
        int COUPON_CODE_ERROR = 558;

        /**
         * 兑换码已经被使用
         */
        int CODE_ALREADY_USED = 559;

        /**
         * 已经抢过了
         */
        int REDBAG_ALREADY_GOT = 560;

        /**
         * 公钥过期
         */
        int PUBLICKEY_OVERDUE = 565;

        /**
         * 邀请码过期
         */
        int INVATE_CODE_EXPIRED = 566;
    }

    interface Key {
        /**
         * MapMessage中状态值的key
         */
        String STATUS = "status";
        /**
         * 消息说明的key
         */
        String MESSAGE = "message";
        /**
         * 返回数据的Key
         */
        String DATA = "data";

        /**
         * 返回AccessToken的Key
         */
        String ACCESS_TOKEN = "accessToken";
    }

    interface Message {
        String ACCESS_TOKEN_SUCCESS = "AccessToken获取成功";
        String ACCESS_TOKEN_OVERDUE = "AccessToken过期";
        String INVALID_ACCESS_TOKEN = "AccessToken无效";
        String PARAM_NOT_ENOUGH = "参数不足";
        String PASSWORD_ERROR = "密码错误";
        String OLD_PASSWORD_ERROR = "原密码错误";
        String UPDATE_PASSWORD_SUCCESS = "密码修改成功";
        String UPDATE_USER_INFO_SUCCESS = "个人信息修改成功";
        String GENERATE_INVATE_CODE_SUCCESS = "邀请码已生成";
        String VALID_INVATE_CODE = "邀请码有效";
        String INVATE_CODE_EXPIRED = "邀请码无效";
        String LOGIN_SUCCESS = "登录成功";
        String USER_NOT_EXIST = "用户不存在";
        String USER_EXIST = "用户已存在";
        String REGISTER_SUCCESS = "注册成功";
        String SMS_SEND_SUCCESS = "短信发送成功";
        String SMS_SEND_FAIL = "短信发送失败";
        String HEADIMAGE_UPLOAD_SUCCESS = "头像上传成功";
        String REQUIRE_SUCCESS = "请求成功";
        String PUBLICKEY_OVERDUE = "公钥过期";
        String LACK_OF_BALANCE = "余额不足";
        String REDBAG_NOT_HAVE = "ta的红包已经被抢光啦";
        String ROB_REDBAG_SUCCESS = "恭喜你，抢到了ta的红包";
        String ROB_SUCCESS_BUT_LEAVE = "成功抢到啦 只是你要和我说拜拜啦";
        String ROB_ONESELF_REFUSE = "您不能抢自己发出的红包啦";
        String USER_NOT_LOGIN = "用户未登录";
        String BILL_CANCEL_FAIL = "取消失败，已经被抢了";
        String SMALL_REDBAG_EXPIRE = "红包已过期";
        String SURE_SUCCESS = "领取成功";
        String ROB_REDBAG_PRICE_UP_LINE = "请领取抢到的红包，您无法再抢了";
        String PARAM_TYPE_ERORR = "参数类型错误";
        String GENDER_IMMUTABLE = "不能再次修改性别了";
        String ACCOUNT_ERROR = "不合法的手机号码";
        String RESOURCE_NOT_EXISTS = "请求资源不存在";
        String ILLEGAL_OPERATION = "您暂时还不能抢Ta们的红包噢";
        String SURE_REDBAG_ILLEGAL_OPERATION = "非有效用户";
        String SURE_REDBAG_NOT_EXIST = "红包不存在";
        String PARAM_CHECK_FAIL = "参数检查错误";
        String ADDRESS_EXISTS = "地址已存在";
        String SMALL_REDBAG_GOT = "不能重复领取啦";
        String ALREADY_EVALUATED = "您已经评价过了";
        String SUCCESS = "OK";
        String FAIL = "NO";
        String USER_ACCOUNT_FORBIDDEN = "你的账号已被禁用了";
        String ACTIVITY_NOT_GOING = "当前时间无法参与抢红包";
        String SMS_CODE_ERROR = "短信验证码错误";
        String SMS_CODE_EXPIRED = "验证码已过期，请重新获取";
        String SMS_CODE_LIMITED = "超过当日验证码最大获取次数";
        String TOO_LITTLE_MONEY = "少于最低提现金额";
        String USER_NOT_EVALUATE = "用户尚未评价";
        String COUPON_CODE_ERROR = "兑换码错误";
        String REDBAG_ALREADY_GOT = "你已经抢过ta的红包啦";
        String COUPON_ALREADY_USED = "优惠券已被使用";
        String ILLEGAL_TRADE_MONEY = "交易金额不合法";
    }

    interface FileConstant {

        /**
         * 订单描述照片存放文件目录
         */
        String BILL_DESCRIBEIMG_FILEPATH = "static/images/bill/";

        /**
         * 用户头像存放文件目录
         */
        String USER_HEADIMG_FILEPATH = "static/images/redbagusers/headimages/";

        /**
         * 用户个人形象照片、身份证照片存放文件目录
         */
        String USER_IDIMG_FILEPATH = "static/images/apply/";

        /**
         * 说说图片文件目录
         */
        String FORUM_IMG_FILEPATH = "static/images/forum/";

        /**
         * 首页图片文件目录
         */
        String NOTICE_IMG_FILEPATH = "static/images/notice/";

        /**
         * 新闻图片文件目录
         */
        String NEWS_IMG_FILEPATH = "static/images/news/";

        String[] DEFAULT_HEADIMAGES = {
                USER_HEADIMG_FILEPATH + "default_headimg_1.jpg",
                USER_HEADIMG_FILEPATH + "default_headimg_2.jpg",
                USER_HEADIMG_FILEPATH + "default_headimg_3.jpg",
                USER_HEADIMG_FILEPATH + "default_headimg_4.jpg",
                USER_HEADIMG_FILEPATH + "default_headimg_5.jpg",
                USER_HEADIMG_FILEPATH + "default_headimg_6.jpg",
                USER_HEADIMG_FILEPATH + "default_headimg_7.jpg",
        };
    }
    interface FileURLConstant {

        /**
         * 风格图片URL
         */
        String FORUM_IMG_URL= "http://118.178.17.220:8080/Fitz/static/images/style/";

        /**
         * 订单描述照片URL
         */
        String BRAND_DESCRIBEIMG_URL = "http://118.178.17.220:8080/Fitz/static/images/brand/";

        /**
         * 用户头像URL
         */
        String USER_HEADIMG_URL = "http://118.178.17.220:8080/Fitz/static/images/user/";

        /**
         * 新闻URL
         */
        String NEWS_IMG_URL = "http://192.168.2.105:8080/Fitz/static/images/news/";

        /**
         * 用户个人形象照片、身份证照片URL
         */
        String USER_IDIMG_URL = "http://118.178.17.220:8080/Fitz/static/error/";

    }

    interface Bill {

        /**
         * 订单类型
         */
        int TYPE_BUY = 1;   //帮我买
        int TYPE_GET = 2;   //帮我取
        int TYPE_SEND = 3;  //帮我送

        /**
         * 订单状态
         */
        byte STATUS_WAITING_PAY = 0;   //待付款
        byte STATUS_NEW = 1;           //新发布
        byte STATUS_GRABBED = 2;       //被抢啦
        byte STATUS_RECEIVED = 3;      //已取件
        byte STATUS_ARRIVED = 4;       //已送达
        byte STATUS_COMPLETED = 5;     //已结单
        byte STATUS_USER_EVALUATED = 6;     //用户已评
        byte STATUS_BOTH_EVALUATED = 7;     //双方已评
        byte STATUS_CANCELED = 8;      //已取消
        byte STATUS_STANDBY = 9;       //等待推荐人接单
    }

    interface DateFormat {
        String DATE_1 = "yyyy-MM-dd HH:mm";
        String DATE_2 = "yyyy/MM/dd HH:mm";
    }

    interface Regex {
        String TELEPHONE_REGEX = "1(\\d){10}";
    }

    interface Page {
        /**
         * 首页显示的订单条数
         */
        int MAX_PAGESIZE = 10;
        int DEFAULT_START_PAGE = 0;
        int MAX_RATE_PAGESIZE = 100;
    }

    interface Question {
        String QUALITY = "洗护质量";
        String SERVICE = "服务态度";
        String SPEED = "物流速度";
        String PAY = "付款流程";
        String OTHER = "其他";
    }

    interface CashOutType {
        String ALIPAY = "支付宝";
        String WECHAT = "微信支付";
    }

    interface IncomeType {
        String BUY = "帮我买";
        String SEND = "帮我送";
        String GET = "帮我送";
        String RECHARGE = "充值";
        String CASHOUT = "提现";
    }

    interface Address {
        /**
         * 默认地址
         */
        Integer DEFAULT_ADDRESS = 1;
        Integer NOT_DEFAULT_ADDR = 0;

        /**
         * 地址类型
         */
        Integer IN_SCHOOL = 0;
        Integer OUT_SCHOOL = 1;
    }

    interface Star {
        Integer LEVEL_ONE = 1;
        Integer LEVEL_TWO = 2;
        Integer LEVEL_THREE = 3;
        Integer LEVEL_FOUR = 4;
        Integer LEVEL_FIVE = 5;
    }

    interface CashOutApplyStatus {
        byte NEW = 0;
        byte PASS = 1;
        byte FAIL = 2;
        byte DONE = 3;
    }

    interface MsgType {
        int FORUM_REPLY = 1;
        int BILL_FEED_BACK = 2;
    }

    interface PushType {
        String BILL = "1";
        String MSG = "2";
        String FORUM = "3";

        String BILL_NOTES = "订单";
        String MSG_NOTES = "消息";
        String FORUM_NOTES = "评论";
    }

}
3 partners get involved.

frontend - backend - wechat service

https://developers.weixin.qq.com/miniprogram/dev/framework/open-ability/login.html

![image](https://github.com/user-attachments/assets/b25fe9bf-a4de-4a5c-aca7-4462b517c720)

frontend call ``wx.login()`` get code from service, 
``return string code//用户登录凭证（有效期五分钟）。开发者需要在开发者服务器后台调用 code2Session，使用 code 换取 openid、unionid、session_key 等信息``

https://developers.weixin.qq.com/miniprogram/dev/api/open-api/login/wx.login.html


frontend call ``wx.request()`` to backend, 
````
parameter: (Object object)
Include
url: 'example.php', //仅为示例，并非真实的接口地址
  data: {
    code: '',//we need code above here.
    y: ''
  },
````

服务端API

https://developers.weixin.qq.com/miniprogram/dev/api/


1.小程序登录

https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/user-login/code2Session.html

``GET https://api.weixin.qq.com/sns/jscode2session
?appid=APPID
&secret=SECRET
&js_code=JSCODE
&grant_type=authorization_code 
 ``
````
Request parameters
String appid;//config
String secret;//config
String js_code;//code from frontend
String grant_type	= "authorization_code";//final


Response example
{
"openid":"xxxxxx",//用户唯一标识
"session_key":"xxxxx",//会话密钥
"unionid":"xxxxx",//用户在开放平台的唯一标识符，若当前小程序已绑定到微信开放平台账号下会返回
"errcode":0,
"errmsg":"xxxxx"
}

Error code
40029 js_code无效
45011	调用太频繁，请稍候再试
40226	高风险等级用户，小程序登录拦截 。风险等级详见用户安全解方案
-1	系统繁忙，此时请开发者稍候再试
````

2.map openid与session_key, return custom token to front end.


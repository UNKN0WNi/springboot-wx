## ***主要步骤：***

1.配置内网穿透(https://www.qydev.com/)，将127.0.0.1:80映射到隧道域名xxx.xxx.xx:80，
并将该域名设置到微信开放平台设置url处，验证

2.项目内token和开放平台设置的token保持一致

3.使用URL：https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=｛APPID｝&secret=｛AppSecret｝获取一个3分钟时限的access_token

4.用postman表单形式，提交媒体文件到URL：https://api.weixin.qq.com/cgi-bin/media/upload?access_token=｛access_token｝&type=｛mediatype｝，获取到返回的media_id即可使用到回复中
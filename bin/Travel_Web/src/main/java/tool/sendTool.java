package tool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class sendTool {
	static public void send(String phone,String code)
	{
		 Client client = new Client();
	     client.setAppId("hw_11231");     //开发者ID，在【设置】-【开发设置】中获取
	     client.setSecretKey("662b7b0d31391109c65ae107cd83b1d8");    //开发者密钥，在【设置】-【开发设置】中获取
	     client.setVersion("1.0");
         String singnstr = "闪速码";
         Client.Request request = new Client.Request();
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         Date now = new Date();
         Date afterDate = new Date(now.getTime() + 60000);
        // System.out.println(sdf.format(afterDate ));
	     request.setMethod("sms.message.send");
	     request.setBizContent("{\"mobile\":[\""+phone+"\"],\"type\":0,\"template_id\":\"ST_2020101100000005\",\"sign\":\"" + singnstr +"\",\"send_time\":\""+sdf.format(afterDate )+"\",\"params\":{\"code\":"+code+"}}");  // 这里是json字符串，send_time 为空时可以为null, params 为空时可以为null,短信签名填写审核后的签名本身，不需要填写签名id
	     System.out.println( client.execute(request) );
		}
	 public static void main(String[] args) throws InterruptedException {
		 TimeUnit.SECONDS.sleep(30);
		 send("17685515217","17685515217");
	 }
	 
}

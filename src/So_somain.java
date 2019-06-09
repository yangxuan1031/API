

import javafx.scene.paint.Stop;
import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;

import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by YAO on 2019-06-09.
 * 调用u8销售订单列表接口，返回u8服务器上销售订单列表数据
 */
public class So_somain {


    private static void httpRequest() {
        //buffer用于接受返回的字符
        StringBuffer buffer = new StringBuffer();
        try {
            String requestUrl = "https://api.yonyouup.com/api/saleorderlist/batch_get?from_account=13477516673&to_account=test_13477516673&app_key=opaddeda4b31db9986d&token=cf5b71c060e34f51bb273767742c482c&page_index=1&rows_per_page=20";
            URL url = new URL(requestUrl);

            //打开http连接
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
            httpUrlConn.setDoInput(true);
            httpUrlConn.setRequestMethod("GET");
            httpUrlConn.connect();

            //获得输入
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            //将bufferReader的值给放到buffer里
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            System.out.println( buffer.toString());
            //关闭bufferReader和输入流
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            //断开连接
            httpUrlConn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回字符串

    }

    //测试是否有效
    public static void main(String[] args) {
        httpRequest();

    }

}
package com.australia.common.tool;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Component;
/*import org.apache.http.client.methods.HttpGet;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;*/

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;


@Slf4j
@Component
public class CommonTool {
    private static String URL_API = "http://api.openweathermap.org/data/2.5/weather/";
    private static String API_KEY = "eb8b1a9405e659b2ffc78f0a520b1a46";


    public JSONObject  getWeatherByCityName (String cityName){
        Client client = ClientBuilder.newClient();
        String weatherInformation = client.target(URL_API).queryParam("q", cityName)
                .queryParam("appid", API_KEY)
                .request(MediaType.APPLICATION_JSON).get(String.class);


        log.info(weatherInformation);
        return JSONObject.fromObject(weatherInformation);
    }


    public String  getWeatherByCityNameOne (String cityName){
        /*HttpGet post = null;
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();


            post = new HttpGet(URL_API + "?q=" + cityName + "&appid=" + API_KEY);
            // 构造消息头
            post.setHeader("Content-type", "application/json; charset=utf-8");
            post.setHeader("Connection", "Close");

            HttpResponse response = httpClient.execute(post);

            // 检验返回码
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    log.info(EntityUtils.toString(entity));
                    return EntityUtils.toString(entity);
                } else {
                    log.error("请求 {} 没有返回值 statusCode={}",  statusCode);
                }
            } else {
                log.info("请求 {} 出错 statusCode={}", statusCode);
            }
        } catch (Exception e) {
            log.error("request {} , error {}" , e);
        } finally {
            if (post != null) {
                try {
                    post.releaseConnection();
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }*/


        return null;
    }






}

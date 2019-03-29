package com.weather;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;


@Slf4j
/*@RunWith(SpringRunner.class)
@SpringBootTest(classes = WeatherApplication.class)
@EnableAutoConfiguration
@TestPropertySource(locations={  "classpath:service.properties"})
@Profile("dev")*/
public class MapperTest {

    private String URL_API = "http://api.openweathermap.org/data/2.5/weather/";
    private String API_KEY = "eb8b1a9405e659b2ffc78f0a520b1a46";

    @Test
    public void test() {

        Client client = ClientBuilder.newClient();
        String weatherInformation = client.target(URL_API).queryParam("q", "Melbourne")
                .queryParam("appid", API_KEY)
                .request(MediaType.APPLICATION_JSON).get(String.class);


        log.info(weatherInformation);

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


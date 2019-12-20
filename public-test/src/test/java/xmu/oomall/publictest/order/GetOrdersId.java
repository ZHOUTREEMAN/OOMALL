package xmu.oomall.publictest.order;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import xmu.oomall.domain.Order;
import xmu.oomall.util.JacksonUtil;

import java.math.BigDecimal;
import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GetOrdersId {
    @Value("http://${host}:${port}/orders/{id}")
    String url;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void test1() throws Exception{
        /* 登陆 */

        /* 设置请求头部*/
        URI uri = new URI(url.replace("{id}", "999"));
        HttpHeaders httpHeaders = testRestTemplate.headForHeaders(uri);
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        /*exchange方法模拟HTTP请求*/
        ResponseEntity<String> response = testRestTemplate.exchange(uri, HttpMethod.GET, httpEntity, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());

        /*取得响应体*/
        String body = response.getBody();
        Integer errno = JacksonUtil.parseInteger(body, "errno");
        assertEquals(0, errno);

        /*assert判断*/
        Order order = JacksonUtil.parseObject(body, "data", Order.class);
        assertEquals(999, order.getId());
        assertEquals(9, order.getUserId());
        assertEquals("12345", order.getOrderSn());
        assertEquals("13988888888", order.getMobile());
        assertEquals("请尽快送达", order.getMessage());
        assertEquals(BigDecimal.valueOf(182.43), order.getGoodsPrice());
        assertEquals("123456789", order.getShipSn());
    }

    /*
     * @Author: 24320172203217
     * */
    @Test
    /* 本条order被逻辑删除 */
    public void test2() throws Exception {
        /* 本条order被逻辑删除 */
        /* 设置请求头部*/
        /* 24320172203217 */
        URI uri = new URI(url.replace("{id}", "110"));
        HttpHeaders httpHeaders = testRestTemplate.headForHeaders(uri);
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        /*exchange方法模拟HTTP请求*/
        ResponseEntity<String> response = testRestTemplate.exchange(uri, HttpMethod.GET, httpEntity, String.class);
        /*取得响应体*/
        String body = response.getBody();
        Integer status = JacksonUtil.parseInteger(body, "status");
        assertNotEquals(500,status);
        Order order = JacksonUtil.parseObject(body, "data", Order.class);
        assertNull(order);

    }

    /*
     * @Author: 24320172203217
     * */
    @Test
    /* 本条order被逻辑删除 */
    public void test3() throws Exception {
        URI uri = new URI(url.replace("{id}", "110"));
        HttpHeaders httpHeaders = testRestTemplate.headForHeaders(uri);
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        /*exchange方法模拟HTTP请求*/
        ResponseEntity<String> response = testRestTemplate.exchange(uri, HttpMethod.GET, httpEntity, String.class);
        /*取得响应体*/
        String body = response.getBody();
        Integer status = JacksonUtil.parseInteger(body, "status");
        assertNotEquals(500,status);
        Order order = JacksonUtil.parseObject(body, "data", Order.class);
        assertNull(order);
    }
}

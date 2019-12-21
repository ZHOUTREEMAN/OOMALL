package xmu.oomall.publictest.cart;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import xmu.oomall.domain.CartItem;
import xmu.oomall.publictest.AdtUserAccount;
import xmu.oomall.util.JacksonUtil;


import java.net.URI;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author
 */
@SpringBootTest
public class CartItemsTest {


    @Value("http://${oomall.host}:${oomall.port}/cartService/cartItems")
    String url;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AdtUserAccount adtUserAccount;

    /**
     * @author 24320172203217
     * @modified by ming qiu
     */
    @Test
    public void tc_CartItems_001() throws Exception{

        URI uri = new URI(url);
        adtUserAccount.setUserName("23365454770");
        adtUserAccount.setPassword("123456");
        HttpHeaders httpHeaders = adtUserAccount.createHeaderWithToken();
        assertNotEquals(null, httpHeaders);

        CartItem cartItem = new CartItem();
        cartItem.setBeCheck(false);
        cartItem.setGmtCreate(LocalDateTime.now());
        cartItem.setGmtModified(LocalDateTime.now());
        cartItem.setNumber(5);
        cartItem.setProductId(1);
        /* 设置请求头部 */
        HttpEntity<CartItem> httpEntity  = new HttpEntity<>(cartItem, httpHeaders);

        /* exchange方法模拟HTTP请求 */
        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST,httpEntity, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());

        String body = response.getBody();
        Integer errNo = JacksonUtil.parseInteger(body,"errno");
        assertEquals(0,errNo);

        CartItem responseItem = JacksonUtil.parseObject(body, "data", CartItem.class);
        Integer id = responseItem.getId();
        assertEquals(false, responseItem.getBeCheck() );
        assertEquals(5, responseItem.getNumber());

        httpEntity= new HttpEntity<>(httpHeaders);
        response = restTemplate.exchange(uri, HttpMethod.GET,httpEntity, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());

        body = response.getBody();
        errNo = JacksonUtil.parseInteger(body, "errno");
        assertEquals(0,errNo);
        List<HashMap> items = JacksonUtil.parseObject(body,"data",List.class);
        Boolean found = false;
        for (HashMap item : items){
            if (item.get("id") == String.valueOf(id) ){
                found = true;
                break;
            }
        }
        assertTrue(found);

    }

    /**
     * @author: 24320172203217
     * @throws Exception
     */
    @Test
    public void tc_CartItems_002() throws Exception
    {

        URI uri = new URI(url);
        adtUserAccount.setUserName("10163212949");
        adtUserAccount.setPassword("123456");
        HttpHeaders httpHeaders = adtUserAccount.createHeaderWithToken();
        assertNotEquals(null, httpHeaders);
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        /*exchange方法模拟HTTP请求*/
        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, httpEntity, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());

        String body = response.getBody();
        Integer errNo = JacksonUtil.parseInteger(body, "errNo");
        assertEquals(0, errNo);
        List cartItems = JacksonUtil.parseObject(body,"data", List.class);
        assertEquals(0, cartItems.size()); //用户购物车无东西
    }

}

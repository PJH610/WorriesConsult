import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:spring-mvc.xml"})
@WebAppConfiguration
@ActiveProfiles("dev")
public class testController {

    protected MockMvc mockMvc;

    @Autowired
    WebApplicationContext wac;

    // 这个方法在每个方法执行之前都会执行一遍
    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build(); // 初始化MockMvc对象
    }

    // -------------------------------category表增删改测试-----------------------------------------
    @Test
    public void testString()throws Exception {
        String responseString = mockMvc.perform(
//                    get("/api/user/freeze")
                post("/api/category/add") // 请求的url，请求的方法是get
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED) // 数据的格式
                        .param("name","test3")
        )
                .andDo(print()) // 打印出请求和相应的内容
                .andReturn().getResponse().getContentAsString(); // 将相应的数据转换为字符串
        System.out.println("-----返回的json = " + responseString);
    }

    @Test
    public void testString1()throws Exception {
        String responseString = mockMvc.perform(
//                    get("/api/user/freeze")
                post("/api/category/update") // 请求的url，请求的方法是get
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED) // 数据的格式
                        .param("id","1")
                        .param("name","test1")
        )
                .andDo(print()) // 打印出请求和相应的内容
                .andReturn().getResponse().getContentAsString(); // 将相应的数据转换为字符串
        System.out.println("-----返回的json = " + responseString);
    }

    @Test
    public void testString2()throws Exception {
        String responseString = mockMvc.perform(
//                    get("/api/user/freeze")
                post("/api/category/delete") // 请求的url，请求的方法是get
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED) // 数据的格式
                        .param("id","2")
        )
                .andDo(print()) // 打印出请求和相应的内容
                .andReturn().getResponse().getContentAsString(); // 将相应的数据转换为字符串
        System.out.println("-----返回的json = " + responseString);
    }

    // ----------------------------------- product表增删改测试 -----------------------------------------

    @Test
    public void testString3()throws Exception {
        String responseString = mockMvc.perform(
//                    get("/api/user/freeze")
                post("/api/product/add") // 请求的url，请求的方法是get
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED) // 数据的格式
                        .param("name","test2")
                        .param("subtitle","test1")
                        .param("original_price","10.01")
                        .param("promote_price","10.02")
                        .param("stock","1")
                        .param("sale_count","1")
                        .param("review_count","1")
                        .param("create_date","")
                        .param("category_id","1")
        )
                .andDo(print()) // 打印出请求和相应的内容
                .andReturn().getResponse().getContentAsString(); // 将相应的数据转换为字符串
        System.out.println("-----返回的json = " + responseString);
    }

    @Test
    public void testString4()throws Exception {
        String responseString = mockMvc.perform(
//                    get("/api/user/freeze")
                post("/api/product/update") // 请求的url，请求的方法是get
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED) // 数据的格式
                        .param("id","2")
                        .param("name","test2")
                        .param("subtitle","test12")
                        .param("original_price","10.02")
                        .param("promote_price","10.22")
                        .param("stock","2")
                        .param("sale_count","2")
                        .param("review_count","2")
                        .param("create_date","")
                        .param("category_id","1")
        )
                .andDo(print()) // 打印出请求和相应的内容
                .andReturn().getResponse().getContentAsString(); // 将相应的数据转换为字符串
        System.out.println("-----返回的json = " + responseString);
    }

    @Test
    public void testString5()throws Exception {
        String responseString = mockMvc.perform(
//                    get("/api/user/freeze")
                post("/api/product/delete") // 请求的url，请求的方法是get
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED) // 数据的格式
                        .param("id","2")
        )
                .andDo(print()) // 打印出请求和相应的内容
                .andReturn().getResponse().getContentAsString(); // 将相应的数据转换为字符串
        System.out.println("-----返回的json = " + responseString);
    }
}

package pakius;


import com.pakius.photo.Application;
import org.apache.commons.io.IOUtils;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.FileInputStream;

import static org.hamcrest.Matchers.hasProperty;

import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by Francisco on 17/12/2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest
public class PhotoTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .build();
    }

    @Test
    public void test1UploadPhoto() throws Exception {

        byte[] bytes = IOUtils.toByteArray(new FileInputStream("src/test/resources/img/horse.jpg"));
        MediaType contentType = new MediaType("multipart", "form-data");

        mockMvc.perform(fileUpload("/upload")
                        .file("files", bytes)
                        .contentType(contentType))
                .andExpect(status().isOk())
                .andExpect(view().name("content"))
                .andExpect(model().attribute("photoModel", hasProperty("id", notNullValue())))
                .andExpect(model().attribute("photoModel", hasProperty("url", notNullValue())));

    }

    @Test
    public void test2CropPhoto() throws Exception {

     mockMvc.perform(post("/crop")
             .contentType(MediaType.APPLICATION_FORM_URLENCODED)
             .param("id", "1")
             .param("x1", "")
             .param("y1", "")
             .param("x2", "")
             .param("y2", "")
             .param("width", "")
             .param("height", ""))
                .andExpect(status().isOk())
                .andExpect(view().name("content"))
                .andExpect(model().attribute("photoModel", hasProperty("id", notNullValue())))
                .andExpect(model().attribute("photoModel", hasProperty("url", notNullValue())));
     }

    @Test
    public void test3Delete() throws Exception {
        mockMvc.perform(delete("/delete/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }





}

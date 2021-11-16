package iba.group.diplomAppStore;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

//import iba.group.diplomAppStore.controller.MainPageController;
import iba.group.diplomAppStore.controller.WebConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(WebConfig.class) //arranges for the test to run in the context of a Spring MVC application
public class MainPageControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void testMainPage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("mainPage"))
                .andExpect(content().string(containsString("Welcome!!!")));
    }
}
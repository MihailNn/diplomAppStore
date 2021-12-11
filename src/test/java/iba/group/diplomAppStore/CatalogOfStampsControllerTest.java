package iba.group.diplomAppStore;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

//import iba.group.diplomAppStore.controller.MainPageController;
import iba.group.diplomAppStore.controller.CatalogOfStampsController;
import iba.group.diplomAppStore.controller.WebConfig;
import iba.group.diplomAppStore.repository.StampRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(CatalogOfStampsController.class) //arranges for the test to run in the context of a Spring MVC application
public class CatalogOfStampsControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StampRepository stampRepository;

//    @Test
//    public void testCatalogOfStamps() throws Exception {
//        mockMvc.perform(get("/"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("catalogOfStamps"))
//                .andExpect(content().string(containsString("Catalog of Stamps")));
//    }
}
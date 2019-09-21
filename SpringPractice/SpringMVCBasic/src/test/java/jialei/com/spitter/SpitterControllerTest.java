package jialei.com.spitter;

import jialei.com.spitter.data.SpitterRepository;
import jialei.com.spitter.model.Spitter;
import jialei.com.spitter.web.SpitterController;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.lang.reflect.Field;

import static org.mockito.Matchers.any;

public class SpitterControllerTest {

    @Test
    public void shouldShowRegistration() throws Exception {
        SpitterController controller = new SpitterController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/spitter/register")).
                andExpect(MockMvcResultMatchers.view().name("registerFrom"));
    }

    @Test
    public void shouldProcessRegistration() throws Exception {
        SpitterRepository mockRepository = Mockito.mock(SpitterRepository.class);
        Spitter unsaved = new Spitter("jbauer", "24Hours", "Jack", "Bauer", "test@test.com");
        Mockito.when(mockRepository.save(any(Spitter.class))).thenReturn(unsaved);

        SpitterController controller = new SpitterController();

        Class controllerClass = controller.getClass();
        Field files = controllerClass.getDeclaredField("spitterRepository");
        files.setAccessible(true);
        files.set(controller, mockRepository);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(MockMvcRequestBuilders.post("/spitter/register")
                .param("firstName", "Jack")
                .param("lastName", "Bauer")
                .param("username", "jbauer")
                .param("password", "24Hours"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/spitter/jbauer"));

    }
}

package br.unb.cic.integration;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


//@WebMvcTest
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    private String getContent(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get("src/main/resources/testFiles/" + path)));
    }

    @Test
    public void ServesPistarInterface() throws Exception {
        mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void GeneratePrismDTMC() throws Exception {
        String content = getContent("GoalModel.txt");
        try {
            mockMvc.perform(post("/prism/DTMC").param("content", content))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            Assert.fail();
        }
    }

    @Test
    public void GeneratePrismMDP() throws Exception {
        String content = getContent("GoalModel.txt");
        try {
            mockMvc.perform(post("/prism/MDP").param("content", content))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            Assert.fail();
        }
    }

    @Test
    public void GeneratePARAMFormulas() throws Exception {
        String content = getContent("GoalModel.txt");
        try {
            mockMvc.perform(post("/param/DTMC").param("content", content))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            Assert.fail();
        }
    }

    @Test
    public void GenerateEPMCFormulas() throws Exception {
        String content = getContent("GoalModel.txt");
        try {
            mockMvc.perform(post("/epmc/DTMC").param("content", content))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            Assert.fail();
        }
    }
}


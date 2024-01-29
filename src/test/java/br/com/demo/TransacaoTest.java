package br.com.demo;

import br.com.demo.entities.TransacaoEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.google.gson.Gson;

@SpringBootTest
@AutoConfigureMockMvc
public class TransacaoTest {
    @Autowired
    MockMvc mockMvc;

    //Teste 1 - buscar as transações
    @Test
    public void testeBuscarTransacoes() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/transacao")
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        ).andExpect(
                //Procurando a categoria d primeira transação do array
                MockMvcResultMatchers.jsonPath("$[0].categoria").value("alimentação")
        );
    }

    //Teste 2 - Inserindo transações
    @Test
    public void testeInserirTransacao() throws Exception {
        TransacaoEntity transacao = new TransacaoEntity();
        transacao.setCategoria("esporte");
        transacao.setData("20240506");
        transacao.setPreco(20.00);

        String conteudoTransacao = new Gson().toJson(transacao);
        mockMvc.perform(
                MockMvcRequestBuilders.post("/transacao")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(conteudoTransacao)
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        );
    }

    //Teste 3- Update
    @Test
    public void testeAlterarTransacao() throws Exception {
        TransacaoEntity transacao = new TransacaoEntity();
        //Mudando as informações da transação com id 1
        transacao.setId(1);
        transacao.setData("20240201");
        transacao.setCategoria("alimentacao");
        transacao.setPreco(12.96);

        //Convertendo para json
        String conteudoTransacao = new Gson().toJson(transacao);
        mockMvc.perform(
                MockMvcRequestBuilders.put("/transacao")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(conteudoTransacao)
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        );
    }

    //Teste 4- delete
    @Test
    public void testeApagarTransacao() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.delete("/pessoa?id=999")
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        );
    }

}

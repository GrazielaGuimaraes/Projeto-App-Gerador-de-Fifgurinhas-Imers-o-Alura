package extratores;

import json.JsonParser;
import model.Conteudo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDoIMDB implements ExtratorDeConteudo{

    public List<Conteudo> extraiConteudos (String json){

        // extrair os dados
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);


        List<Conteudo> listaDeConteudos = new ArrayList<>();



        for (Map<String, String> atributos: listaDeAtributos){



            String title = atributos.get("title");
            //Verificar se dá erro aqui
            String urlImagem = atributos.get("image").replaceAll("(@+)(.*).jpg$","$1.jpg");


            Conteudo conteudo = new Conteudo(title, urlImagem);

            listaDeConteudos.add(conteudo);
        }

        return listaDeConteudos;

    }
}

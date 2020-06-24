package com.example.ecoquiz.controll;

import java.util.ArrayList;

public class PartidaController {
    public boolean validarResposta(String alternativa){
        ArrayList<String> respostas = new ArrayList<String>();
        respostas.add("FOTOSSÍNTESE");
        respostas.add("COMPOSTAGEM");
        respostas.add("CONTAMINAÇÃO DAS ÁGUAS");
        respostas.add("OXIGÊNIO");
        respostas.add("OCEANOS");
        respostas.add("ERNEST HAECKEL");
        respostas.add("POPULAÇÃO");
        respostas.add("RHIZOBIUM");
        respostas.add("CADEIA ALIMENTAR");
        respostas.add("AMENSALISMO");
        respostas.add("POLUIÇÃO AMBIENTAL");
        respostas.add("ETOLOGIA");
        respostas.add("HABITAT");
        respostas.add("VACA");
        respostas.add("FATORES ABIÓTICOS");
        respostas.add("ESPÉCIES GENERALISTAS");
        respostas.add("PRODUTORES E DECOMPOSITORES");
        respostas.add("CONSUMIDOR SECUNDÁRIO");
        respostas.add("AS AVES PISCÍVORAS");
        respostas.add("NATURAL E INTENSIFICADO POR AÇÕES HUMANAS");


        if(respostas.contains(alternativa)){
            return true;
        } else{
            return false;
        }

}
}

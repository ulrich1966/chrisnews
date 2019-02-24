package de.auli.chrisnews.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

import de.auli.chrisnews.model.Result;

/**
 * Wir erzeugen eine com.fasterxml.jackson.databind.ObjectMapper Instanz und configuriern sie ein bisschen,
 * so dass nicht bei jeder kleien Unstimmgkeit gemeckert wird.
 * Die klasse bietet eine Methode an, die aus einem Rohdaten JSON eine Map<String, Object> generiert, worin
 * die Daten als Schluessel - Wertpaare hintelegt sind und eine weiterer Mehode, die uns die im
 * Model erstellten Klassen aus den JSON - Rohdaten erzeugt. Wenn das alles funktioniert und wir
 * nichts falsch gmacht haben, dann sollte sich darin eine Liste mit Artikeln Vom Java-Typ
 * de.auli.chrisnews.model.Article befinden. Dessen Daten koennen dann leicht ueber die Getter abgefagt werden
 * und in diem Fall den dafuer vorgesehenen View-Elementen (TextView, ImageView etc.)zugewiesen werden.
 */
public class MapperService {
    ObjectMapper mapper = new ObjectMapper();

    public MapperService() {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
    }

    public Map<String, Object> jsonToMap(String json) throws Exception {
        Map<String,Object> result = mapper.readValue(json, HashMap.class);
        return result;
    }

    // Hier passiert die Magic ... Ein JSON-String geht rein und ein komplettes Model kommt raus.
    public Result unmarshall(String json) throws Exception {
        //AnnotationIntrospector introspector = new JaxbAnnotationIntrospector(mapper.getTypeFactory());
        //mapper.setAnnotationIntrospector(introspector);
        Result model = mapper.readValue(json, Result.class);
        return model;
    }

}

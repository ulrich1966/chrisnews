package de.auli.chrisnews;


import org.junit.Test;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import de.auli.chrisnews.model.RootMod;
import de.auli.chrisnews.service.MapperService;

public class JsonParseTest {
    private static final String TAG = JsonParseTest.class.getSimpleName();
    @Test
    /**
     * Nachschauen, wo die aktuelle Klasse liegt. In deren Pojektpfad nach einen Ordner
     * namens 'temp' suchen, denn darin wollen wir die Dummydaten speichern.
     * Zum einen gibt es darin eine formatierte JSON-Datei die als Liste ausgelesen und ausgegeben
     * werden kann, zum anderen ist eine Datei mit den vom Server erhaltenen Rohdaten hinterleg, um
     * das Unmarshallen zu testen.
     */
    public void test() throws Exception {
        final URL resource = JsonParseTest.class.getResource("");
        final Path classPath = Paths.get(resource.toURI());
        final Path dummyDataPath = classPath.getRoot().resolveSibling(Paths.get(new File("temp").toURI()));

        // Huebsche Liste mit Daten vom Server
        final List<String> lines = Files.readAllLines(dummyDataPath.resolve("news.json"));
        // Die gleichen Daten als Rohdatendatei ohne Zeilenumbrueche fuer den Unmarshaller-Service
        final byte[] bytes = Files.readAllBytes(dummyDataPath.resolve("plainresp.json"));

        // Aus dem ByteArr einen Sting machen und ...
        String jsonResult = new String(bytes);
        // ... mal gucken was dirn ist
        LogMeToo.debug(jsonResult);

        MapperService service = new MapperService();
        // Den JSON-String in POJOs (DAO) umwandeln
        final RootMod result = service.unmarshall(jsonResult);

        if (result != null){
            LogMeToo.debug(result.toString());
        } else {
            LogMeToo.debug("No results");
        }

    }
}

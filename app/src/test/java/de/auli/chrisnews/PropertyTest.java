package de.auli.chrisnews;


import org.junit.Test;

import de.auli.chrisnews.service.PropertyService;

public class PropertyTest {
    private static final String TAG = PropertyTest.class.getSimpleName();
    @Test
    /**
     * Nachschauen, wo die aktuelle Klasse liegt. In deren Pojektpfad nach einen Ordner
     * namens 'temp' suchen, denn darin wollen wir die Dummydaten speichern.
     * Zum einen gibt es darin eine formatierte JSON-€Datei die als Liste ausgelesen und ausgegeben
     * werden kann, zum anderen ist eine Datei mit den vom Server erhaltenen Rohdaten hinterleg, um
     * das Unmarshallen zu testen.
     */
    public void test() throws Exception {
        String news = PropertyService.getInstance().get("news");
        System.out.println(news);
        String hash = PropertyService.getInstance().get("hash");
        System.out.println(hash);

    }
}

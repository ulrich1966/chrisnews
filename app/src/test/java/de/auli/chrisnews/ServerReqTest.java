package de.auli.chrisnews;


import org.junit.Test;

import de.auli.chrisnews.model.Result;
import de.auli.chrisnews.service.HttpRequestService;

public class ServerReqTest {
    private static final String TAG = ServerReqTest.class.getSimpleName();
    @Test
    /**
     * Den Server nach Daten abfragen ...
     */
    public void test() throws Exception {
        HttpRequestService service = new HttpRequestService();
        final Result newsResult = service.getNews();
        System.out.println(newsResult.toString());
    }
}

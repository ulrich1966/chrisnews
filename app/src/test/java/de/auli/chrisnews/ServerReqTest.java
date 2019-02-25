package de.auli.chrisnews;


import org.junit.Test;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import de.auli.chrisnews.model.Result;
import de.auli.chrisnews.service.HttpRequestServie;
import de.auli.chrisnews.service.MapperService;

public class ServerReqTest {
    private static final String TAG = ServerReqTest.class.getSimpleName();
    @Test
    /**
     * Den Server nach Daten abfragen ...
     */
    public void test() throws Exception {
        HttpRequestServie service = new HttpRequestServie();
        final Result newsResult = service.getNews();
        System.out.println(newsResult.toString());
    }
}

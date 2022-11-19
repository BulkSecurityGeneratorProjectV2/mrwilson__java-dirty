package uk.co.probablyfine.dirty.util;

import uk.co.probablyfine.dirty.Store;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class StoreFactory {

    public static <T> Store<T> createStore(Class<T> klass) throws IOException {
        File file = Files.createTempFile("java-dirty-", ".db").toFile();
        file.deleteOnExit();
        return Store.of(klass).from(file.getCanonicalPath());
    }
}

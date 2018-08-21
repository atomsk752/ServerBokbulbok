package org.atomsk;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class Bokbulbok {

    private ArrayList<String> fNames;
    public Bokbulbok() {
        File folder = new File("C:\\zzz\\img");
        fNames = new ArrayList<>();
        for (String fname:folder.list()
        ) {
            fNames.add(fname);
        }
        Collections.shuffle(fNames);
    }

    public String getName(){

        return fNames.remove(0);
    }
}
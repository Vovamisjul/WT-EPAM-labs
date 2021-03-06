package com.vovamisjul.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOSystem {
    public static CommunalServices loadFromFile() throws IOException {
        var json = new StringBuilder();
        try(FileReader reader = new FileReader("file.txt"))
        {
            int c;
            while((c=reader.read())!=-1){
                json.append((char)c);
            }
        }
        return new Gson().fromJson(json.toString(), CommunalServices.class);
    }
    public static void saveToFile(CommunalServices communalServices) throws IOException {
        try(FileWriter writer = new FileWriter("file.txt", false))
        {
            writer.write(new GsonBuilder().enableComplexMapKeySerialization().create().toJson(communalServices));
            writer.flush();
        }
    }
}

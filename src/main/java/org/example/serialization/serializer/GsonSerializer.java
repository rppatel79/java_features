package org.example.serialization.serializer;

import com.google.gson.Gson;
import org.example.serialization.dao.Person;

import java.io.IOException;

public class GsonSerializer implements Serializer
{
    @Override
    public Person deserialize(String serializedFile) throws IOException {
        Gson gson = new Gson();
        return gson.fromJson(serializedFile,Person.class);
    }

    @Override
    public String serialize(Person sample) throws IOException {
        Gson gson = new Gson();
        return gson.toJson(sample);
    }
}

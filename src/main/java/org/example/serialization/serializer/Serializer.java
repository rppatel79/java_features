package org.example.serialization.serializer;

import org.example.serialization.dao.Person;

import java.io.IOException;

public interface Serializer {
    public Person deserialize(String serializedFile) throws IOException;

    public String serialize(Person sample) throws IOException;
}

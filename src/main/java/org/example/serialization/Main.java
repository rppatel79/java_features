package org.example.serialization;

import org.example.serialization.dao.Person;
import org.example.serialization.serializer.*;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        personTest();
    }

    @Test
    public static void personTest() throws IOException {
        Person person = new Person("John","Smith");

        List<Serializer> serializers = Arrays.asList(new GsonSerializer(),new JacksonSerializer(), new JavaSerializer());
        for (Serializer serializer : serializers)
        {
            String personStr = serializer.serialize(person);
            Person person2 = serializer.deserialize(personStr);

            assert (person.equals(person2));
        }
    }
}
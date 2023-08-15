package org.example.serialization.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.serialization.dao.Person;

import java.io.IOException;

public class JacksonSerializer implements Serializer
{

    @Override
    public String serialize(Person person) throws IOException {
        return new ObjectMapper().writeValueAsString(person);
    }

    @Override
    public Person deserialize(String serializedPerson) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(serializedPerson, Person.class);
    }
}

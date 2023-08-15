package org.example.serialization.serializer;

import org.example.serialization.dao.Person;

import java.io.*;
import java.util.Base64;

public class JavaSerializer implements Serializer
{
    @Override
    public Person deserialize(String serializedFile) throws IOException {
        try(ObjectInputStream oInputStream = new ObjectInputStream(new ByteArrayInputStream(Base64.getDecoder().decode(serializedFile))))
        {
            return (Person) oInputStream.readObject();
        }
        catch (ClassNotFoundException ex)
        {
            throw new IOException(ex);
        }
    }

    @Override
    public String serialize(Person sample) throws IOException {
        try(ByteArrayOutputStream bos =new ByteArrayOutputStream())
        {
            try (ObjectOutputStream os = new ObjectOutputStream(bos))
            {
                os.writeObject(sample);
                return Base64.getEncoder().encodeToString(bos.toByteArray());
            }
        }
    }
}

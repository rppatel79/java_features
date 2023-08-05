package org.example.serialization;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File serializedFile = new File("serialized_file.io");

        Person sample = new Person("John","john.smith@gmail.com",false);
        Person.setDefaultEmail("DefaultValue1");

        System.out.println(sample);
        serialize(sample,serializedFile);

        Person.setDefaultEmail("DefaultValue2");
        Person sample2 = deserialize(serializedFile);
        System.out.println(sample2);
    }

    private static Person deserialize(File serializedFile) throws IOException, ClassNotFoundException {
        try(FileInputStream fis = new FileInputStream(serializedFile))
        {
            try(ObjectInputStream ois = new ObjectInputStream(fis))
            {
                return (Person) ois.readObject();
            }
        }
    }

    private static void serialize(Person sample, File serializedFile) throws IOException {
        try(FileOutputStream fos = new FileOutputStream(serializedFile))
        {
            try(ObjectOutputStream oos = new ObjectOutputStream(fos))
            {
                oos.writeObject(sample);
            }
        }
    }




    private static class Person implements Serializable
    {
        @Serial
        private static final long serialVersionUID = 1L;
        private static String DEFAULT_EMAIL_VALUE;
        private final String name;
        private final String email;
        private final transient Boolean savedToDb;

        public Person(String name, String email, Boolean savedToDb) {
            this.name = name;
            this.email = email;
            this.savedToDb = savedToDb;
        }

        static void setDefaultEmail(String defaultVal)
        {
            DEFAULT_EMAIL_VALUE=defaultVal;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    ", savedToDb=" + savedToDb +
                    ", DEFAULT_EMAIL_VALUE="+DEFAULT_EMAIL_VALUE+
                    '}';
        }
    }
}

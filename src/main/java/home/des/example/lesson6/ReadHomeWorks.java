package home.des.example.lesson6;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.FileSystems;

public class ReadHomeWorks {

    public static void main(String[] args) {

        File homeworkPath = new File("data" + FileSystems.getDefault().getSeparator() + "homework");
        String[] files = homeworkPath.list();

        assert files != null;
        for (String file : files) {
            System.out.println(file);
            String[] splitFile = file.split("\\.");
            if (!splitFile[1].equals("class")){
                throw new RuntimeException(file, new Exception("File isn't .class"));
            }

            try {
                Constructor<Person> constructor = Person.class.getConstructor(String.class, int.class, int.class);
                Person person1 = constructor.newInstance("Bob", 25, 180);
                System.out.printf("name: %s, age: %s, height: %s \n\n",
                        Person.class.getMethod("getName").invoke(person1),
                        Person.class.getMethod("getAge").invoke(person1),
                        Person.class.getMethod("getHeight").invoke(person1));
            } catch (NoSuchMethodException | InstantiationException
                    | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }

        }
    }

}

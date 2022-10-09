package home.des.example.lesson6;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
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
                Class readClass = URLClassLoader.newInstance(new URL[]{homeworkPath.toURL()}).loadClass(splitFile[0]);
                Constructor constructor = readClass.getConstructor(String.class, int.class, int.class);
                Object chekObject = constructor.newInstance("Bob", 25, 180);
                System.out.printf("name: %s, age: %s, height: %s \n\n",
                        readClass.getMethod("getName").invoke(chekObject),
                        readClass.getMethod("getAge").invoke(chekObject),
                        readClass.getMethod("getHeight").invoke(chekObject));
            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException
                    | InvocationTargetException | MalformedURLException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }

}

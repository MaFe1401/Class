import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Magia {
    public static void main(String[] args){
        User u = new User("Marc","Ferré");
        System.out.println("Usuario: "+u.GetName()+" "+u.GetSurname());

        System.out.println("class.getName: "+u.getClass().getName());
        System.out.println("class.getSimpleName :"+u.getClass().getSimpleName());
        System.out.println("package: "+u.getClass().getPackage().getName());
        System.out.println("Annotacions: "+ Arrays.toString(u.getClass().getAnnotations()));
        System.out.println("===============================================");

        try{
            Class c= Class.forName("User");
            User user2 = (User) c.newInstance();
            user2.SetName("Pepe");
            user2.SetSurname("Gotera");
            System.out.println(user2.toString());
            System.out.println("============================");

            for(Field f: c.getDeclaredFields()){
                System.out.println(f.getName());
            }
            System.out.println("===========================");
            for(Method m:c.getDeclaredMethods()){
                System.out.println(m.getName());
            }
            System.out.println("[GetNameInvoke]===========================");
            Method m=c.getDeclaredMethod("GetName",null);
            String res=(String)m.invoke(user2, null);
            System.out.println(res);
            System.out.println("[SetNameInvoke]===========================");
            Method m2 = c.getDeclaredMethod("SetName", String.class);
            m2.invoke(user2,"pepiño");
            System.out.println(user2.toString());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}

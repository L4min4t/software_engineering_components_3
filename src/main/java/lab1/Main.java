package lab1;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) throws Exception {
        //#1
        Date day = new Date(12, 2, 2022);
        System.out.println("Example of using the first class constructor:\n" + day);

        RecordBook rec = new RecordBook("Name", "Surname", "Patronymic", "+380668523654", 2, 2, 2222);
        System.out.println("Example of using the second class constructor:\n" + rec + "\n\n");


        //#2
        System.out.print("Call method with annotation \"CallMethod\":\t");
        for(Method method: rec.getClass().getMethods()){
            if (method.isAnnotationPresent(CallMethod.class)) {
                System.out.println(method.invoke(rec));
            }
        }
        System.out.println("\n\n");


        //#3
        System.out.println("Class name:\t" + rec.getClass().getName());
        System.out.println("Constructors with parameters:");
        for(Constructor constructor: day.getClass().getDeclaredConstructors()){
            if(constructor.getParameterCount() > 0){
                System.out.println(constructor);
            }
        }
        String modifier = Modifier.toString(rec.getClass().getModifiers());
        System.out.println("Class modifiers:\t" + modifier + "\n\n");


        //#4
        RecordBook entity = new RecordBook("Kolia", "Pupkin", "Vasilievich", "+380961589623", 20, 11, 2002);
        IRecordBook proxy = (IRecordBook) RecordBookProxy.newProxyInstance(entity);
        System.out.println("Proxy using:\nTry call 'getter':\t" + proxy.getName());
        try{
            System.out.println("Try to call 'setter':\t");
            proxy.setName("Vasia");
        } catch (Error e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Try call common class method:\t" + proxy.daysToBirthday());
    }
}

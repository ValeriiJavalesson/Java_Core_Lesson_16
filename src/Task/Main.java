package Task;

import java.lang.reflect.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Fruits f1 = new Fruits("apple", "red", 22);

        Class fruitclass = f1.getClass();
        System.out.println("Ім’я класу: " + fruitclass.getName());
        System.out.println("Ім’я класу(simple): " + fruitclass.getSimpleName());
        Class superFruits = fruitclass.getSuperclass();
        System.out.println("Ім’я супер класу: " + superFruits);
        System.out.println("Ім’я пакету: " + fruitclass.getPackage());
        System.out.println();


        System.out.println("Інтерфейси: " + Arrays.toString(fruitclass.getInterfaces()));
        System.out.println();

        int modifiers = fruitclass.getModifiers();
        System.out.println("Модифікатори: " + Modifier.toString(modifiers));
        System.out.println("Чи є модифікатор final? = " + Modifier.isFinal(modifiers));
        System.out.println("Чи є модифікатор public? = " + Modifier.isPublic(modifiers));
        System.out.println();

        System.out.println("Public поля:");
        Field[] fields = fruitclass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("Всього полів: " + fields.length);
        System.out.println();

        System.out.println("Всі поля:");
        Field[] allFields = fruitclass.getDeclaredFields();
        for (Field allField : allFields) {
            System.out.println(allField);
        }
        System.out.println("Всього полів: " + allFields.length);
        System.out.println();
        System.out.println("Конструктори:");
        Constructor<Fruits>[] allConstructors = fruitclass.getConstructors();
        for (Constructor<Fruits> singleConstructor : allConstructors) {
            System.out.println(singleConstructor);
        }
        System.out.println("Всього конструкторів: " + allConstructors.length);
        System.out.println();

        Constructor<Fruits> singleConstructor = allConstructors[2];
        Class<?>[] parameterTypes = singleConstructor.getParameterTypes();
        System.out.println("Типи параметрів окремого конструктора:");
        for (Class<?> classParameter : parameterTypes) {
            System.out.print("[" + classParameter + "]");
        }
        System.out.println();
        System.out.println();
        System.out.println("Використовуючи рефлексію, додамо нового об’єкта" +
                "та змінимо його поля, а також змінимо поля вже існуючого.");
        singleConstructor = fruitclass.getConstructor(String.class, int.class);
        Fruits newInstanceFruit = singleConstructor.newInstance("Orange", 77);
        System.out.println("Новий фрукт = " + newInstanceFruit);
        System.out.println("Був в наявності фрукт = " + f1);
        Field amountField = fruitclass.getField("amount");
        amountField.set(newInstanceFruit, 33);
        amountField.set(f1, 43);
        System.out.println(newInstanceFruit.getType() + " тепер має кількість " + newInstanceFruit.getAmount());
        System.out.println(f1.getType() + " тепер має кількість " + f1.getAmount());
        System.out.println();

        System.out.println("Використовуючи рефлексію, виконаємо метод, який додає кількість фруктів:");
        Method fruitMethod = fruitclass.getMethod("sum", int.class);
        fruitMethod.invoke(newInstanceFruit, 180);
        System.out.println(newInstanceFruit);
        System.out.println();

        System.out.println("Виконаємо ще один метод, який змінює тип фрукта та його кількість:");
        fruitMethod = fruitclass.getMethod("setTypeAndAmount", String.class, int.class);
        fruitMethod.invoke(newInstanceFruit, "Kiwi", 166);
        System.out.println(newInstanceFruit);
        System.out.println();
    }
}

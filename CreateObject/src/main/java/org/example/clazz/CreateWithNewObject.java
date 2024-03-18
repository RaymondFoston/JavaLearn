package org.example.clazz;

/**
 * Hello world!
 *
 */
public class CreateWithNewObject {
    // Main method
    public static void main(String[ ] args) {
        Include_Static_Constructor_method_class.staticFunction();
        // function(); This would output an error
        System.out.println("=====================");
        // Create an object of MyClass
        Include_Static_Constructor_method_class myClass = new Include_Static_Constructor_method_class();
        // Call the public method
        myClass.function();

    }
}

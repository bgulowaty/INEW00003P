package pl.edu.pwr.bgulowaty.args;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.lang.reflect.Constructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pl.edu.pwr.bgulowaty.StudentsIndex;

class StudentsIndexTest{

    private StudentsIndex index;
    private String givenIndex = "252782";

    @BeforeEach
    void setUp(){index = StudentsIndex.of(givenIndex);}

    @Test
    void givenRegularIndex_CreateCorrectObject(){

        assertTrue(index instanceof StudentsIndex);
    }

    @Test
    void givenTwoObjects_CheckMethodEquals() {

        String falseIndex = "252783";

        /*Getting through a private constructor*/
        /*Declaring an object of class StudentsIndex Mechanically*/
        /*Probably not needed*/
        try {
            //Class<?> classTest = Class.forName("pl.edu.pwr.bgulowaty.StudentsIndex");
            Constructor<StudentsIndex> constructorTest = StudentsIndex.class
                .getDeclaredConstructor(String.class);
            constructorTest.setAccessible(true);
            StudentsIndex studentIndexTest = constructorTest.newInstance(givenIndex);

            assertEquals(givenIndex,studentIndexTest.getIndex());

        } catch (Exception e) {
            System.out.println("Test: givenTwoObjects_CheckMethodEquals is not working. Error: " + e.toString());
        }


        assertTrue(givenIndex.equals(index.getIndex()));

        /*Overrode method equals?*/

        assertTrue(index.equals(StudentsIndex.of(givenIndex)));

        assertFalse(index.equals(StudentsIndex.of(falseIndex)));


    }
}


//      import java.lang.reflect.InvocationTargetException;
//      import java.rmi.activation.Activator;
//      import org.junit.jupiter.api.BeforeEach;

//        } catch (InstantiationException e) {
//            System.out.println(e.toString());
//        } catch (IllegalAccessException e) {
//            System.out.println(e.toString());
//        } catch (InvocationTargetException e) {
//            System.out.println(e.toString());
//        }

//        Class<?> classTest = Class.forName("pl.edu.pwr.bgulowaty.StudentsIndex");
//        Constructor<?> constructorTest = classTest.getConstructor(String.class);
//        Object studentIndexTest = constructorTest.newInstance(studentIndex);
//
//        System.out.println(studentIndex);
//        System.out.println(studentIndexTest.getIndex());
//        assertEquals(studentIndex,studentIndexTest.getIndex());



//    private StudentsIndex CreateInstance(){
//        // Get Class instance
//        Class<?> clazz = Class.forName("pl.edu.pwr.bgulowaty.StudentsIndex");
//
//        // Get the private constructor.
//        Constructor<?> cons = clazz.getDeclaredConstructor();
//
//        // Since it is private, make it accessible.
//        cons.setAccessible(true);
//
//        // Create new object.
//        Object obj = cons.newInstance();
//    }

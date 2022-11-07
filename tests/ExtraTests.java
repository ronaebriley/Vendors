import org.junit.jupiter.api.*;
import java.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExtraTests {

    //static Vendor v = new Vendor(1,2);
    Vendor v;

    @BeforeEach
    void setUp(){
        System.out.println("SetUP");
        v = new Vendor (1,2);
    }
    @BeforeAll
    static void init(){
        System.out.println("origin");
    }


    // Write a test that adds a random value to balance
    //check that the balance is updated properly
    @RepeatedTest(5)
    void addRandomBalanceTester(){
        Random rand = new Random();
        int randomNum = rand.nextInt(101);
        v.addMoney(randomNum);
        assertEquals(randomNum, v.getBalance());
    }

    @Test
    void test1(){
        System.out.println("Test 1");
        v.addMoney(2.0);
        //v.getBalance();
        assertEquals(2.0, v.getBalance());
    }

    @Test
    void test2(){
        System.out.println("Test 2");
        //v.getBalance();
        v.addMoney(2.0);
        v.select("Gum");
        assertEquals(1.5, v.getBalance());
    }


}

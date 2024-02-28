package org.example;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalculatorTest {

    private int result = 0;

    @BeforeAll
    void setupClass(){
        System.out.println("Before all is called");
    }
    @BeforeEach
    void setupMethod(){
        System.out.println("Before each is called");
    }
    @AfterEach
    void cleanMethod(){
        System.out.println("After each is called");
    }
    @AfterAll
    void cleanClass() {
        System.out.println("After all is called");
    }

    @Test
    @Order(1)
    void testTambah() {
        int a = 10;
        int b = 7;

        Calculator calculator = new Calculator(a, b);
        result = calculator.tambah();

        Assertions.assertEquals(17, result);
    }

    @Test
    @Order(2)
    void testKurang() {
        int b = 5;
        Calculator calculator = new Calculator(result,b);
        result = calculator.kurang();

        Assertions.assertEquals(12,result);
    }

}
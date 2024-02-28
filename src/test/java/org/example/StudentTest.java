package org.example;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentTest {
    private List<Student> students;

    @BeforeAll
    static void initClass() {
        // InitClass: create an ArrayList of Student objects
        System.out.println("Before is a called");
    }

    @AfterAll
    static void cleanClass() {
        // CleanClass: clear the ArrayList
        System.out.println("After is a callled...");
    }

    @BeforeEach
    void initMethod() {
        // InitMethod: create a Student object and add it to the list
        System.out.println("Before each is called");
        students = new ArrayList<>();
        students.add(new Student("John", 20));
    }

    @AfterEach
    void cleanMethod() {
        // CleanMethod: clear the list
        System.out.println("After each is called");
        students.clear();
    }

    @Test
    void testCreateStudent() {
        // TestMethod 1: testDataCreation
        System.out.println("Testing student data creation...");
        Assertions.assertEquals(1, students.size());
        Assertions.assertEquals("Joko", students.get(0).getName());
        Assertions.assertEquals(20, students.get(0).getAge());
    }

    @Test
    void testEnrollCourse() {
        // TestMethod 2: test student enrollment
        System.out.println("Testing student course enrollment...");
        students.get(0).enrollCourse("Tata Boga");
        Assertions.assertTrue(students.get(0).getEnrolledCourses().contains("Tata Boga"));
    }

    @Test
    void testSetAndGetGrade() {
        // TestMethod 3: test student grade
        System.out.println("Testing student grade...");
        students.get(0).setGrade("Tata Boga", "A");
        Assertions.assertEquals("C", students.get(0).getGrade("Tata Boga"));
    }
}

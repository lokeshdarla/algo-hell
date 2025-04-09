class A {
    A() {
        System.out.println("Constructor of A");
    }
}

class B extends A {
    B() {
        System.out.println("Constructor of B");
    }
}

class C extends B {
    C() {
        System.out.println("Constructor of C");
    }
}

public class CustomClass {
    public static void main(String[] args) {
        C obj = new C(); // Creating an object of class C
        StringBuilder sb=new StringBuilder("Hello");
        sb.reverse();
        StringBuffer sf=new StringBuffer("Hello");
        sb.reverse();
    }
}

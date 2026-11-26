package com.person;

/*
    private - accessible only within the class
    default - accessible within the package
    protected - accessible within the package and by subclasses
    public - accessible from anywhere

*/

public class AccessModifires {
    private int id;
    String name;
    protected String address;
    public long phone;

    public void m1(){
        System.out.println("AccessModifires.m1()");
    }

    private void m2(){
        System.out.println("AccessModifires.m2()");
    }

    protected void m3(){
        System.out.println("AccessModifires.m3()");
    }

    void m4(){
        System.out.println("AccessModifires.m4()");
    }

    public static void main(String[] args) {
        AccessModifires obj = new AccessModifires();
        obj.id = 101;
        obj.name = "vishal kadam";
        obj.address = "Pune";
        obj.phone = 1234567890L;

        System.out.println("ID: " + obj.id);
        System.out.println("Name: " + obj.name);
        System.out.println("Address: " + obj.address);
        System.out.println("Phone: " + obj.phone);
    }

    
}

class Test{
    public static void main(String[] args) {
        AccessModifires obj = new AccessModifires();
        // obj.id = 101;
        obj.name ="vishal kadam";
        System.out.println("Name: " + obj.name);
        obj.address = "Pune";//address is protected member, accessible within the package
        System.out.println("Address: " + obj.address);
        obj.phone = 1234567890L;
        System.out.println("Phone: " + obj.phone);
    }
}
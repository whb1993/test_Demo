package com.demo1.day12;

/**
 * Created by whb on 2017/6/21.
 */
public class CloneTest {
    public static void main(String[] args) {
        User user = new User(1);
        try {
            User user1 = user.clone();
              System.out.println(user == user1);
            System.out.println(user.hashCode()+"**"+user1.hashCode());
            System.out.println(user.address == user1.address);
            System.out.println(user.age+"**"+user1.age);
            user.address.st1 = "222";
            System.out.println( user1.address.st1);

            Address a = new Address(1, "a");
//            Address b =


        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
class Address implements Cloneable{
    int i1 ;
    String st1;
    public Address(int i,String t){
        this.i1 = i;
        this.st1 =t;
    }
}

class User implements Cloneable{
    int age;
    Address address;
    User(int age){
        this.age = age;
        address =new Address(1,"haha");
    }

    @Override
    protected User clone() throws CloneNotSupportedException {
        return (User) super.clone();
    }
}
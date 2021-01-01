class Person{
    int rollno;
    String name;

    public void setPersion(int no,String name){
        this.rollno = no;
        this.name = name;
    }

    public String toString(){
        return this.rollno + " " + this.name;
    }
}

class stringuse{
    public static void main(String[] args){
        Person person = new Person();
        person.setPersion(12, "Shubham");
        System.out.println(person);
    }
}
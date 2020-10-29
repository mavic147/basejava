package patterns.Decorator;

public class Person implements PersonInterface {
    String name;
    String gender;

    public Person(String name, String gender) {
        this.name = name;
        this.gender = gender; //как сделать так, чтобы в зависимости от пола можно было выбрать различное действие?
    }

    @Override
    public void dress() {
        System.out.println(this.name + " " + "is dressing");
    }
}

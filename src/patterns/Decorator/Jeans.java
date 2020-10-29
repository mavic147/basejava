package patterns.Decorator;

public class Jeans extends Decorator {
    public Jeans(PersonInterface person) {
        super(person);
    }

    @Override
    public void dress() {
        person.dress();
        System.out.println("He/She is putting jeans on.");
    }
}

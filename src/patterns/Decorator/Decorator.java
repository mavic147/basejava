package patterns.Decorator;

public abstract class Decorator implements PersonInterface{
    PersonInterface person;

    public Decorator(PersonInterface person) {
        this.person = person;
    }
}

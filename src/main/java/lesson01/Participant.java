package lesson01;

public interface Participant extends Jumper, Runner {
    String getName();
    boolean doAction(Hurdle hurdle);
}

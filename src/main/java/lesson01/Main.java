package lesson01;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Random r = new Random();
        Hurdle[] hurdles = {new Wall(r.nextInt(5)),
                new RunningTrack(r.nextInt(100)),
                new Wall(r.nextInt(6)),
                new RunningTrack(r.nextInt(100)),
                new Wall(r.nextInt(6)),
                new Wall(r.nextInt(6)),
                new Wall(r.nextInt(6))};

        Robot robot1 = new Robot("Topo", 20, 1);
        Robot robot2 = new Robot("Robocop", 100, 10);
        Cat cat1 = new Cat("Murzik", 50, 2);
        Human human1 = new Human("Oleg", 200, 3);
        Robot robot3 = new Robot("Terminator", 500, 2);
        Cat cat2 = new Cat("Puhlyak", 30, 1);
        Robot robot4 = new Robot("Marsohod", 50, 0);

        Participant[] participants = {robot1, robot2, cat1, human1, robot3, cat2, robot4};

        printHurdles(hurdles);
        printParticipants(participants);

        boolean success;
        int faultIndex;

        for (int i = 0; i < participants.length; i++) {
            System.out.println(participants[i].getName() + " начинает преодолевать препятствия!");
            success = true;
            faultIndex = 1;
            for (int j = 0; j < hurdles.length; j++) {
                Thread.sleep(600);
                success = participants[i].doAction(hurdles[j]);
                if (!success) {
                    faultIndex = j+1;
                    break;
                }
            }
            System.out.println();
            printResult(participants[i], success, faultIndex);

        }


    }


    public static void printResult(Participant participant, boolean success, int faultIndex) throws InterruptedException {
        Thread.sleep(600);
        if (success) {
            System.out.println(participant.getName() + " успешно преодолел все препятствия!");
        } else {
            System.out.println(participant.getName() + " не смог преодолеть препятствие номер " + faultIndex);
        }
        System.out.println();
    }

    public static void printHurdles (Hurdle[] hurdles) {
        System.out.println("Hurdles: ");
        for (int i = 0; i < hurdles.length; i++) {
            System.out.println(hurdles[i].toString());
        }
        System.out.println();
    }

    public static void printParticipants (Participant[] participants) {
        System.out.println("Participants: ");
        for (int i = 0; i < participants.length; i++) {
            System.out.println(participants[i].toString());
        }
        System.out.println();
    }

}
package lesson01;

public class Cat implements Participant {
    private final String name;
    private final int runningAbility;
    private final int jumpingAbility;

    public Cat(String name, int runningAbility, int jumpingAbility) {
        this.name = name;
        this.runningAbility = Math.max(runningAbility, 0);
        this.jumpingAbility = Math.max(jumpingAbility, 0);
    }

    @Override
    public boolean jump(Wall wall) {
        if (jumpingAbility >= wall.getHeight()) {
            System.out.println("Кот " + name + " успешно перепрыгнул стену!");
            return true;
        } else {
            System.out.println("Кот " + name + " не смог перепрыгнуть стену...");
            return false;
        }
    }

    @Override
    public boolean run(RunningTrack track) {
        if (runningAbility >= track.getLength()) {
            System.out.println("Кот " + name + " успешно пробежал трек!");
            return true;
        } else {
            System.out.println("Кот " + name + " не смог пробежать трек...");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", runningAbility=" + runningAbility +
                ", jumpingAbility=" + jumpingAbility +
                '}';
    }

    @Override
    public String getName() {
        return name;
    }


    public boolean doAction(Wall wall) {
        return jump(wall);
    }

    public boolean doAction(RunningTrack track) {
        return run(track);
    }

    @Override
    public boolean doAction(Hurdle hurdle) {
        if (hurdle instanceof Wall) {
            return jump ((Wall) hurdle);
        } else {
            if (hurdle instanceof RunningTrack) {
                return run ((RunningTrack) hurdle);
            } else {
                return false;
            }
        }
    }
}


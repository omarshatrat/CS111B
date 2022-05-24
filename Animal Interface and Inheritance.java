import java.util.*;

class Main{

    public static void main(String args[]) {

        ArrayList<iAnimal> al = new ArrayList<iAnimal>();

        System.out.println("How many snakes do you want to instantiate?");
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt(); //total number of snakes to be generated

        for (int i = 0; i < total; i++) {
            System.out.println("ID of snake " + (i + 1) + ": ");
            int id = sc.nextInt(); 
            Snake s = new Snake(id); //creates instance w/ given id
            if (checkSnakeId(al, s)) {
                System.out.println("A snake with this ID already exists.");
            } else {
                al.add(s);
            }
        }

        for (int i = 0; i < al.size(); i++) {
            System.out.println(al.get(i));
        }

        List<iAnimal> list = new ArrayList<iAnimal>();

        System.out.println("How many penguins would you like to instantiate?");
        total = sc.nextInt();

        for (int i = 0; i < total; i++) {
            System.out.println("ID of Penguin " + (i + 1) + ": ");
            int id = sc.nextInt();
            Penguin s = new Penguin(id);
            if (checkPenguinId(list, s)) {
                // error mesg
                System.out.println("A penguin with this ID already exists");
            } else {
                list.add(s);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

  private static boolean checkSnakeId(ArrayList<iAnimal> al, Snake snake) {

        boolean found = false;
        for (int i = 0; i < al.size(); i++) {
            if (al.get(i) instanceof Snake) { //iterate over all snake instances in al
                Snake s = (Snake) al.get(i); //if a snake instance, assign it to s and compare to snake instance in method parameter
                if (s.compareTo(snake) == 0) {
                    found = true;
                    break;
                }
            }
        }
        return found;
    }

    private static boolean checkPenguinId(List<iAnimal> al, Penguin penguin) {

        boolean found = false;
        for (int i = 0; i < al.size(); i++) {
            if (al.get(i) instanceof Penguin) {
                Penguin s = (Penguin) al.get(i);
                if (s.compareTo(penguin) == 0) {
                    found = true;
                    break;
                }
            }
        }

        return found;
    }


}


interface iAnimal {
    public String getAnimalType();
    public int getIdTag();
    public void setIdTag(int anIdTag);
    public int getMinTemperature();
    public int getMaxTemperature();
}


class Snake implements iAnimal, Comparable<Snake> {
    public final String animalType = "snake";
    public int idTag;
    public final int minTemp = 68;
    public final int maxTemp = 80;

    Snake(int idTag) {
        this.idTag = idTag;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setIdTag(int anIdTag) {
        idTag = anIdTag;
    }

    public int getIdTag() {
        return idTag;
    }

    public int getMinTemperature() {
        return minTemp;
    }

    public int getMaxTemperature() {
        return maxTemp;
    }

    public String toString() {
        return animalType + ", " + idTag + ", " + minTemp + ", " + maxTemp;
    }

    public int compareTo(Snake s) {
        return idTag - s.idTag;
    }
}

class Penguin implements iAnimal, Comparable<Penguin> {
    public final String animalType = "penguin";
    public final int minTemperature = 20;
    public final int maxTemperature = 32;
    public int idTag;

    Penguin(int idTag) {
        this.idTag = idTag;
    }

    //override 5 methods
    public String getAnimalType() {
        return animalType;
    }

    //accessor
    public int getIdTag() {
        return idTag;
    }

    //mutator
    public void setIdTag(int anIdTag) {
        idTag = anIdTag;
    }

    public int getMinTemperature() {
        return minTemperature;
    }

    public int getMaxTemperature() {
        return maxTemperature;
    }

    @Override
    public int compareTo(Penguin penguin) {
        return idTag - penguin.idTag;
    }

    @Override
    public String toString() {
        return animalType + ", " + idTag + ", " + minTemperature + ", " + maxTemperature;
    }
}


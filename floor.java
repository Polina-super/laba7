package laba7;
import java.util.*;
public class floor {
    private int Number;
    public int getNumber() {
        return Number;
    }
    private int Count;
    public int getCount() {
        return Count;
    }
    public Room[] rooms1;
    public Collection rooms2;

    public floor(int number) {
        Number = number;
        int count = rand(3, 10);
        Count = count;
        switch (number) {
            case 1: {
                rooms1 = new Room[count];
                for (int i = 0; i < count; i++) {
                    rooms1[i] = new Room(rand(1, 3), rand(5, 60));
                }
            }
            break;
            case 2:
            case 4: {
                rooms2 = new ArrayList();
                for (int i = 0; i < count; i++) {
                    rooms2.add(new Room(rand(1, 3), rand(5, 60)));
                }
            }
            break;
            case 3:
            case 5: {
                rooms2 = new LinkedList();
                for (int i = 0; i < count; i++) {
                    rooms2.add(new Room(rand(1, 3), rand(5, 60)));
                }
            }
            break;
            default:
                break;
        }
    }

    public int  count_square1(){
        int square=0;
        Iterator<Room> iter = Arrays.stream(rooms1).iterator();
        while(iter.hasNext()){
            square+=iter.next().getSquare();
        }
        return square;
    }

    public int count_square1(int type){
        int square=0;
        Iterator<Room> iter = Arrays.stream(rooms1).iterator();
        while(iter.hasNext()){
            Room thisRoom= iter.next();
            if(thisRoom.getType()==type) square+=thisRoom.getSquare();
        }
        return square;
    }

    public int count_square(){
        int square=0;
        Iterator<Room> iter = rooms2.iterator();
        while(iter.hasNext()){
            square+=iter.next().getSquare();
        }
        return square;
    }

    public int count_square(int type){
        int square=0;
        Iterator<Room> iter = rooms2.iterator();
        while(iter.hasNext()){
            Room thisRoom= iter.next();
            if(thisRoom.getType()==type) square+=thisRoom.getSquare();
        }
        return square;
    }

    public static int rand(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}

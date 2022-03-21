package laba7;
import java.util.ArrayList;
import java.util.Collection;
public class main {
    public static floor[] House;
    public static int space=0, floor=0, type;
    public static void main(String[] args) {
        House = new floor[5];
        for (int i=0;i<5; i++)
        {
            House[i]=new floor(i+1);
        }
        InfHouse();
        countSpace();
        for (int i=0;i<5;i++) countFloor(i+1);
        for (int i=0;i<3;i++) countType(i+1);
    }

    public static void InfHouse(){
        System.out.print("Всего: 9 этажей \n");
        for (int i=0;i<5;i++)
            System.out.printf("Этаж %s, всего квартир %s \n", House[i].getNumber(), House[i].getCount());
        System.out.print("\n");
    }

    public static void countSpace(){
        for (int i=0;i<5;i++){
            if ((i+1)==1) space+=House[i].count_square1();
            else space+=House[i].count_square();
        }
        System.out.printf("Общая жилая площадь = %s m^2 \n", space);
    }

    public static void countFloor(int nubmer){
        if ((nubmer)==1) floor=House[nubmer-1].count_square1();
        else floor=House[nubmer-1].count_square();
        System.out.printf("Общая жилая площадь на этаже №%s = %s m^2 \n",nubmer, floor);
    }

    public static void countType(int type1){
        type=0;
        for (int i=0;i<5;i++){
            if ((i+1)==1) type+=House[i].count_square1(type1);
            else type+=House[i].count_square(type1);
        }
        System.out.printf("Общая площадь квартир с количеством комнат %s = %s m^2 \n",type1, type);
    }
}

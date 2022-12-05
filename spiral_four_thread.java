package my;
/*
 Заполнение по спирали двумерного массива со сторонами А Х В любого размера
 при условии, что А = В
 */

import java.util.Scanner;

public class spiral_four_thread {

    public static void main(String[] args) {
        // Выбираем размер стороны квадрата и рассчитываем общее количество элементов массива
        int  Num = 1;
        int stringLength;
        int bias=0;
        int boxNumber, reverseLine ;
        boolean Evin = true;
       
        Scanner test = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);

            System.out.println("укажите размер массива для заполнения");
            int Size = sc.nextInt();
            System.out.println("0- тестовый прогон с остановками, 1- быстрый тестовый прогон, 2-рабочий прогон");
            int Test = test.nextInt();
      
        if (Size % 2 == 0)  Evin=false;  // флаг четности размера массива
        int Mid  = Size / 2  ;           //  центр массива
        // Объявляем массив для заполнения
        int[][] Sp = new int[Size][Size];
        // Заполняем массив 
        for (int n=0; n< (Size/2); n++) {        // перебор вложенных квадратов от внешнего до центрального
            stringLength= Size- 2*n - 1;            // длина стороны в текущего квадрата
            for( int i=0; i <stringLength; i++) {   // порядковый номер элемента в стороне
                boxNumber = Size-n-1;          // обратное движение между вложенными квадратами
                reverseLine = Size-i-1;           // реверсивное движение вдоль стороны
                bias = Size - 2 * n-1;          // расчет приращения индекса от стороны к стороне 
                Sp [n][n+i] = Num;                              // заполнение левого столбца
                Sp [n+i][boxNumber] = Num + 1*bias;            // заполнение верхней стороны
                Sp [boxNumber][reverseLine-n] = Num + 2*bias;    // заполниение правого столбца сверху вниз
                Sp [reverseLine-n][n] = Num + 3*bias;             //  реверсивное заполнение нижней стороны
                Num += 1;

                // 
                if(Test==0) {    
                    print(Size, Sp);
                    System.out.println("Подтвердите:");
                    System.out.println("0- тестовый прогон с остановками, 1- быстрый тестовый прогон, 2-рабочий прогон");
                    Test = test.nextInt();
                }
                if(Test==1)   print(Size, Sp);
                
            }
            Num += 3 * bias;                                    // смещение порядкового номера от внешнего квадарата ко вложенному
        }
        if (Evin) Sp[Mid][Mid] = Num ; // вишенка в центре - для массива из нечет. колич. элементов
         print(Size, Sp);  // вызов метода для печати заполненного массива

}

    private static void print(int Size, int[][] Sp) {   // вывод массива в консоль
// Печать массива заполненного данными по спирали
        System.out.println();
        System.out.println();
//      for (int i = 0; i < Size; i++) {
        for (int i = Size-1; i >= 0; i--) {
            for (int j = 0; j < Size; j++) {
                System.out.format("%5d", Sp[j][i]);
            }
              System.out.println("");
        }
    }    
}



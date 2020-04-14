import java.util.ArrayList;
import java.util.Arrays;

public class GenerOfPermutations {
    public static void main(String[] args) {
        String s1 = "A", s2 = "B", s3 = "C", s4 = "D", s5 = "E", s6 = "F";// значения для массива
        String [] sArray = {s1,s2,s3,s4,s5,s6}; // Массив для перебора
        ArrayList<String[]> resultList = new ArrayList<>(); //лист для сбора результатов
        recursiveShift(sArray,sArray.length,resultList); // вызов метода для формирования всех комбинаций без повторного использования элементов
        for (String[] s: resultList) {
            System.out.println(Arrays.toString(s));
        }
        System.out.println(resultList.size());
    }

    public static void recursiveShift(String [] s, int numOfElem, ArrayList<String[]> resultList){ //рекурсивный метод для формирования списка
        String [] local = s; //
        if (numOfElem==1){
            resultList.add(local);
            return;
        } else {
            for (int i = 0; i < numOfElem; i++) {
                recursiveShift(local,numOfElem-1,resultList);
                local = shiftFrom(local,s.length-numOfElem);
            }
        }
    }

    /*
    метод для сдвига правой,относительно указанной указанной позиции, части массива
    Входные данные: [A, B, C, D, E, F] , 3
    Выходные данные:  [A, B, C, E, F, D]
    A B C
          D E F
          D->
          <-E F
          E F D
    A B C E F D
    */
    public static String [] shiftFrom (String [] incomeString, int pos){
        String [] result = new String[incomeString.length];
        String [] temp = new String[incomeString.length-pos];
        System.arraycopy(incomeString,pos,temp,0,incomeString.length-pos);
        temp = shift1(temp);
        System.arraycopy(incomeString,0,result,0,pos);
        System.arraycopy(temp,0,result,pos, result.length-pos);
        return result;
    }

    public static String [] shift1 (String [] incomeString){// сдвиг массива на 1 влево
        String [] result = new String[incomeString.length];
        System.arraycopy(incomeString,1,result,0,incomeString.length-1);
        System.arraycopy(incomeString,0,result,result.length-1, 1);
        return result;
    }
}

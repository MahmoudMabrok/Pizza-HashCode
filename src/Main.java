import java.util.ArrayList;
import java.util.Scanner;

/**
 * this is
 * Created by mo3tamed on 2/13/18.
 */
public class Main {

    public static void main(String[] args) {
        int row, col, min, max;
        Scanner in = new Scanner(System.in);

        row = in.nextInt();
        col = in.nextInt();
        min = in.nextInt();
        max = in.nextInt();

        String[] data = new String[row];
        for (int i = 0; i < row; i++) {
            data[i] = new String(in.next());
        }

        int t = 0, m = 0;
        int size = 0;
        int count = 0 ;
        int stRow = 0, stCol = 0;

        ArrayList<String> output= new ArrayList<>();

        char current ;
        for (int i = 0; i < col ;i++ ) {

            for (int j = 0; j < row;j++ ) {
                current =data[j].charAt(i) ;
                if ( current != '#') {
              //     count++ ; //count of visited
                   // size++ ;
                    if (current == 'T')
                        t++;
                    else
                        m++ ;
                    if ((t+m) < max &&  (t < min || m < min) ) // limit of pizza slice
                    {
                        continue;
                    }
                    else{
                        if ((t >= min &&  m >= min))
                        {
                           count ++ ;
                            output.add(new String(""+stRow+" "+stCol+" "+j+" "+i)) ;

                            /*System.out.println("start row , col " + stRow + " , " + stCol);
                            System.out.println("end " + j  + " , " + i);
                            */
                            t=0 ;
                            m=0 ;


                            if ( (row  - (j+ 1)) >= (2 * min) ) {
                                stRow = j+1 ;
                                stCol = i;
                            }
                            else
                            {
                                stCol = i+1 ;
                                stRow = 0 ;
                                break;
                            }

                        }
                    }
                }
            }


        }

        System.out.println(count + " Slice ");
        for (String s :output
             ) {
            System.out.println(s);
        }
    }

}
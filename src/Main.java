import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * this is
 * Created by mo3tamed on 2/13/18.
 */
public class Main {

    public static void main(String[] args) {
        int row, col, min, max;
        Scanner in = null;
        try {
            in = new Scanner(new File("small.in"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

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

                    if (current == 'T')
                        t++;
                    else
                        m++ ;


                    if(j==(row-1) && (t < min || m < min) && stRow !=0 )
                    {
                        //case reach end and not get min so start from next col
                        stCol =i+1 ;
                        stRow = 0 ;
                        t=0;
                        m=0;
                        break;
                    }
                     else if ((t+m) < max &&  (t < min || m < min) ) // limit of pizza slice
                    {
                        continue;
                    }
                    else{  //here it exceed size or get minimum n of t and m

                        if ((t >= min &&  m >= min))
                        {
                           count ++ ;
                            //output.add(new String(""+stRow+" "+stCol+" "+j+" "+i)) ;

                            /*System.out.println("start row , col " + stRow + " , " + stCol);
                            System.out.println("end " + j  + " , " + i);
                            */
                            t=0 ;
                            m=0 ;

                            if (stRow == 0 && i!= stCol ){ //start from col and end in another
                                output.add(new String(""+stRow+" "+stCol+" "+(row-1)+" "+i)) ; //(row -1 ) take all column
                                stRow = 0 ;
                                stCol = i+1;
                                break;

                            }

                            else if ( (row  - (j+ 1)) >= (2 * min) ) {
                                output.add(new String(""+stRow+" "+stCol+" "+j+" "+i)) ;
                                stRow = j+1 ;
                                stCol = i;

                            }
                            else
                            {
                                output.add(new String(""+stRow+" "+stCol+" "+j+" "+i)) ;
                                stCol = i+1 ;
                                stRow = 0 ;
                                break;
                            }

                        }
                    }
                }
            }


        }


        /*System.out.println(count + " Slice ");
        for (String s.txt :output
             ) {
            System.out.println(s.txt);
        }*/

        try {
            PrintWriter pr = new PrintWriter(new File("0.txt"));
            pr.println( count);
            for (String s : output) {
                pr.println(s);
            }
            pr.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
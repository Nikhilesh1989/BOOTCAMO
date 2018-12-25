
import java.util.*;
/**
 * Write a description of class List here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class List
{
    // instance variables - replace the example below with your own
    private int x;
    private int f_num;
    private ArrayList<Integer> number_list;
    
    private int counter;

    /**
     * Constructor for objects of class List
     */
    public List()
    {
        // initialise instance variables
        x = 0;
        counter =0;
        f_num = 0;
        number_list= new ArrayList<>();
       
    }

   
    public void get_input()
    {
        
        Scanner console = new Scanner(System.in); //declaring a console for input
        System.out.println("Please enter the first number");//take user input for the first number
        f_num = console.nextInt();
        System.out.println ("How many integers do you want to enter?"); // determine the size of array
        x = console.nextInt();
        int cursor = 0;
        int flag = 0;
        while (cursor < x)
        {
            
            System.out.println ("Please enter\t"+ (cursor+1) +"\tinteger; integer should have maximum of 2 digits");
             try{
             number_list.add(console.nextInt()); //user input
             while (number_list.get(cursor) > 99 || number_list.get(cursor) < 10 )
             {
                 number_list.remove(cursor);
                 System.out.println ("Please enter two digit positive value");
                 number_list.add(console.nextInt());
             }
            }
            catch(Exception e){
                System.out.println("Please enter valid value. Kindly restart");
                break;
                             
            }
            cursor ++;
        }
                 
        int number = check_list(number_list);
        System.out.println("Number of pairs whose sum is equal to "+f_num+" is "+number);
    }
    public int  check_list(ArrayList <Integer> A)
    {
        int cursor = 0;
        
        ArrayList<Integer> transpose_list = new ArrayList<>();
        ArrayList<Integer> uniq_list = new ArrayList<>();
        while(cursor < A.size())
        {
            
            transpose_list.add(((A.get(cursor)%10)*10)+(A.get(cursor)/10));
            cursor++;
        }
        cursor = 0;
        while(cursor < A.size())
        {
             if(transpose_list.get(cursor) != A.get(cursor))
             uniq_list.add(A.get(cursor));
             cursor++;
        }
        cursor = 0;
        ArrayList<Integer> uni = new ArrayList<>();
        while(cursor < uniq_list.size())
        {
            if(!uni.contains(uniq_list.get(cursor)))
            uni.add(uniq_list.get(cursor));
            cursor++;
        }
        
        ArrayList<Integer> f_list = new ArrayList<>();
        int i = 0;
        while(i < uni.size())
        {
             int reverse = 0;
             if(!f_list.contains(uni.get(i)))
             {
                 for ( int j = i+1 ; j< uni.size();j++)
                 {
                     if(((uni.get(i)%10*10)+(uni.get(i)/10) == uni.get(j)))
                     {reverse = uni.get(j);
                     break;}
                 }
             
             if(reverse != 0)
             f_list.add(reverse);
             else
             f_list.add(uni.get(i));
            }
              
             i++;                                      
        }
             
        
        cursor = 0;
        while (cursor < f_list.size())
        {
            if((f_list.get(cursor)/10)+(f_list.get(cursor)%10) ==f_num)
            {
                counter++;
            }
        
            cursor++;
        }    
            
            return counter;
          
        
       }
       
        
        
    }


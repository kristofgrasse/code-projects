/* CS1401 Intro to Computer Science
Instructor: Casas
Challenge Lab 1
Modified and submitted by: Kristof Grasse   */
import java.util.Scanner;
import java.util.InputMismatchException;  //import error to be caught
public class fitTracker
{
   public static void main (String[] args)
   {
      String trainerName = "";       //declare variables
      int stepsPer = 0;              //declare variables
      int totalSteps = 0;            //declare variables
      int totalPokemon = 0;          //declare variables
      int counter = 0;               //declare variables  
      int looper = 0;                //declare variables
      int cleanStart = 0;            //declare variables
      char pokemon = 'y';            //declare variables
      double lazyRoute = 0.0;        //declare variables
      double fixedLazy = 0.0;        //declare variables
      double totalRouteAverage = 0.0;//declare variables
      boolean startProgram = true;   //declare variables
      Scanner poke = new Scanner(System.in);     //start scanner
      while (startProgram == true)   //condition to start first while loop
         {
         if (cleanStart == 0) // this is to only ask for name after restarting program
         {
            Scanner cranky = new Scanner(System.in);       //start scanner
            System.out.println("What is your name?");
            trainerName = cranky.nextLine(); //store name
         }
         if (counter == 0) //counter to prevent asking if caught pokemon twice
         {
            totalPokemon = catchEm(); // call method to take steps & count pokemon
         }
         
         stepsPer = totalSteps(); // method for dealing with steps
         totalSteps = stepsPer + totalSteps; // store total steps
         totalPokemon = catchEm() + totalPokemon; // store total pokemon caught
         if (totalPokemon != 0) //avoid divid by 0
         {
            totalRouteAverage = (double)totalSteps / (double)totalPokemon;
         }    //^^^^calculate average of current route
         else // set totalRouteAverage to 0 if totalPokemon = 0
         {
            totalRouteAverage = 0;
         }
         lazyRoute = totalRouteAverage; //store totalRouteAverage in temp variable
         if (fixedLazy == 0.0 || ((fixedLazy > lazyRoute) && lazyRoute != 0.0 ))
         {    //^^ set fixedLazy to lazyRoute if = 0, such as on first pass in loop
            fixedLazy = lazyRoute;//^^^^store lazyRoute permanently if its smaller
         }
       
         looper = route();//decide what to do in loop
         if (looper == 1)
         {
           cleanStart = cleanStart + 1;
           counter = counter + 1;
           continue;
         }
         else if (looper == 2)
         {
            counter = 0;   //  counter set to 0 to repeat initial catchEm question
            totalPokemon = 0;   
            totalRouteAverage = 0.0;
            totalSteps = 0;
            lazyRoute = 0.0;
            cleanStart = cleanStart + 1;
            continue;
         }
         else if (looper == 3)
         {
            endSequence(totalRouteAverage, fixedLazy, trainerName);
            System.out.println("Do you wish to start over again??? (Y/N)");
            pokemon = poke.next().trim().charAt(0);
            if (pokemon == 'y' || pokemon == 'Y')
            {
               counter = 0;   //  counter set to 0 to repeat initial catchEm question
               totalPokemon = 0;   
               totalRouteAverage = 0.0;
               totalSteps = 0;
               lazyRoute = 0.0;
               fixedLazy = 0.0;
               cleanStart = 0;
               continue;
            }
            else
            {
               System.err.println("Have a nice day, trainer " + trainerName + "!");
               return;
            }
         }
         }
   }
   
public static void steper(int stepsPer) // method to print steps in sequence
{
   int i = 0;
   for ( i = 1; i<=stepsPer; ++i)
      { // print steps 1 up to total #
         System.out.println("Walking step " + i + "!"); //print statement
      }
}
  
public static int catchEm () //pokemon catch method
{
   char pokemon = 'y';
   int totalPokemon = 0;//delare variables
   Scanner scrn = new Scanner(System.in); // start scanner
   System.out.println("Did you catch a pokemon? (Y/N)");
   pokemon = scrn.next().trim().charAt(0); //trim excess space from char
   if (pokemon == 'y' || pokemon == 'Y') // set answer in conditional statement
   {
      try
      {
         System.out.println("How many pokemon did you catch?");
         totalPokemon = scrn.nextInt();
         if (totalPokemon <0)//prevent negative pokemon
         {
            System.out.println("Since when could you catch negative pokemon?");
            catchEm();
         }
      } 
      catch (InputMismatchException e)
      {
         catchEm();
      }
   } 
   else if (pokemon == 'n' || pokemon == 'N')
   {
      System.out.println("Darn! No luck?");
   }
   else 
   {
      System.out.println("Enter a valid answer, noobie!!! Y or N only!!!");
      catchEm();
   }
   scrn.close();           
   return totalPokemon;     //return total pokemon to main method
}
 
public static int totalSteps()
{
   Scanner poke = new Scanner(System.in);
   int stepsPer = 0;
   System.out.println("How many steps do you want to take? (1-100)");  
   try  // prevent illegal character from crashing program
   {
      stepsPer = poke.nextInt(); //store # steps 
   }
   catch (InputMismatchException e)
   {  //promt program to fail with grace
      System.out.println("OOPS! You entered an incorrect input! Try again!"); 
      totalSteps();
   }
   if (stepsPer <= 100 && stepsPer > 0)
   {
      steper (stepsPer); // send # steps to be looped in method steper
   }
   else if (stepsPer<0)
   {
      System.out.println("You can't take negative steps!");
      totalSteps();
   }
   else if (stepsPer == 0)
   {
      System.out.println("You should walk some, stretch those legs out a bit, you might get a cramp!");
      totalSteps();
   }
   else // prevent over 100 steps from being entered
   {
      System.out.println("Thats too many steps Buckeroo! You need between 1 and 100!");
      totalSteps(); // repeat question
   }
   return stepsPer; 
}
 
public static int route ()
{
   Scanner poke = new Scanner(System.in);
   char pokemon = 'y';
   System.out.println("Do you want to continue your route? (Y/N)");
   pokemon = poke.next().trim().charAt(0);// trim excess space from char
   if (pokemon == 'y' || pokemon == 'Y') //if Y or y to repeat while loop
   {
      return 1;
   }
   else    // if anything other than Y or y are entered
   {
      System.out.println("Do you want to start a new route? (Y/N)");
      pokemon = poke.next().trim().charAt(0);
      if(pokemon == 'y' || pokemon == 'Y')// thsee inputs trigger while loop reapeat
      {
         return 2;    
      }
      else // execute if anything other than Y or y are inputed
      {
         return 3;
      }
   }
}
  
public static void endSequence(double currentAverage, double fixedLazy, String trainerName)
{
   double lazyDifference = 0.0;
   lazyDifference = currentAverage - fixedLazy; //difference of lazy and previous route
   System.out.println("WooHOO! that was a good workout!");
   System.out.printf("The average steps to catch a pokemon on the current route was: " + "%.2f", currentAverage);
   System.out.print("!\n"); // ^^^ truncate decimal to 2 places
   System.out.printf( trainerName + " took " + "%.2f", lazyDifference);
   System.out.print(" steps more to catch a pokemon on average on the current route than on the lazy route!\n");  // ^^^ truncate decimal to 2 places
   System.out.printf("The laziest route " + trainerName + " took was " + "%.2f", fixedLazy);
   System.out.print(" steps per pokemon caught! WoW!\n");
}    
}
import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;
public class pokeBattle
{
    public static void main(String[] args)
    {
    String name = "";
    String yourPokemon = "";
    int choosePoke = 0;
    int yourAttack = 0;
    int yourDefense = 0;
    int yourHP = 0;
    Random rand = new Random();   
    Scanner scan = new Scanner(System.in);
    System.out.println("Hello, welcome to the wonderful world of pokemon!");
    System.out.println("Today, you will set out to battle your pokemon with other \npokemon in an effort to be the best!");
    System.out.println("To start things off, tell us your name!");
    name = scan.nextLine();
    System.out.println("Hmm... " + name + "? Thats a weird name... but anyways trainer " + name + ", lets get going!");
    System.out.println("You must choose a pokemon to start your Journey!");
    System.out.println("Press 1 for pikacu! \nPress 2 for charmander! \nPress 3 for Squirtle! \nPress 4 for bulbasaur!");
    choosePoke = scan.nextInt();
    switch(choosePoke)
    {
      case 1 :
         yourPokemon = "Pikacu";
         System.out.println("Great choice! Pikacu will fit your needs nicely! I can feel the electricity in the air!");
         yourAttack = 5;
         yourDefense = 2;
         yourHP = 41;
         break;
      case 2 :
         yourPokemon = "Charmander";
         System.out.println("Great! Charmander's tail is great for cooking smores!");
         yourAttack = 4;
         yourDefense = 2;
         yourHP = 43;         
         break;
      case 3 :
         yourPokemon = "Squirtel";
         System.out.println("That's nice... if your ever stranded in the desert you will never die of thirst!");
         yourAttack = 2;
         yourDefense = 5;
         yourHP = 34;
         break;
      case 4 :
         yourPokemon = "Bulbasaur";
         System.out.println("Bulbasaur is great for making salads when he is shedding in the summer!");
         yourAttack = 4;
         yourDefense = 2;
         yourHP = 44;
         break;
    }
    System.out.println("Now, you must set off on your journey!\n You leave Professor Oak's office.. \n You walk out of town... \n  ... \n  ... ");
    System.out.println("You come up on a patch of tall grass! You move through it trying to find pokemon!");
    
    
    String pokemon = "";
    int attack = 0;
    int defense = 0;
    int hP = 0;
    int pokeID = rand.nextInt(5) + 1;
    switch(pokeID)
    {
       case 1 :
          pokemon = "Electrabuzz";
          attack = 4;
          defense = 3;
          hP = 41;
          break;
      case 2 :
          pokemon = "Scyther";
          attack = 5;
          defense = 2;
          hP = 39;
          break;
      case 3 :
          pokemon = "Geodude";
          attack = 2;
          defense = 5;
          hP = 35;
          break;
      case 4 :
          pokemon = "Jynx";
          attack = 4;
          defense =3;
          hP = 39;
          break;
      case 5 :
          pokemon = "Kadabra";
          attack = 8;
          defense = 1;
          hP = 27;
          break;
    }
    battle(pokemon, yourPokemon, attack, yourAttack, defense, yourDefense, hP, yourHP);
    }
    public static void battle (String pokemon, String yourPokemon, int attack, int yourAttack, int defense, int yourDefense, int hP, int yourHP)
    {
    Scanner scan = new Scanner(System.in);
    Random rand = new Random();
    int attValue = 0;
    int miss = 0;
    System.out.println("A wild pokemon appears!");
    System.out.println(pokemon + " appeared!!");
    System.out.println("You send out " + yourPokemon);
    while(hP > 0 && yourHP > 0)
    {
      System.out.println("Press 1 for attack!");
      int yes = scan.nextInt();
      if (yes == 1)
      {
      miss = rand.nextInt(6);
      attValue = ((rand.nextInt(5)) + yourAttack - defense);
      if (attValue < 0)
        { attValue = 0; }
      System.out.println(yourPokemon + " attacks!");
      if (miss == 0)
      {
        attValue = 0;
        System.out.println("Your attack missed!");
      }
      if (attValue > 0)
      {
      
      hP = hP - attValue;
      }
      if (hP <= 0)
      { hP = 0; 
        System.out.println(pokemon + " has fainted!"); break; }
      System.out.println(pokemon + " now has " + hP + " HP left!");}
        System.out.println(pokemon + " attacks!");
        miss = rand.nextInt(6);
        attValue = ((rand.nextInt(5)) + attack - yourDefense);
        if (attValue < 0)
        { attValue = 0; }
        if(miss == 0)
        {
        attValue = 0;
        System.out.println(pokemon + "'s attack missed!");
        }
        if (attValue > 0)
        {
        yourHP = yourHP - attValue;
        }
        System.out.println(yourPokemon + " has " + yourHP + " left!");
        if (yourHP <= 0)
        { yourHP = 0;
          System.out.println("Your pokemon has fainted... You blacked out.."); break; }
            
    }
       
      
      }
      
      
      
    }
    
 
// Jason Alana
// 4/8/20
// CSE142
// TA:   Sara Sun
// Assignment #1
// 
// This program will out a cumulative song.

public class Song 
{
   public static void main (String[] args)
   {
      verse1();
      verse2();
      verse3();
      verse4();
      verse5();
      verse6();
      verse7();      
   }
   
   public static void verse1()
   {
      System.out.println("There was an old woman who swallowed a fly.");
      fly();
      System.out.println();
   }
   
   public static void verse2()
   {
      System.out.println("There was an old woman who swallowed a spider,");
      System.out.println("That wriggled and iggled and jiggled inside her.");
      spider();
      fly();
      System.out.println();
   }
   
   public static void verse3()
   {
      System.out.println("There was an old woman who swallowed a bird,");
      System.out.println("How absurd to swallow a bird.");
      bird();
      spider();
      fly();
      System.out.println();
   }
   
   public static void verse4()
   {
      System.out.println("There was an old woman who swallowed a cat,");
      System.out.println("Imagine that to swallow a cat.");
      cat();
      bird();
      spider();
      fly();
      System.out.println();
   }
   
   public static void verse5()
   {
      System.out.println("There was an old woman who swallowed a dog,");
      System.out.println("What a hog to swallow a dog.");
      dog();
      cat();
      bird();
      spider();
      fly();
      System.out.println();
   }
   
   public static void verse6()
   {
      System.out.println("There was an old woman who swallowed a lion,");
      System.out.println("She'd be lyin', if it weren't for the missing lion.");
      lion();
      dog();
      cat();
      bird();
      spider();
      fly();
      System.out.println();
   }
   
   public static void verse7()
   {
      System.out.println("There was an old woman who swallowed a horse,");
      System.out.println("She died of course.");
   }
   
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
      
   public static void fly()
   {
      System.out.println("I don't know why she swallowed that fly,");
      System.out.println("Perhaps she'll die.");
   }
         
   public static void spider()
   {
      System.out.println("She swallowed the spider to catch the fly,");
   }
   
   public static void bird()
   {
      System.out.println("She swallowed the bird to catch the spider,");
   }
   
   public static void cat()
   {
      System.out.println("She swallowed the cat to catch the bird,");
   }
   
   public static void dog()
   {
      System.out.println("She swallowed the dog to catch the cat,");
   }
   
   public static void lion()
   {
      System.out.println("She swallowed the lion to cath the dog,");
   }
}
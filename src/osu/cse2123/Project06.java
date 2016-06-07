/*
 * @author Yuchen Li
 * @version 04/18/2015
 */

package osu.cse2123;
import java.util.*;

public class Project06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Scanner keyboard = new Scanner(System.in);
	boolean quit = false;
	String inputString = "";
	
	while(!quit)
	{
		boolean backToMain = false;
		while(!backToMain)
		{
			System.out.println("Enter your choice: ");
			System.out.println("[S]et the display format");
			System.out.println("[E]nter a new expression");
			System.out.println("[Q]uit");
			System.out.print("> ");
			String input = keyboard.nextLine();
			boolean option = true;
			while (option)
			{
				if (!(input.equals("E") || input.equals("e") || input.equals("S") || input.equals("s") || input.equals("Q")|| input.equals("q")))
				{
					System.out.println("ERROR!  You must enter one of [E], [S] or [Q]!");
					System.out.println();
					option = false;
				}
				else
				{
					if (input.equals("E")|| input.equals("e"))
					{
						System.out.println();
						System.out.print("Enter your expression in postfix notation: ");
						inputString = keyboard.nextLine();
						TreeNode<String> root = ExpressionTree.buildTreeFromString(inputString);
						boolean postFix = true;
						while(postFix)
						{
							if (root != null)
							{
								System.out.println(ExpressionTree.toPostfixString(root) + " = " +  ExpressionTree.evaluate(root));
								break;
							}
							else
							{
								System.out.println();
								System.out.println("ERROR! Expression not in postfix notation!");
								postFix = false;
							}
						}
						
					}
					if (input.equals("S") || input.equals("s"))
					{
						System.out.println();
						System.out.println("Enter your preferred output display:");
						System.out.println("[P]ostfix");
						System.out.println("[I]nfix");
						System.out.println("p[R]efix");
						System.out.print("> ");
						String format = keyboard.nextLine();
						if(format.equals("P") || format.equals("p"))
						{
							String postString = ExpressionTree.toPostfixString(ExpressionTree.buildTreeFromString(inputString));
							int value = ExpressionTree.evaluate(ExpressionTree.buildTreeFromString(inputString));
							System.out.print(postString + " = " +  value);
							System.out.println();
						}
						if(format.equals("I") || format.equals("i"))
						{
							String inString = ExpressionTree.toInfixString(ExpressionTree.buildTreeFromString(inputString));
							int value = ExpressionTree.evaluate(ExpressionTree.buildTreeFromString(inputString));
							System.out.print(inString + " = " +  value);
							System.out.println();
						}
						if(format.equals("R") || format.equals("r"))
						{
							String preString = ExpressionTree.toPrefixString(ExpressionTree.buildTreeFromString(inputString));
							int value = ExpressionTree.evaluate(ExpressionTree.buildTreeFromString(inputString));
							System.out.print(preString + " = " +  value);
							System.out.println();
						}
					}
					if (input.equals("Q")|| input.equals("q"))
					{
						quit = true;
					}
				}
			}		
		}
	}
	System.out.println("Goodbye!");
  }
}

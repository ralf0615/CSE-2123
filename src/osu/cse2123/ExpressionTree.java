package osu.cse2123;
import java.util.*;

public class ExpressionTree {

	public static TreeNode<String> buildTreeFromString(String expr)
	{
		Stack<TreeNode<String>> exprStack = new Stack<TreeNode<String>>();
		String[] exprArr = expr.split("\\s+");
		for(int i = 0; i< exprArr.length; i++)
		{
			TreeNode<String> tempTreeNode = new TreeNode<String>(exprArr[i]); //create a new tree node with the element from the array
			if(tempTreeNode.getData().equals("+")||tempTreeNode.getData().equals("-")||tempTreeNode.getData().equals("*")||tempTreeNode.getData().equals("/")) 
				//if they are operator
			{
				TreeNode<String> pop1 = exprStack.pop();
				TreeNode<String> pop2 = exprStack.pop();
				if(pop1.getData().equals(null)||pop2.getData().equals(null))
				{
					return null;
				}
				else
				{
					tempTreeNode.setRightChild(pop1);
					tempTreeNode.setLeftChild(pop2);
					exprStack.push(tempTreeNode);
				}
			}
			else
			{
				exprStack.push(tempTreeNode);
			}
		}
		
		if(exprStack.size()==1)
		{
			return exprStack.pop();
		}
		else //if the size is greater than 1, aka, if the final exprStack contains more than one TreeNode, return null
		{
			return null;
		}
	}
	
	public static String toPostfixString(TreeNode<String> expr) //Copied from ClosedLab12 //post-order
	{
		String temp = "";
		if(expr.getLeftChild()!= null)
		{
			temp =  temp + toPostfixString(expr.getLeftChild());
		}
		
		if(expr.getRightChild()!=null)
		{
			temp = temp + toPostfixString(expr.getRightChild());
		}
		temp = temp + expr.getData().toString() + " ";
		return temp;
	}
	
	public static String toInfixString(TreeNode<String> expr) //in-order
	{
		String temp = "";
		if(expr.getLeftChild()!= null)
			{
				temp = temp + "(" + toInfixString(expr.getLeftChild()) ;
			}
		
		temp = temp + expr.getData().toString();
					
		if(expr.getRightChild()!= null)
			{
				temp = temp + toInfixString(expr.getRightChild()) + ")";
			}
		return temp;
	}
	
	public static String toPrefixString(TreeNode<String> expr)//pre-order
	{
		String temp1 = expr.getData().toString();
		if (expr.getLeftChild() != null)
		{
			temp1 = temp1 + " " + toPrefixString(expr.getLeftChild());	
		}
		if (expr.getRightChild() != null)
		{
			temp1 = temp1 + " " + toPrefixString(expr.getRightChild());
		}
		return temp1;
	}

	public static int evaluate(TreeNode<String> expr)
	{
		if( (expr.getData().equals("+"))||(expr.getData().equals("-"))||(expr.getData().equals("*"))||(expr.getData().equals("/")) )
		{
			if (expr.getData().equals("+"))
			{
				return evaluate(expr.getLeftChild()) + evaluate(expr.getRightChild());
			}
			else if (expr.getData().equals("-"))
			{
				return evaluate(expr.getLeftChild()) - evaluate(expr.getRightChild());
			}
			else if (expr.getData().equals("*"))
			{
				return evaluate(expr.getLeftChild()) * evaluate(expr.getRightChild());
			}
			else
			{
				return evaluate(expr.getLeftChild()) / evaluate(expr.getRightChild());
			}
		}
		else
		{
			return Integer.parseInt(expr.getData());
		}
	}
}


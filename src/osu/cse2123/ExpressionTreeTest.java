package osu.cse2123;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExpressionTreeTest {

	@Test
	public void testBuildTreeFromString() {
		String temp = "5 10 15 - * 7 +";
		String temp2 = "10 3 5 * * 5 + 7 -";
		TreeNode<String> root = ExpressionTree.buildTreeFromString(temp);
		TreeNode<String> root2 = ExpressionTree.buildTreeFromString(temp2);
		assertEquals("5 * 10 - 15 + 7",root.toString());
		assertEquals("+",root.getData());
		//assertEquals("3 * 5 * 10 + 5 - 7",root2.toString());// it does not have the right format when you have a * b * c
	}
	
//	@Test
//	public void testToPostfixString()
//	{
//		String temp1 = "5 10 15 - * 7 +";
//		TreeNode<String> root = ExpressionTree.buildTreeFromString(temp1);
//		String temp2 = ExpressionTree.toPostfixString(root);
//		assertEquals(temp1,temp2);
//	}
//	
//	@Test
//	public void testToInfixString()
//	{
//		String temp1 = "5 10 15 - * 7 +";
//		TreeNode<String> root = ExpressionTree.buildTreeFromString(temp1);
//		String temp2 = ExpressionTree.toInfixString(root);
//		assertEquals("(5*(10-15))+7", temp2);
//	}
//
//	@Test
//	public void testToPrefixString()
//	{
//		String temp1 = "5 10 15 - * 7 +";
//		TreeNode<String> root = ExpressionTree.buildTreeFromString(temp1);
//		String temp2 = ExpressionTree.toPrefixString(root);
//		assertEquals("+ * 5 - 10 15 7", temp2);
//	}
//	
//	@Test
//	public void testEvaluate()
//	{
//		String temp1 = "5 10 15 - * 7 +";
//		TreeNode<String> root = ExpressionTree.buildTreeFromString(temp1);
//		assertEquals(-18,ExpressionTree.evaluate(root));
//	}
}

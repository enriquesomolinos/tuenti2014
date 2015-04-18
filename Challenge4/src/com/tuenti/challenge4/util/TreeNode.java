package com.tuenti.challenge4.util;

import java.util.LinkedList;
import java.util.List;

/**
 * The Class TreeNode.
 * A generic tree Representation
 *
 * @param <T> the generic type
 */
public class TreeNode<T>  {

    /** The data. */
    T data;
    
    /** The parent. */
    TreeNode<T> parent;
    
    /** The children. */
    List<TreeNode<T>> children;

    /**
     * Instantiates a new tree node.
     *
     * @param data the data
     */
    public TreeNode(T data) {
        this.data = data;
        this.children = new LinkedList<TreeNode<T>>();
    }

    /**
     * Adds the child.
     *
     * @param child the child
     * @return the tree node
     */
    public TreeNode<T> addChild(T child) {
        TreeNode<T> childNode = new TreeNode<T>(child);
        childNode.parent = this;
        this.children.add(childNode);
        return childNode;
    }
       

	/**
	 * Gets the parent.
	 *
	 * @return the parent
	 */
	public TreeNode<T> getParent(){
		return parent;
		
	}
	
	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public T getData(){
		return data;
		
	}
	
	public void draw(){
		TreeNode<T> solutionTreeState=this;
		StringBuffer sb = new StringBuffer();
		sb.append(solutionTreeState.getData().toString());
		while (solutionTreeState.getParent() != null) {
			solutionTreeState = solutionTreeState.getParent();
			sb.insert(0, solutionTreeState.getData().toString()
					+ "->");

		}
		System.out.println(sb.toString());
	}

}
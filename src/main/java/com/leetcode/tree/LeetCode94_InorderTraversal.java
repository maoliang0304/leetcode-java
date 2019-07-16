package com.leetcode.tree;

import com.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 * <p>
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 */
public class LeetCode94_InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        inorderTraversal(root, list);
        return list;
    }

    public void inorderTraversal(TreeNode node, List<Integer> list) {
        if(node != null){
            inorderTraversal(node.left,list);
            list.add(node.val);
            inorderTraversal(node.right,list);
        }
    }
}

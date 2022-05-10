package com.algorithm.tree;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;

/**
 * @ClassName TreeHelper
 * @Description
 * @Author xuxiangnan
 * @Date 2021/4/23 18:53
 */
public class TreeHelper {
    static int index;
    static String[] values;

    public TreeHelper(){}

    // 根据形如”1，2，#，4，5，#，7，#“的字符串建立二叉树，其中#代表该节点为空
    public void setValues(String treeValues) {
        values = treeValues.split(",");
        index = 0;

    }

    // 递归建立二叉树
    public TreeNode createTree() {
        TreeNode node = null;
        if(index < values.length){
            if (values[index].equals("#")) {
                index++;
                return null;
            }
            node = new TreeNode(Integer.parseInt(values[index]));
            index++;
            node.left = createTree();
            node.right = createTree();
        }
        return node;
    }

    public ArrayList<Integer> preorderTraversal (TreeNode root) {
        ArrayList<Integer> data = new ArrayList();
        if(root!=null){
            if(root.left!=null){
                data.addAll(preorderTraversal(root.left));
            }else{
                ArrayList<Integer> value = new ArrayList();
                value.add(root.val);
                return value;
            }
            if(root.right != null){
                data.addAll(preorderTraversal(root.right));
            }else{
                ArrayList<Integer> currNodeValue = new ArrayList<Integer>();
                currNodeValue.add(root.val);
                return currNodeValue;
            }
        }
        return null;
    }

    public ArrayList<Integer> preorderTraversal2 (TreeNode root) {
        ArrayList<Integer> data = new ArrayList();
        if(root!=null){
            if(root.left!=null){
                preorderTraversal2(root.left);
            }else{
                System.out.println(root.val);
            }
            if(root.right != null){
                preorderTraversal2(root.right);
            }else{
                System.out.println(root.val);
            }
        }
        return null;
    }

    //前序遍历
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        } else {
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    //中序遍历
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        } else {
            preOrder(root.left);
            System.out.print(root.val + " ");
            preOrder(root.right);
        }
    }

    //后序遍历
    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        } else {
            preOrder(root.left);
            preOrder(root.right);
            System.out.print(root.val + " ");
        }
    }

    //获取二叉树的节点个数
    public int getNodeNum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + getNodeNum(root.left) + getNodeNum(root.right);
    }

    //获取二叉树的高度
    /*public int getTreeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + max(getTreeHeight(root.left), getTreeHeight(root.right));
    }*/

    //创建二叉搜索树BST
    public TreeNode createSearchTree(int[] treeValues){
        TreeNode rootBST = null;
        for (int value : treeValues) {
            rootBST = insertNode(rootBST,value);
        }
        return rootBST;
    }

    //判断一个二叉树是否为二叉搜索树,时间复杂度O(1)
    public boolean isBST(TreeNode root) {
        return isBSTResolve(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isBSTResolve(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.val < min || root.val > max) {
            return false;
        }
        return isBSTResolve(root.left, min, root.val) && isBSTResolve(root.right, root.val, max);
    }

    //根据值查找二叉树搜索树root的某个节点
    public TreeNode findNode(TreeNode rootBST, int val) {
        if (rootBST == null) {
            return null;
        } else if (rootBST.val < val) {
            return findNode(rootBST.right, val);
        } else if (rootBST.val > val) {
            return findNode(rootBST.left, val);
        }
        return rootBST;
    }

    //向二叉搜索树中插入值val
    public TreeNode insertNode(TreeNode rootBST, int val) {
        if (rootBST == null) {
            rootBST = new TreeNode(val);
        } else {
            if (val < rootBST.val) {
                rootBST.left = insertNode(rootBST.left, val);
            } else if (val > rootBST.val) {
                rootBST.right = insertNode(rootBST.right, val);
            }
        }
        return rootBST;
    }

    //删除二叉树中某个值为val的节点
    public TreeNode deleteNode(TreeNode rootBST, int val) {
        if (findNode(rootBST, val) == null) {
            System.out.println("要删除的节点不存在！");
        } else {
            if (val < rootBST.val) {
                rootBST.left = deleteNode(rootBST.left, val);
            } else if (val > rootBST.val) {
                rootBST.right = deleteNode(rootBST.right, val);
            } else {  //rootBST就是要被删除的节点
                if (rootBST.left != null && rootBST.right != null) {  //被删除的节点的左右子节点均存在
                    TreeNode tmp = findMinNode(rootBST.right);  //从右子树找到值最小的节点填充删除节点
                    rootBST.val = tmp.val;
                    rootBST.right = deleteNode(rootBST.right, rootBST.val);  //删除右子树值最小的元素
                } else {  //被删除的节点只有一个或者无子节点存在
                    //被删除节点的左子节点为空，则右子节点取代根节点
                    if (rootBST.left == null) {
                        rootBST = rootBST.right;
                    } else {
                        rootBST = rootBST.left;
                    }
                }
            }
        }
        return rootBST;
    }
    // 找到二叉搜索树中值最小的节点
    public TreeNode findMinNode(TreeNode rootBST) {
        if (rootBST == null) {
            return null;
        } else if (rootBST.left == null) {
            return rootBST;
        }
        return findMinNode(rootBST.left);
    }



/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 * }
 */

    public ArrayList<Integer> preorderTraversal3 (TreeNode root) {
        ArrayList<Integer> data = new ArrayList();
        // write code here
        if(root!=null){
            if(root.left!=null){
                ArrayList<Integer> integers = preorderTraversal(root.left);
                if(CollectionUtils.isEmpty(integers)){
                    return data;
                }
            }else{
                ArrayList<Integer> value = new ArrayList();
                value.add(root.val);
                return value;
            }
            if(root.right != null){
                ArrayList<Integer> integers = preorderTraversal(root.right);
                if(CollectionUtils.isEmpty(integers)){
                    return data;
                }
            }else{
                ArrayList<Integer> currNodeValue = new ArrayList<Integer>();
                currNodeValue.add(root.val);
                return currNodeValue;
            }
        }
        return null;
    }

    public ArrayList<Integer> preorderTraversal4 (TreeNode root) {
        ArrayList<Integer> data = new ArrayList();
        // write code here
        if(root==null){
            return new ArrayList();
        }
        data.addAll(preorderTraversal4(root.left));
        data.add(root.val);
        data.addAll(preorderTraversal4(root.right));
        return data;
    }
}

package com.algorithm.tree;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;

/**
 * @ClassName TreeHelperTest
 * @Description
 * @Author xuxiangnan
 * @Date 2021/4/23 18:53
 */
public class TreeHelperTest {
    public static void main(String[] args) {
        String treeNodeValues = "1,2,#,#,3,4,#,#,5,6,#,8,#,#";
        TreeHelper treeHelper = new TreeHelper();
        treeHelper.setValues(treeNodeValues);
        try {
            TreeNode root = treeHelper.createTree();
            System.out.println("创建二叉树成功！");

            ArrayList<Integer> integers = treeHelper.preorderTraversal4(root);
            System.out.println(JSONObject.toJSONString(integers));
           /* System.out.println("前序遍历二叉树：");
            treeHelper.preOrder(root);
            System.out.println();

            System.out.println("中序遍历二叉树：");
            treeHelper.inOrder(root);
            System.out.println();

            System.out.println("后序遍历二叉树：");
            treeHelper.postOrder(root);
            System.out.println();

            System.out.printf("二叉树的节点数目：%d\n", treeHelper.getNodeNum(root));

           // System.out.printf("二叉树的高度：%d\n", treeHelper.getTreeHeight(root));

            System.out.println("二叉树是否为二叉搜索树：" + String.valueOf(treeHelper.isBST(root)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            TreeNode rootBST = treeHelper.createSearchTree(new int[]{2, 4, 3, 1, 9, 7, 6, 8});
            System.out.println("创建二叉搜索树成功！");

            System.out.println("二叉树是否为二叉搜索树：" + String.valueOf(treeHelper.isBST(rootBST)));

            System.out.println("中序遍历二叉搜索树：");
            treeHelper.inOrder(rootBST);
            System.out.println();

            rootBST = treeHelper.insertNode(rootBST, 5);
            System.out.println("中序遍历插入5后的二叉搜索树：");
            treeHelper.inOrder(rootBST);
            System.out.println();

            rootBST = treeHelper.deleteNode(rootBST, 6);
            System.out.println("中序遍历删除6后的二叉搜索树：");
            treeHelper.inOrder(rootBST);
            System.out.println();*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

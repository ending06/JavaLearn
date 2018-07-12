package com.hua.algorithm.service.node;

import com.google.common.base.Objects;

public class BinaryTree {

    private TreeNode root;

    /**
     *
     * 根结点
     * */
    public TreeNode getParent(TreeNode node) {
        if (node == null) {
            throw new IllegalArgumentException("param node invalid");
        }
        return (node == null || root == node) ? null : parent(root, node);
    }

    private TreeNode parent(TreeNode root, TreeNode node) {
        if (root == null) {
            return null;
        }
        if (root.getLchild() == node || root.getRchild() == node) {
            return root;
        }
        TreeNode temp;
        if ((temp = parent(root.getLchild(), node)) != null) {
            return temp;
        } else {
            return parent(root.getRchild(), node);
        }
    }

    public int getSize()
    {
        return getNum(root);
    }

    private int getNum(TreeNode node)
    {
        if (node == null)
        {
            return 0;
        }
        else
        {
            int i = getNum(node.getLchild());
            int j = getNum(node.getRchild());
            return j + i + 1;
        }
    }

    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int i = getHeight(node.getLchild());
            int j = getHeight(node.getRchild());
            return (i < j) ? (j + 1) : (i + 1);
        }
    }

    /**
     * 前序遍历 根左右
     * */
    public void preOrder(TreeNode node) {
        if (node != null) {
            System.out.printf(node.getData() + "==>");
            preOrder(node.getLchild());
            preOrder(node.getRchild());
        }
    }

    /**
     * 中序：左根右
     * */
    public void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.getLchild());
            System.out.printf(node.getData() + "==>");
            inOrder(node.getRchild());
        }
    }

    /**
     * 后续遍历
     * */
    public void postOrder(TreeNode node) {
        if (node != null) {
            postOrder(node.getLchild());
            postOrder(node.getRchild());
            System.out.printf(node.getData() + "==>");
        }
    }

    public BinaryTree() {
    }

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    private static class TreeNode {
        private String data;
        private TreeNode lchild;
        private TreeNode rchild;

        public TreeNode(String data, TreeNode lchild, TreeNode rchild) {
            this.data = data;
            this.lchild = lchild;
            this.rchild = rchild;
        }

        public TreeNode() {
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public TreeNode getLchild() {
            return lchild;
        }

        public void setLchild(TreeNode lchild) {
            this.lchild = lchild;
        }

        public TreeNode getRchild() {
            return rchild;
        }

        public void setRchild(TreeNode rchild) {
            this.rchild = rchild;
        }

        @Override
        public String toString() {
            return Objects.toStringHelper(this).add("data", data).add("lchild", lchild).add("rchild", rchild)
                    .toString();
        }
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("root", root).toString();
    }

    public static void main(String[] args) {
        TreeNode lchild = new TreeNode("2-l",null,null);
        TreeNode rchild = new TreeNode("2-r",null,null);
        TreeNode parent = new TreeNode("2",lchild,rchild);

        TreeNode rchild2 = new TreeNode("3-r",null,null);
        TreeNode parent2 = new TreeNode("3",null,rchild2);

        TreeNode root = new TreeNode("root",parent,parent2);

        BinaryTree binaryTree = new BinaryTree(root);

        System.out.println("结点个数==>"+binaryTree.getSize());

        System.out.println("高度==>"+binaryTree.getHeight(root));

        System.out.printf("前序遍历:");
        binaryTree.preOrder(root);

        System.out.printf("\n中序遍历:");
        binaryTree.inOrder(root);

        System.out.printf("\n后序遍历:");
        binaryTree.postOrder(root);

    }
}

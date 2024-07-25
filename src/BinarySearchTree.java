import java.util.ArrayDeque;
import java.util.Deque;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class BST{
    public boolean search(TreeNode root, int target){
        if(root == null){
            return false;
        }
        if(target < root.val){
            return search(root.left, target);
        }else if(target > root.val){
            return search(root.right, target);
        }else {
            return true;
        }
    }

    public TreeNode insert(TreeNode root, int val){
        if(root == null){
            return new TreeNode(val);
        }
        if(root.val > val){
            root.left = insert(root.left, val);
        }else if(root.val < val){
            root.right = insert(root.right, val);
        }
        return root;
    }

    public TreeNode minValueNode(TreeNode root){
        TreeNode curr = root;
        while (curr != null && curr.left != null){
            curr = curr.left;
        }
        return curr;
    }

    public TreeNode removeElement(TreeNode root, int val){
        if(root == null){
            return null;
        }
        if(val > root.val){
            root.right = removeElement(root.right, val);
        }
        else if(val < root.val){
            root.left = removeElement(root.left, val);
        }else{
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }else{
                TreeNode minNode = minValueNode(root.right);
                root.val = minNode.val;
                root.right = removeElement(root.right, minNode.val);
            }
        }
        return root;
    }

    public void inorderTraversal(TreeNode root){
        if(root== null){
            return;
        }
        inorderTraversal(root.left);
        System.out.printf("%d -> ",root.val);
        inorderTraversal(root.right);
    }

    public void BFS(TreeNode root){
        Deque<TreeNode> deque = new ArrayDeque<>();
        if(root != null){
            deque.add(root);
        }
        int level = 0;
        while (!deque.isEmpty()){
            System.out.println("level " + level + " : ");
            int levelLength = deque.size();
            for(int i = 0; i < levelLength; i ++){
                TreeNode curr = deque.removeFirst();
                System.out.println(curr.val);
                if(curr.left != null){
                    deque.add(curr.left);
                }
                if(curr.right != null){
                    deque.add(curr.right);
                }
            }
            level ++;
        }
    }
}


public class BinarySearchTree {
    public static void main(String[] args){
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        BST bst = new BST();
        bst.BFS(root);
    }
}

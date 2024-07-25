import java.util.ArrayDeque;
import java.util.Deque;

class BinarySearchTee{
    public boolean search(TreeNode root, int target){
        if(root == null){
            return false;
        }
        if(root.val > target){
            return search(root.left, target);
        }else if(root.val < target){
            return search(root.right, target);
        }else {
            return true;
        }
    }

    public TreeNode insert(TreeNode root, int value){
        if(root == null){
            return new TreeNode(value);
        }
        if(root.val > value){
            root.left = insert(root.left, value);
        }else if(root.val < value){
            root.right = insert(root.right , value);
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
    public void inorderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        inorderTraversal(root.left);
        System.out.printf("%d -> ", root.val);
        inorderTraversal(root.right);
    }
    public void BFS(TreeNode root){
        Deque<TreeNode> deque = new ArrayDeque<>();
        if(root != null){
            deque.add(root);
        }
        int level = 0;
        while (!deque.isEmpty()){
            System.out.println("Level " + level + ": ");
            int size = deque.size();
            for(int i = 0; i < size; i ++){
                TreeNode curr = deque.removeLast();
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

    public TreeNode removeElement(TreeNode root, int val){
        if(root == null){
            return null;
        }
        if(root.val > val){
            root.left = removeElement(root.left, val);
        } else if (root.val < val) {
            root.right = removeElement(root.right, val);
        }else{
            if(root.right == null){
                return root.left;
            }
            else if(root.left == null){
                return root.right;
            }else{
                TreeNode minNode = minValueNode(root.right);
                root.val = minNode.val;
                root.right = removeElement(root.right, minNode.val);
            }
        }
        return root;
    }
}


public class Main {
    public static void main(String[] args){
        BinarySearchTee bst = new BinarySearchTee();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        bst.insert(root, 1);
        bst.removeElement(root, 7);
        bst.inorderTraversal(root);

    }
}
/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    class Pair{
        TreeNode node;
        int state;
        Pair(TreeNode in,int is){
            this.node=in;
            this.state=is;
        }
    }
    
    // Iterative based approach is based on idea that each node can be visited 3 times during traversal
    // i.e during pre(first time interaction with this node)
    // during in(second time interation with this node and going to explore its right child)
    // during post(last time interaction with this node as it is fully explored : final goodbye :-/ )
    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> preorder=new ArrayList<>();
        Stack<Pair> stack=new Stack<>();
        stack.push(new Pair(A,1));
        // states : 1(pehli baar aaye for pre order), 2(doosri baar aaye for inorder), 3(teesri baar aaye for post order)
        while(stack.size()>0){
            Pair peek=stack.peek();
            if(peek.state==1){
                // pre order
                peek.state++;
                if(peek.node.left!=null){
                    stack.push(new Pair(peek.node.left,1));
                }
                preorder.add(peek.node.val);
            }else if(peek.state==2){
                // in order
                peek.state++;
                if(peek.node.right!=null){
                    stack.push(new Pair(peek.node.right,1));
                }
            }else if(peek.state==3){
                // post order
                // popping as it is fully explored now
                stack.pop();
            }
        }
        return preorder;
    }
}

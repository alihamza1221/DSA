public class tree {
    //segment tree


    //build
    class Node {
        int val;//sum of the nodes or val for the leaf nodes
         Node left ;
         Node right;
         int left_interval;
         int right_interval;

         //constructer
        Node(int val , int left_interval , int right_interval){
         this.val = val;
         this.left_interval = left_interval;
         this.right_interval = right_interval;
        }

    }

    //building the segment tree
    public Node buildTee(int[] arr){
        return buildsegmentTree( arr, 0 , arr.length -1);
    }
    Node buildsegmentTree( int[] arr , int s , int e){
        if(s >= e ){
            return new Node(arr[s], s, e);
        }
        int mid = s + (e -s )/2;

        Node node = new Node( 0 , s , e);

        node.left = buildsegmentTree(arr,  s , mid);
        node.right = buildsegmentTree(arr, mid+1, e);

        node.val = node.left.val + node.right.val;
        return node;
    }
    //display
    public void display(Node node){
        if(node == null){
            return;
        }
        String str = "";
        if(node.left != null){
            str = str + "Interval=[" + node.left.left_interval +"-"+node.left.right_interval+ "] and val=" + node.left.val +"->";
        }
        else{
            str = str + "left(null) ->";
        }
        //current node
        str = str + "Interval=[" + node.left_interval +"-"+node.right_interval+ "] and val=" + node.val +"->";
        if(node.right != null ){
            str = str + "Interval=[" + node.right.left_interval +"-"+node.right.right_interval+ "] and val="+ node.right.val;
        }
        else{
            str = str + "right(null)";
        }
        System.out.println(str);
        display(node.left);
        display(node.right);
    }

    //query in the segment tree
    public int querySum(Node node , int qsi , int qei){
        if(node.left_interval >= qsi && node.right_interval <= qei){
            return node.val;
        }
        else if(node.left_interval > qei || node.right_interval < qsi){
            return  0;
        }
        else{
          return  querySum(node.left ,qsi , qei ) + querySum(node.right , qsi , qei);
        }
    }

    //update function
    public int update(Node node,int index , int val){
        if(node.left_interval <= index && node.right_interval >= index){
            if(node.left_interval == index && node.right_interval== index){
                node.val = val;
                return node.val;
            }else{
              int leftAns =   update(node.left ,index , val);
              int rightAns =  update(node.right , index , val);
                return node.val = leftAns + rightAns;
            }
        }
            return node.val;
    }

    public static void main(String[] args) {
      tree Tree = new tree();
      Node root = Tree.buildTee(new int[]{ 3, 8 , 7 , 6 , -2 ,-8 , 4 , 9});
      Tree.display(root);
      System.out.println(Tree.querySum(root, 2,6));
      Tree.update(root, 7 , 11);
      Tree.display(root);
    }
}


import java.util.*;

public class TreeNode implements Comparable<TreeNode>, Comparator<TreeNode>{

	 	int data;
	    List<TreeNode> children;

	    public TreeNode(int data) {
	        this.data = data;
	        this.children = new ArrayList<TreeNode>();
	    }

		@Override
		public int compare(TreeNode o1, TreeNode o2) {
			return o1.data - o2.data;
		}

		@Override
		public int compareTo(TreeNode o) {
			
			Integer oi = o.data;
			// TODO Auto-generated method stub
			return oi.compareTo(new Integer(data));
		}
		
		
}

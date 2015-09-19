package GoogleInterview;

import java.util.ArrayList;

public class HtmlTreeNode {
	
	public String name;
	public boolean isNode;
	public String val;
	
	public ArrayList<HtmlTreeNode> children;
	
	public HtmlTreeNode() {
		children = new ArrayList<HtmlTreeNode>();
	}
	
	public HtmlTreeNode(String node, boolean isNode, String val) {
		this.name = node;
		this.isNode = isNode;
		this.val = val;		
		children = new ArrayList<HtmlTreeNode>();
	}
	
	public void addChild(HtmlTreeNode child) {
		this.children.add(child);
	}

}

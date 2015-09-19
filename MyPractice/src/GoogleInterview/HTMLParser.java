package GoogleInterview;

public class HTMLParser {

	public HtmlTreeNode root;
	
	public HTMLParser() {
	}
	
	public boolean checkContent(HtmlTreeNode root1, HtmlTreeNode root2) {
		
		String contentR1 = getContentHelper(root1, new StringBuilder());
		String contentR2 = getContentHelper(root2, new StringBuilder());
		return contentR1.equals(contentR2);
	}
	
	// Performs a Depth first search
	public String getContentHelper(HtmlTreeNode node, StringBuilder sb) {
		
		for (HtmlTreeNode child : node.children) {
			if (!child.isNode) {
				sb.append(child.val);
			}
			getContentHelper(child, sb);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		
		HTMLParser htmlParser = new HTMLParser();
		
		// Tree 1
		HtmlTreeNode r1 = new HtmlTreeNode("html", true, "");
		HtmlTreeNode p1 = new HtmlTreeNode("p", true, "");
		HtmlTreeNode b1 = new HtmlTreeNode("b", true, "");
		HtmlTreeNode c1 = new HtmlTreeNode("c1", false, "HELLO");
		
		// start from the inner most node
		b1.children.add(c1);
		p1.children.add(b1);
		r1.children.add(p1);
						
		// Tree 2
		HtmlTreeNode r2 = new HtmlTreeNode("html", true, "");
		
		HtmlTreeNode p2 = new HtmlTreeNode("p", true, "");
		HtmlTreeNode content1 = new HtmlTreeNode("c1", false, "H");
		
		HtmlTreeNode b2 = new HtmlTreeNode("b", true, "");
		HtmlTreeNode content2 = new HtmlTreeNode("c2", false, "EL");
		HtmlTreeNode l2 = new HtmlTreeNode("l", true, "");
		HtmlTreeNode content3 = new HtmlTreeNode("c2", false, "L");
		HtmlTreeNode content4 = new HtmlTreeNode("c2", false, "O");
		
		
		// Maintain the order of insertion
		l2.addChild(content3); // l's child is L
		
		// b2's child is content2 , l and content 4
		b2.addChild(content2);
		b2.addChild(l2);
		b2.addChild(content4);

		// p2's child is content1 and b2
		p2.addChild(content1);
		p2.addChild(b2);
		
		r2.addChild(p2);
		
		System.out.println(htmlParser.checkContent(r1, r2));
	}
}

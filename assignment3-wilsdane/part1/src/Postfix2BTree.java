public class Postfix2BTree extends AbstractPart1 {
    public static Node getBTree(String[] postfix) {
        if (postfix == null || postfix.length == 0) {
            return null;
        }

        java.util.Stack<Node> stack = new java.util.Stack<>();
        for (String token : postfix) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid postfix expression: too many operators.");
                }
                Node right = stack.pop();
                Node left = stack.pop();
                Node node = new Node(token);
                node.setLeft(left);
                node.setRight(right);
                stack.push(node);
            } else {
                stack.push(new Node(token));
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid postfix expression: too many operands.");
        }

        return stack.pop();
    }

    public static String[] getPostfix(Node node) {
        java.util.List<String> list = new java.util.ArrayList<>();
        postOrder(node, list);
        return list.toArray(new String[0]);
    }

    private static void postOrder(Node node, java.util.List<String> list) {
        if (node == null) return;
        postOrder(node.getLeft(), list);
        postOrder(node.getRight(), list);
        list.add(node.getValue());
    }
}

import java.util.Comparator;

import static java.lang.Math.max;

/**
 * TODO: Complete the implementation of this class.
 *
 * A HuffmanTree represents a variable-length code such that the shorter the
 * bit pattern associated with a character, the more frequently that character
 * appears in the text to be encoded.
 */

public class HuffmanTree {

  class Node {
    protected char key;
    protected int priority;
    protected Node left, right;

    public Node(int priority, char key) {
      this(priority, key, null, null);
    }

    public Node(int priority, Node left, Node right) {
      this(priority, '\0', left, right);
    }

    public Node(int priority, char key, Node left, Node right) {
      this.key = key;
      this.priority = priority;
      this.left = left;
      this.right = right;
    }

    public boolean isLeaf() {
      return left == null && right == null;
    }

    public String toString() {
      if (isLeaf()) {
        return String.format("[%s:%d]", key, priority);
      } else {
        String l = left.toString();
        String r = right.toString();
        return String.format("(%s %s)", l, r);
      }
    }
  }

  private Node root;

  public HuffmanTree(FrequencyTable charFreqs) {
    Comparator<Node> comparator = (x, y) -> {
      if (x.priority < y.priority)
        return -1;
      if (x.priority > y.priority)
        return 1;
      return 0;
    };

    PriorityQueue<Node> forest = new Heap<Node>(comparator);

    for (char ch : charFreqs.keySet())
      forest.push(new Node(charFreqs.get(ch), ch));
    int n = forest.size();

    for (int i = 0; i < n - 1; i++) {
      Node left = forest.pop();
      Node right = forest.pop();
      Node tr = new Node(left.priority + right.priority, left, right);
      forest.push(tr);
    }
    if (!forest.isEmpty())
      root = forest.pop();
  }

  public char decodeChar(String bits) {
    Node p = root;
    int i = 0, n = bits.length();
    while (!p.isLeaf()) {
      if (i == n)
        throw new DecodeException(bits);
      char next = bits.charAt(i);
      i++;
      if (next == '0')
        p = p.left;
      else
        p = p.right;
    }
    return p.key;
  }

  public String lookup(char ch) {
    String code = lookupRecursive(root, ch);
    if (code == null)
      throw new EncodeException(ch);
    return code;
  }

  private String lookupRecursive(Node p, char ch) {
    if (p == null)
      return null;
    else if (p.key == ch)
      return "";
    else {
      String result = lookupRecursive(p.left, ch);
      if (result != null)
        return "0" + result;
      result = lookupRecursive(p.right, ch);
      if (result != null)
        return "1" + result;
      return null;
    }
  }

  public String lookup2(char ch) {
    String code = lookupAccumulate(root, ch, "");
    if (code == null)
      throw new EncodeException(ch);
    return code;
  }

  private String lookupAccumulate(Node p, char ch, String code) {
    if (p == null)
      return null;
    if (p.isLeaf() && p.key == ch)
      return code;
    String lcode = lookupAccumulate(p.left, ch, code + "0");
    if (lcode != null)
      return lcode;
    return lookupAccumulate(p.right, ch, code + "1");
  }

  public String toString() {
    if (root == null)
      return "";
    else
      return root.toString();
  }
}
class Node {
    private Node[] links = new Node[26]; // array for 'a' to 'z'
    private boolean flag = false;

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    public Node get(char ch) {
        return links[ch - 'a'];
    }

    public void setEnd() {
        flag = true;
    }

    public boolean isEnd() {
        return flag;
    }
}

class Trie {
    private Node root;

    public Trie() {
        root = new Node();
    }

    // Insert a word
    public void insert(String word) {
        Node node = root; 
        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) {
                node.put(ch, new Node()); 
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    // Search for a word
    public boolean search(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) {
                return false;
            }
            node = node.get(ch);
        }
        return node.isEnd();
    }

    // Check if any word starts with prefix
    public boolean startsWith(String prefix) {
        Node node = root;
        for (char ch : prefix.toCharArray()) {
            if (!node.containsKey(ch)) {
                return false;
            }
            node = node.get(ch);
        }
        return true;
    }
}

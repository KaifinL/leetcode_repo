class MinStack {
    Node head;

    public MinStack() {
        this.head = null;
    }
    
    public void push(int val) {
        if (this.head == null) {
            this.head = new Node(val, val, null);
        } else {
            this.head = new Node(val, Math.min(head.min, val), head);
        }
    }
    
    public void pop() {
        this.head = this.head.next;
    }
    
    public int top() {
        return this.head.val;
    }
    
    public int getMin() {
        return this.head.min;
    }
    
    private class Node {
        int val;
        int min;
        Node next;
        
        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
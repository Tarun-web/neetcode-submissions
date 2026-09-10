class MinStack {

    Stack<Integer> s; 
    Stack<Integer> s2;

    public MinStack() {
        s = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int val) {
        s.push(val);
        if(s2.isEmpty()){
            s2.push(val);
        }
        else if(s2.peek() >= val){
            s2.push(val);
        }
    }
    
    public void pop() {
        if(!s.isEmpty()){
            int top = s.pop();

            if(!s2.isEmpty() && s2.peek() == top) s2.pop();
        }
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return s2.peek();
    }
}

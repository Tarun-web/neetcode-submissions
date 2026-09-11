class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();

        int n = tokens.length;

        for(int i=0; i<n; i++){
            
            if(!tokens[i].equals("+") 
            && !tokens[i].equals("/") 
            && !tokens[i].equals("-") 
            && !tokens[i].equals("*")){
                int num = Integer.parseInt(tokens[i]);
                s.push(num);
            }
            else{
                int opd2 = !s.isEmpty() ? s.pop() : 0;
                int opd1 = !s.isEmpty() ? s.pop() : 0;

                switch(tokens[i]){
                    case "+":
                        s.push(opd1 + opd2);
                        break;
                    case "*":
                        s.push(opd1 * opd2);
                        break;
                    case "/":
                        s.push(opd1 / opd2);
                        break;
                    case "-":
                        s.push(opd1 - opd2);
                        break;
                    default:
                        break;

                }
            }
        }
        return s.peek();
    }
}

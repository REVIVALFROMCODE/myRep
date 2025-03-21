class Solution {
    public int evalRPN(String[] tokens) {
        stack s = new stack();
        for(String token:tokens){
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                int b = Integer.parseInt(s.popv2());
                int a = Integer.parseInt(s.popv2());

                switch(token){
                    case "+":
                        s.push(String.valueOf(a + b));
                        break;
                    case "-":
                        s.push(String.valueOf(a - b));
                        break;
                    case "*":
                        s.push(String.valueOf(a * b));
                        break;
                    case "/":
                        s.push(String.valueOf(a / b));
                        break;
                }
            }else{
                s.push(token);
            }
        }
        return Integer.parseInt(s.pop());
    }
    private class stack {
        String[] v;
        int n;

        stack() {
            v = new String[10];
            n = 0;
        }

        void push(String s) {
            if (n == v.length)
                resize(2 * n);
            v[n++] = s;

        }

        String pop() {
            String res = v[--n];
            if (n > 0 && n == v.length / 4)
                resize(v.length / 2);
            return res;
        }
        void resize(int n) {
            String[] dup = new String[n];
            for (int i = 0; i < v.length; i++) {
                dup[i] = v[i];
            }
            v = dup;
        }
        String popv2() {
            String res = v[--n];
            return res;
        }

        

        boolean isEmpty() {
            return n <= 0;
        }
    }
}


public class Solution {

    public String simplifyPath(String path) {
        if (path.length() == 0)
            return "";
        String[] components = path.split("/");
        stack stack = new stack();

        for (String component : components) {
            if (component.equals(".") || component.isEmpty())
                continue;
            else if (component.equals("..")) {
                if (!stack.isEmpty())
                    stack.popv2();
            } else {
                stack.push(component);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, "/" + stack.popv2());
        }

        return result.length() > 0 ? result.toString() : "/";
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
            if (n > 0 && n <= v.length / 4)
                resize(n / 2);
            return res;
        }

        String popv2() {
            String res = v[--n];
            // if(n>0 && n<=v.length/4) resize(n/2);
            return res;
        }

        void resize(int n) {
            String[] dup = new String[n];
            for (int i = 0; i < v.length; i++) {
                dup[i] = v[i];
            }
            v = dup;
        }

        boolean isEmpty() {
            return n <= 0;
        }
    }

}

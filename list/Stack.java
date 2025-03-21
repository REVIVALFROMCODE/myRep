private static class stack implements Iterable<String> {
        String[] v;
        int n;

        stack() {
            v = new String[10];
            n = 0;
        }

        void resize(int length) {
            String[] dup = new String[length];
            for (int i = 0; i < v.length; i++) dup[i] = v[i];
            v = dup;
        }

        void push(String s) {
            if (n == v.length) resize(2 * n);
            v[n++] = s;
        }

        String pop() {
            String res = v[--n];
            return res;
        }

        boolean isEmpty() {
            return n <= 0;
        }


        @Override
        // Regular iterator
        public Iterator<String> iterator() {
            return new StackIterator();
        }
        // Backward iterator
        public Iterator<String> backwardIterator() {
            return new StackIteratorBack();
        }

        private class StackIteratorBack implements Iterator<String> {
            private int index;

            StackIteratorBack() {
                this.index = 0;
            }

            @Override
            public boolean hasNext() {
                return index <= n;
            }

            @Override
            public String next() {
                return v[index++];
            }
        }

        private class StackIterator implements Iterator<String> {
            private int index;

            StackIterator() {
                this.index = n - 1;
            }

            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public String next() {
                return v[index--];
            }
        }
    }

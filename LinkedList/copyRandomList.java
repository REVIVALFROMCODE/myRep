    /*
    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    */

    class Solution {
        public Node copyRandomList(Node head) {
            //deep copy linked list
            //1.Insert A' behind A : A-> A'-> B-> B'
            if(head==null) return head;
            Node current=head;

            while(current!=null){
                Node N = new Node(current.val);
                N.next=current.next;
                current.next=N;
                current=current.next.next;
            }   

            //2.set radom pointer
            current = head;
            while(current!=null){
                if(current.random!=null) current.next.random = current.random.next;
                current=current.next.next;
            }

            //3.Seperate list

            current = head;
            Node copiedHead = head.next;
            Node copiedCurrent = copiedHead;
            while(copiedCurrent.next!=null){
                current.next = current.next.next;

                copiedCurrent.next = copiedCurrent.next.next;

                current=current.next;
                copiedCurrent=copiedCurrent.next;
            }
            current.next=null;
            return copiedHead;
        }
    }

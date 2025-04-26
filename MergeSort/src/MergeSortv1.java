public class MergeSortv1 {

    static Node merge(Node A, Node B) {

        int[] a = new int[Utils.length(Utils.append(A,B))];
        int i = 0;
        int j = 0;
        int k = 0;
        while(a.length > k){
            if(i < Utils.list_to_array(A).length && (j >= Utils.list_to_array(B).length || Utils.list_to_array(A)[i] <= Utils.list_to_array(B)[j])) {
                a[k] = Utils.list_to_array(A)[i];
                ++i;
            } else if (j < Utils.list_to_array(B).length) {
                a[k] = Utils.list_to_array(B)[j];
                ++j;
            }
            k++;
        }
        return Utils.array_to_list(a);


    }

    static Node sort(Node N) {

        if(Utils.length(N)> 1){
            int mid = Utils.length(N)/2;
            //put into 2 lines
            return merge(sort(Utils.take(N, mid)), sort(Utils.drop(N, mid)));
        }
        return N;
    }

    //split method for function used above
    private static Node[] split(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHalf = slow.next;
        slow.next = null;

        return new Node[]{head, secondHalf};
    }

    static Node merge_in_place(Node A, Node B) {

        if(A == null){
            return B;
        }
        else if(B == null){
            return A;
        }

        Node temp = new Node(-1, null);
        Node curr = temp;

        while (A != null && B != null) {
            if (A.data <= B.data) {
                curr.next = A;
                A = A.next;
            } else {
                curr.next = B;
                B = B.next;
            }
            curr = curr.next;
        }

        if (A != null) {
            curr.next = A;
        } else {
            curr.next = B;
        }

        return temp.next;
    }

    static Node sort_in_place(Node N) {
        if (N == null || N.next == null) {
            return N;
        }

        Node[] halves = split(N);
        Node sortedFirstHalf = sort_in_place(halves[0]);
        Node sortedSecondHalf = sort_in_place(halves[1]);

        return merge_in_place(sortedFirstHalf, sortedSecondHalf);
    }

}







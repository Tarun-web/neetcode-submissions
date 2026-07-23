class MyHashMap {

    public static class ListNode{
        int key, value;
        ListNode next;

        ListNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    // initialize a bucket
    ListNode[] bucket;
    int size; // prime number to avoid max collision

    public MyHashMap() {
        size = 769;
        bucket = new ListNode[size];
    }

    // hash
    public int hash(int key){
        return key % size;
    }
    
    public void put(int key, int value) {
        int idx = hash(key);
        ListNode head = bucket[idx];

        // check empty
        if(head == null){
            bucket[idx] = new ListNode(key, value);
            return;
        }

        // if not empty
        ListNode curr = head;
        while(curr.next != null){
            // if key already exists
            if(curr.key == key){
                curr.value = value;
                return;
            }
            curr = curr.next;
        }
        if(curr.key == key){
            curr.value = value;
            return;
        }
        curr.next = new ListNode(key, value);
    }
    
    public int get(int key) {
        int idx = hash(key);

        ListNode head = bucket[idx];

        // value not exists
        if(head == null){
            return -1;
        }        

        // exist
        ListNode curr = head;
        while(curr != null){
            if(curr.key == key){
                return curr.value;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int idx = hash(key);
        ListNode head = bucket[idx];

        // not exist
        if(head == null) return;

        // exist
        ListNode curr = head;

        // check first index because the deletion loop will start from 2nd index
        if(curr.key == key){
            bucket[idx] = curr.next;
            return;
        } 

        // starts from 2nd index
        while(curr.next != null){
            if(curr.next.key == key){
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
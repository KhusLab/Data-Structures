public abstract class MyHashTable<K, V> implements HTInterface{
    // This class must implement the HTInterface
    // This class is used to construct a hash table
    // The hash table must resolve collisions using linked lists
        private class Node {
            int key;
            int value;
            Node next;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
                this.next = null;
            }
        }

        private Node[] table;
        private int capacity;
        private int size;

    public MyHashTable(int capacity) {
        this.capacity = capacity;
        //this.table = new Node[capacity]; why isnt this acpeted
        this.table = (Node[]) new Object[capacity]; //have to cast? why
        this.size = 0;
    }


    private int hash(int key) {
            return Math.abs(key) % capacity;
        }

        public void put(int key, int value) {
            int index = hash(key);
            Node head = table[index];

            // check if key already exists
            Node current = head;
            while (current != null) {
                if (current.key == key) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }

            // insert new node at the head of the list
            Node newNode = new Node(key, value);
            newNode.next = head;
            table[index] = newNode;
            size++;
        }

        public int get(int key) {
            int index = hash(key);
            Node current = table[index];

            while (current != null) {
                if (current.key == key) {
                    return current.value;
                }
                current = current.next;
            }

            // key not found
            return -1;
        }

        public void remove(int key) {
            int index = hash(key);
            Node current = table[index];
            Node prev = null;

            while (current != null) {
                if (current.key == key) {
                    if (prev == null) {
                        table[index] = current.next; // remove head
                    } else {
                        prev.next = current.next;
                    }
                    size--;
                    return;
                }
                prev = current;
                current = current.next;
            }
        }

        public boolean containsKey(int key) {
            return get(key) != -1;
        }

        public int size() {
            return size;
        }
    }



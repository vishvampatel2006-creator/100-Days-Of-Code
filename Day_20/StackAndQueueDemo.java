public class StackAndQueueDemo {

    // --- Custom Stack using Array (LIFO: Last-In, First-Out) ---
    static class ArrayStack {
        private int[] arr;
        private int top;
        private int capacity;

        public ArrayStack(int capacity) {
            this.capacity = capacity;
            this.arr = new int[capacity];
            this.top = -1;
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public boolean isFull() {
            return top == capacity - 1;
        }

        public void push(int value) {
            if (isFull()) {
                System.out.println("Stack Overflow: Cannot push " + value);
                return;
            }
            arr[++top] = value;
            System.out.println("Pushed " + value + " to Stack");
        }

        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack Underflow: Stack is empty");
                return -1;
            }
            return arr[top--];
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return arr[top];
        }

        public void display() {
            if (isEmpty()) {
                System.out.println("Stack: [empty]");
                return;
            }
            System.out.print("Stack (top to bottom): ");
            for (int i = top; i >= 0; i--) {
                System.out.print(arr[i] + (i == 0 ? "" : " -> "));
            }
            System.out.println();
        }
    }

    // --- Custom Queue using Array (FIFO: First-In, First-Out) ---
    static class ArrayQueue {
        private int[] arr;
        private int front;
        private int rear;
        private int size;
        private int capacity;

        public ArrayQueue(int capacity) {
            this.capacity = capacity;
            this.arr = new int[capacity];
            this.front = 0;
            this.rear = -1;
            this.size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }

        public void enqueue(int value) {
            if (isFull()) {
                System.out.println("Queue Overflow: Cannot enqueue " + value);
                return;
            }
            rear = (rear + 1) % capacity;
            arr[rear] = value;
            size++;
            System.out.println("Enqueued " + value + " to Queue");
        }

        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue Underflow: Queue is empty");
                return -1;
            }
            int removed = arr[front];
            front = (front + 1) % capacity;
            size--;
            return removed;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[front];
        }

        public void display() {
            if (isEmpty()) {
                System.out.println("Queue: [empty]");
                return;
            }
            System.out.print("Queue (front to rear): ");
            for (int i = 0; i < size; i++) {
                int idx = (front + i) % capacity;
                System.out.print(arr[idx] + (i == size - 1 ? "" : " <- "));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Stack Demo ===");
        ArrayStack stack = new ArrayStack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();
        System.out.println("Top element (peek): " + stack.peek());
        System.out.println("Popped: " + stack.pop());
        stack.display();

        System.out.println("\n=== Queue Demo ===");
        ArrayQueue queue = new ArrayQueue(5);
        queue.enqueue(101);
        queue.enqueue(102);
        queue.enqueue(103);
        queue.display();
        System.out.println("Front element (peek): " + queue.peek());
        System.out.println("Dequeued: " + queue.dequeue());
        queue.display();
    }
}
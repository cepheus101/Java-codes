import java.util.Scanner;

class Queue {
    int[] queue;
    int front = -1;
    int rear = -1;
    int size;

    public static void main(String[] args) {
        Queue ob = new Queue();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the queue:");
        ob.size = sc.nextInt();
        ob.queue = new int[ob.size];

        while (true) {
            System.out.println("\nChoose an option:\n1. Insert an Element\n2. Delete an Element\n3. Print all Elements\n4. Exit");
            System.out.print("\nEnter your choice:");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to insert:");
                    int element = sc.nextInt();
                    ob.insert(element);
                    break;
                case 2:
                    ob.delete();
                    break;
                case 3:
                    ob.print();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    void insert(int element) 
    {
        if (rear == size-1) 
        {
            System.out.println("Queue is full!");
        } 
        else 
        {
            if(front==-1 && rear==-1)
            {
                front=0;
                rear=0;
            }
            else
                rear=rear+1;
            queue[rear] = element;
            System.out.println("Element inserted!");
        }
    }

    void delete() 
    {
        if (front==-1 && rear==-1) 
        {
            System.out.println("Queue is empty!");
        } 
        else 
        {
            System.out.println("Element deleted!"+ queue[front]);
            if(front==rear)
            {
                front=-1;
                rear=-1;
            }
            else
                front=front+1;
        }
    }

    void print() {
        if (front==-1 && rear==-1) 
        {
            System.out.println("Queue is empty!");
        } 
        else 
        {
            System.out.print("Elements in the queue:");
            for (int i = front; i <=rear; i++) {
                System.out.print(queue[i]+" ");
            }
        }
    }
}

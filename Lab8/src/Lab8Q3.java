import java.io.*;

public class Lab8Q3 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        MyQueue queue = new MyQueue();
        queue.enqueue("This");
        queue.enqueue("is");
        queue.enqueue("some");
        queue.enqueue("example");
        queue.enqueue("data");


        File file = new File("queue.obj");

        //serialize
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(queue);
        fileOutputStream.close();
        objectOutputStream.close();

        //deserialize
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        MyQueue newQueue = (MyQueue) objectInputStream.readObject();
        fileOutputStream.close();
        objectOutputStream.close();

        while(newQueue.size() > 0){
            System.out.println(newQueue.dequeue());
        }



    }
}

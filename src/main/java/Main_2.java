package soloviev;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import ru.pflb.mq.dummy.implementation.ConnectionImpl;
import ru.pflb.mq.dummy.implementation.DestinationImpl;
import ru.pflb.mq.dummy.implementation.ProducerImpl;
import ru.pflb.mq.dummy.implementation.SessionImpl;


public class Main_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConnectionImpl connection = new ConnectionImpl();
        connection.start();
        connection.createSession(true);
        SessionImpl sessionImpl = new SessionImpl();
        String с = "mySession";
        DestinationImpl destination = new DestinationImpl(с);
        ProducerImpl producerImpl = new ProducerImpl(destination);
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(args[0]));
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            for (String s : lines) {
                producerImpl.send(s);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

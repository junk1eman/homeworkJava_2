package soloviev;

import ru.pflb.mq.dummy.implementation.ConnectionImpl;
import ru.pflb.mq.dummy.implementation.DestinationImpl;
import ru.pflb.mq.dummy.implementation.ProducerImpl;
import ru.pflb.mq.dummy.implementation.SessionImpl;




public  class Main_1 {
    public static void main(String[] args) {
        ConnectionImpl connectionImpl = new ConnectionImpl();
        connectionImpl.start();
        connectionImpl.createSession(true);
        SessionImpl sessionImpl = new SessionImpl();
        String s = "mySession";
        DestinationImpl destinationImpl = new DestinationImpl(s);
        ProducerImpl producer = new ProducerImpl(destinationImpl);
        String[] oneTwo = {"Раз", "Два", "Три"};
        for (String value : oneTwo) {
            producer.send(value);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        sessionImpl.close();
        connectionImpl.close();
    }
}
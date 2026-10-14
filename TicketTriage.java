package tickettriage;
import java.util.PriorityQueue;
import java.util.Comparator;

class Ticket {
    String name;
    int urgency;
    int arrivalOrder;

    Ticket(String name, int urgency, int arrivalOrder) {
        this.name = name;
        this.urgency = urgency;
        this.arrivalOrder = arrivalOrder;
    }
}

public class TicketTriage {
    public static void main(String[] args) {

        PriorityQueue<Ticket> tickets = new PriorityQueue<>(
            Comparator.comparingInt((Ticket t) -> t.urgency)
                      .thenComparingInt(t -> t.arrivalOrder)
        );

        tickets.offer(new Ticket("Printer", 3, 1));
        tickets.offer(new Ticket("Network", 1, 2));
        tickets.offer(new Ticket("Login", 2, 3));

        System.out.println("=== HELP-DESK TICKET TRIAGE ===");

        while (!tickets.isEmpty()) {
            Ticket ticket = tickets.poll();

            System.out.println(
                "Ticket: " + ticket.name +
                " | Urgency: " + ticket.urgency
            );
        }
    }
}
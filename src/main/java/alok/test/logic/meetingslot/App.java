package alok.test.logic.meetingslot;

import java.util.*;

/**
 * Meeting Slots!
 *
 */
public class App {
    public static void main( String[] args ) {

        List<MeetingSlot> meetingSlots = new ArrayList<>();

        meetingSlots.add(new MeetingSlot(2,8));
        meetingSlots.add(new MeetingSlot(3,4));
        meetingSlots.add(new MeetingSlot(3,9));
        meetingSlots.add(new MeetingSlot(5, 11));
        meetingSlots.add(new MeetingSlot(8,20));
        meetingSlots.add(new MeetingSlot(11,15));

        Collections.sort(meetingSlots);

        int numberOfRooms = findRooms(meetingSlots);
        System.out.println("Required rooms: " + numberOfRooms);

    }

    private static int findRooms(List<MeetingSlot> meetingSlots) {

        List<MeetingSlot> occupiedRooms = new LinkedList<>();

        int requiredRooms = 0;

        for (MeetingSlot meetingSlot: meetingSlots) {
            releaseRoomsIfAny(occupiedRooms, meetingSlot.getStartTime());
            occupiedRooms.add(meetingSlot);
            if (requiredRooms < occupiedRooms.size())
                requiredRooms = occupiedRooms.size();

        }

        return requiredRooms;
    }

    private static boolean isOverlapping(MeetingSlot slot1, MeetingSlot slot2) {

        if (slot1.getEndTime() < slot2.getStartTime())
            return false;

        return true;
    }

    private static void releaseRoomsIfAny(List<MeetingSlot> occupiedRooms, int beforeTime) {
        Iterator<MeetingSlot> itr = occupiedRooms.listIterator();
        while (itr.hasNext()) {
            if (itr.next().getEndTime() <= beforeTime) {
                itr.remove();
            }
        }
    }
}

class MeetingSlot implements Comparable<MeetingSlot> {

    private int startTime;
    private int endTime;

    public MeetingSlot(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "MeetingSlot{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }


    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }


    @Override
    public int compareTo(MeetingSlot o) {

        if (startTime < o.startTime)
            return -1;

        if (startTime > o.startTime)
            return 1;

        return 0;
    }
}
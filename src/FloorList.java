import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FloorList {

    FloorNode head;
    private FloorNode tail;

    /**
     * Adds User Specified FloorNode to the FloorList
     * @param floorNode - User Specified FloorNode to be added to FloorList
     */
    public void addFloor(FloorNode floorNode) {

        if(tail == null) {
            head = floorNode;
            tail = floorNode;
        }
        else {
            tail.setNextNode(floorNode);
            tail = floorNode;
        }
    }


    /**
     * Finds User Specified Floor
     * @param floorNum - User Specified floorNum of Floors to be found
     */
    public Floor findFloor(int floorNum) {
        if (head == null) {
            System.out.println("No Floors Found");
            return null;
        }
        else {
            FloorNode temp = head;                           /*equals in giving an error */
             //while ((temp != null) && (!temp.getFloor().getFloorNum().equals(floorNum)))
            temp = temp.getNextNode();
            return temp == null ? null : temp.getFloor();
        }
    }


    /**
     * Deletes User Specified FloorNode from FloorList
     */
    public void deleteFloor(int floorNum) {
        FloorNode temp = head;
        FloorNode previous = null;
        if(temp != null && temp.floor.getFloorNum()==floorNum) {
            head=temp.nextNode;
            return;
        }
        while (temp!=null && temp.getFloor().getFloorNum()!=floorNum) {
            previous = temp;
            temp = temp.nextNode;
        }
        if (temp == null) {
            return;
        }
        previous.nextNode = temp.nextNode;
    }


    /**
     * Reset's the System by deleting the first Floor Node
     */
    public void Reset() {
        FloorNode floorNode = head;
        head = null;
    }

    /**
     * Save / Load System
     */




}

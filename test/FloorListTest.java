import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FloorListTest {

    private FloorList floorList;

    private Floor floor1, floor2;
    private FloorNode head, nextNode;

    private AisleList aisleList;
    private Aisle aisle1, aisle2;


    private MenuController menuController;

    @BeforeEach
    void setUp() {

        menuController= new MenuController();

        Floor floor1 = new Floor( 43, 2);
        Floor floor2 = new Floor( 12 , 1);
        FloorList list = new FloorList();

    }

    @Test
    void addFloor() {
        floorList.addFloor(floor1);
        floorList.addFloor(floor2);
        assertEquals(43, floor1.getFloorNum());
        assertEquals(2, floor1.getSecLevel());

        assertEquals(12, floor2.getFloorNum());
        assertEquals(1, floor1.getSecLevel());

    }



}



 */
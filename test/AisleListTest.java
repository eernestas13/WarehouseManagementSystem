import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AisleListTest {

    private FloorList floorList;

    private Floor floor1, floor2;
    private FloorNode head, nextNode;

    private AisleList aisleList;
    private Aisle aisle1, aisle2;

    private MenuController menuController;

    @BeforeEach
    void setUp() {

        menuController = new MenuController();

        Aisle aisle1 = new Aisle(floorNum, 111, floorList);
        Aisle aisle2 = new Aisle(floorNum, 222, floorList);
        AisleList list = new AisleList();

    @Test
    void addAisle() {
            aisleList.addAisle(aisle1);
            aisleList.addAisle(aisle2);
            assertEquals(111, aisle1.getAisleNum());

            assertEquals(222, aisle2.getAisleNum());

        }
    }

    @Test
    void findAisle() {
    }

    @Test
    void deleteAisle() {
    }
}

 */
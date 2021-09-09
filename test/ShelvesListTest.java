import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShelvesListTest {


    private ShelvesList shelvesList;
    private Shelf shelf1, shelf2;

    private MenuController menuController;

    void setUp() {

        menuController= new MenuController();

        Shelf shelf1 = new Shelf( 2, 2 );
        Shelf shelf2 = new Shelf(5,"as", );
        Shelf list = new ShelvesList();

    }


    @Test
    void addShelf() {
    }


    @Test
    void deleteShelf() {
    }
}

 */
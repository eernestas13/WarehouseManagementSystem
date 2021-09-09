import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalletListTest {

    private PalletList palletList;
    private Pallet pallet1, pallet2;

    private MenuController menuController;

    void setUp() {

        menuController= new MenuController();

        Pallet pallet1 = new Pallet( "food", 2);
        Pallet pallet2 = new Pallet( "cans" , 1);
        Pallet list = new PalletList();

    }


    @Test
    void addPallet() {
        palletList.addPallet(pallet1);
        palletList.addPallet(pallet2);
        assertEquals(2, pallet1.getPalletID());
        assertEquals("food", pallet1.getPalletName());

        assertEquals(1, pallet1.getPalletID());
        assertEquals("cans", pallet2.getPalletName());

    }


    @Test
    void deletePallet() {
    }
}



 */
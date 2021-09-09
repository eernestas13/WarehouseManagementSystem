public class PalletList {

    PalletNode head;
    PalletNode tail;


    /**
     * Adds User Specified Palletnode to the PalletList
     */
    public void addPallet(PalletNode palletNode) {

        if(tail == null) {
            head= palletNode;
            tail = palletNode;
        }
        else {
            tail.setNextNode(palletNode);
            tail = palletNode;
        }
    }

    /**
     * Finds User Specified Property
     * @param palletID - searched pallet to be found
     * @return - Null if Ppallet cannot be found
     *           Found Pallet Object if Pallet is Found
     */
    public Pallet findPallet(int palletID) {
        if (head == null) {
            System.out.println("No Pallets Found");
            return null;
        }
        else {
            PalletNode temp = head;
            while ((temp != null && (temp.getPallet().getPalletID() != palletID) ))
                temp = temp.getNextNode();
            return temp == null ? null : temp.getPallet();
        }
    }

    /**
     * Deletes Specified PalletNode from PalletList
     * @param palletID - User Specified palletID of PalletNode to be Deleted
     */
    public void deletePallet(int palletID) {
        PalletNode temp = head;
        PalletNode previous = null;
        if(temp != null && temp.pallet.getPalletID()==palletID) {
            head=temp.nextNode;
            return;
        }
        while (temp!=null && temp.getPallet().getPalletID()!=palletID) {
            previous = temp;
            temp = temp.nextNode;
        }
        if (temp == null) {
            return;
        }
        previous.nextNode = temp.nextNode;
    }
}

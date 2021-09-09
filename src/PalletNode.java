public class PalletNode {

    Pallet pallet;
    PalletNode nextNode;

    /**
     * Sets Pallet object to be put into palletNode
     * @param pallet
     */
    public PalletNode(Pallet pallet) { this.pallet = pallet; }

    /**
     * Gets specified pallet
     * @return
     */
    public Pallet getPallet() { return  pallet; }

    /**
     * sets specified pallet
     * @param pallet
     */
    public void setPallet(Pallet pallet) { this.pallet = pallet; }

    /**
     * Gets the NextNode in palletList
     * @return
     */
    public PalletNode getNextNode() { return nextNode; }

    /**
     * Sets nextNode in palletList
     * @param nextNode
     */
    public void setNextNode(PalletNode nextNode) { this.nextNode = nextNode; }

    @Override
    public String toString() {
        return pallet.toString();
    }
}


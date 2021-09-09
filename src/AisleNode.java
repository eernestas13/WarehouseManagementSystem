public class AisleNode {

    Aisle aisle;
    AisleNode nextNode;

    /**
     * places an aisle in aisleNode
     * @param aisle aisle to be placed int aisleNode
     */
    public AisleNode(Aisle aisle) {this.aisle = aisle; }

    /**
     * gets specific aisle
     * @return specific aisle
     */
    public Aisle getAisle() { return aisle; }

    /**
     * sets specific aisle
     * @param aisle
     */
    public void setAisle(Aisle aisle) { this.aisle = aisle; }

    /**
     * gets next node in aisleList
     * @return
     */
    public AisleNode getNextNode() { return nextNode; }

    /**
     * sets next node in aisleList
     * @param nextNode
     */
    public void setNextNode(AisleNode nextNode) { this.nextNode = nextNode; }

    @Override
    public String toString() {
        return aisle.toString();
    }

}

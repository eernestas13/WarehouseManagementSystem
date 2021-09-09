public class FloorNode {


    Floor floor;
    FloorNode nextNode;

    /**
     * Floor to be added to FloorNode
     * @param floor - User Specified Floor to be added to FloorNode
     */
    public FloorNode(Floor floor) { this.floor = floor; }

    /**
     * Gets User Specified Floor
     */
    public Floor getFloor () { return floor;}

    /**
     * Sets User Specified Floor
     */
    public void setFloor(Floor floor) { this.floor = floor; }

    /**
     * Gets the Next Node in the FloorList
     */
    public FloorNode getNextNode() { return nextNode; }

    /**
     * Sets the Next Node in the FloorList
     */
    public void setNextNode(FloorNode nextNode) { this.nextNode = nextNode; }

    @Override
    public String toString() { return floor.toString(); }

}

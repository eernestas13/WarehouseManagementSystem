public class ShelfNode {

    Shelf shelf;
    ShelfNode nextNode;


    /**
     * places a shelf into the shelfNode
     * @param shelf
     */
    public ShelfNode(Shelf shelf) { this.shelf = shelf; }

    /**
     * Gets specified shelf
     * @return
     */
    public Shelf getShelf() { return shelf; }

    /**
     * Sets specified shelf
     * @param shelf
     */
    public void setShelf(Shelf shelf) { this.shelf = shelf; }

    /**
     * Gets nextNode in ShelfList
     * @return
     */
    public ShelfNode getNextNode() { return  nextNode; }

    /**
     * Sets next node in shelfList
     * @param nextNode
     */
    public void setNextNode(ShelfNode nextNode) {this.nextNode = nextNode; }

    @Override
    public String toString() {
        return shelf.toString();
    }
}

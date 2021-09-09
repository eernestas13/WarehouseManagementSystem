public class Aisle {

    /**
     * Initialises the variables needed in this class
     */
    private int aisleNum;
    private FloorList floorList;
    private ShelvesList shelvesList = new ShelvesList();
    private int aisleSize;
    private int floorNum;
    private int floor;
    private int secLevel;


    /**
     * Constructor
     */

    public Aisle(int floorNum, int aisleNum, FloorList floorList, ShelvesList shelvesList, int aisleSize, int secLevel) {
        this.setFloorNum(floorNum);
        this.setAisleNum(aisleNum);
        this.setFloorList(floorList);
        this.setShelvesList(shelvesList);
        this.setAisleSize(aisleSize);
        this.setSecLevel(secLevel);
    }

/**
 * Gets the floor list
 */
    public FloorList getFloorList() {return floorList;}
    /**
     * Sets the floor list
     */
    private void setFloorList(FloorList floorList) { this.floorList = floorList; }
    /**
     * Gets the shelves list
     */
    public ShelvesList getShelvesList() { return shelvesList; }
    /**
     * Sets the shelves list
     */
    public void setShelvesList(ShelvesList shelvesList) { this.shelvesList = shelvesList; }
    /**
     * Gets the aisle number
     */
    public int getAisleNum() { return  aisleNum; }
    /**
     * Sets the aisle number
     */
    public void setAisleNum(int aisleNum) { this.aisleNum = aisleNum; }
    /**
     * Gets the floor number
     */
    public int getFloorNum() { return floorNum; }
    /**
     * Sets the floor number
     */
    public void setFloorNum (int floorNum) {
        if(floorList.findFloor(floor) != null) {
            this.floor = floor;
        } else {
            System.out.println("Error, floor doesn't exist");
        }
    }

    /**
     * Adds a shelf
     */
    public void addShelf(Shelf shelf) {
        ShelfNode shelfNode = new ShelfNode(shelf);
        shelvesList.addShelf(shelfNode);
    }

    public Aisle(int floorNum, int aisleNum, FloorList floorList) {
        this.setAisleNum(aisleNum);
    }

    /**
     * Gets the aisle size
     */
    public int getAisleSize() { return aisleSize; }
    /**
     * Sets the aisle size
     */
    public void setAisleSize(int aisleSize) { this.aisleSize = aisleSize; }

    /**
     * Gets aisle security level
     */
    public int getSecLevel() { return  secLevel; }

    /**
     * Sets security level
     */
    public void setSecLevel(int secLevel) { this.secLevel = secLevel; }


    public String toString() {
        return  "\n Floor Number= " + floorNum +
                ",\n Aisle Number= " + aisleNum +
                ",\n Aisle Size= " + aisleSize +
                ",\n Security Level= " + secLevel;
    }

    public Object getPallet() {
        return null;
    }
}

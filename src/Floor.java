public class Floor {

    private int floorNum;
    private AisleList aisleList = new AisleList();
    private int secLevel;


    /**
     * Constructor
     */
    public Floor(int floornum, int secLevel, AisleList aisleList){
        this.setFloorNum(floornum);
        this.setSecLevel(secLevel);
        this.setAisleList(aisleList);
    }

    public Floor(int floorNum, int secLevel) {
    }

    /**
     * Gets User Specified AisleList
     */
    public AisleList getAisleList() {
        return aisleList;
    }

    /**
     * Sets AisleList For this Floor
     */
    public void setAisleList(AisleList aisleList) {
        this.aisleList = aisleList;
    }

    /**
     * Gets FloorNum for this Floor
     */
    public int getFloorNum() {
        return floorNum;
    }

    /**
     * Set's Floor Number
     */
    public void setFloorNum(int floorNum) {
        this.floorNum = floorNum;
    }

    /**
     * Adds a Aisle to this Floor
     */
    public void addAisle(Aisle aisle) {
        AisleNode aisleNode = new AisleNode(aisle);
        aisleList.addAisle(aisleNode);
    }


    /**
     * Set's security level for Floor
     */
    private int setSecLevel(int secLevel) { return this.secLevel; }

    /**
     * Get's security level for Floor
     */
    private int getSecLevel(int secLevel) { return this.secLevel; }

    public String toString() {
        return "\n Floor= " + floorNum +
                ",\n Security Level= " + secLevel;
    }
}
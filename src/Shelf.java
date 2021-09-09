public class Shelf {
    /**
     * Initialises the variables needed in this class
     */
    private Pallet pallet;
    private int aisleNum;
    private AisleList aisleList;
    private String shelfName;
    private String floorNum;


    /**
     * Constructor
     * @param pallet
     * @param aisleNum
     * @param shelfName
     * @param aisleList
     */
    public Shelf(Pallet pallet, int aisleNum, String shelfName, AisleList aisleList) {
        this.setPallet(pallet);
        this.setAisleNum(aisleNum);
        this.setShelfName(shelfName);
        this.setAisleList(aisleList);
    }

    public Shelf(int aisleNum, String shelfName, AisleList aisleList) {
    }


    /**
     * Gets specified pallet
     * @return
     */
    public Pallet getPallet() { return pallet; }

    /**
     * Sets specified pallet
     * @param pallet
     */
    public void setPallet(Pallet pallet) { this.pallet = pallet; }

    /**
     * Gets AisleList
     * @return
     */
    public AisleList getAisleList() { return aisleList; }

    /**
     * Sets AisleList
     * @param aisleList
     */
    public void setAisleList(AisleList aisleList) { this.aisleList = aisleList; }

    /**
     * Gets specified ShelfName
     * @return
     */
    public String getShelfName() { return shelfName; }


    /**
     * sets shelf name
     * @param shelfName
     */
    private void setShelfName(String shelfName) {
        this.shelfName = shelfName;
    }

    @Override
    public String toString() {
        return  "\n Floor= " + floorNum +
                ",\n Aisle= " + aisleNum +
                ",\n Shelf= " + shelfName;
    }

    /**
     * sets aisle number
     * @param aisleNum
     */
    public void setAisleNum(int aisleNum) {
        this.aisleNum = aisleNum;
    }

    /**
     * gets aisle number
     * @return
     */
    public int getAisleNum() {
        return aisleNum;
    }
}

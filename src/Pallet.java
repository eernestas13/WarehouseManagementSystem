public class Pallet {

    private String palletName;
    private int palletID;
    private String productType;

    /**
     * Constructor
     * @param productType
     * @param palletID
     */
    public Pallet(String palletName, int palletID, String productType) {
        this.setProductType(palletName);
        this.setPalletID(palletID);
        this.setProductType(productType);
    }

    public Pallet(String productType, int palletID) {
    }

    /**
     * Gets specified Pallet Name
     * @return
     */
    public String getPalletName() { return palletName; }

    /**
     * Sets user specified pallet name
     * @param palletName
     */
    public void setPalletName(String palletName) {
        int maxLength = 10;
        if(palletName.length() > maxLength) {
            palletName = palletName.substring(0, maxLength);
        }
        this.palletName = palletName;
    }


    /**
     * Gets specified pallet ID
     * @return
     */
    public int getPalletID() { return  palletID; }

    /**
     * Sets pallet ID
     * @param palletID
     */
    public void setPalletID(int palletID) { this.palletID = palletID; }

    /**
     * Checks specified pallet ID
     * @param palletID
     * @return
     */
    public static int checkID ( int palletID ) {
        int a = Integer.valueOf(palletID).toString().length();
        if ((a >= 5) && (a <= 10)) {
            return 1;
        }else {
            return 0;
        }
    }


    /**
     * Sets product type of max lenght 15
     * @param productType
     */
    private void setProductType(String productType) {
        int maxLength = 15;
        if (productType.length() > maxLength) {
            productType = productType.substring(0, maxLength);
        }
        this.productType = productType;
    }

    @Override
    public String toString() {
        return  "\n Name = " + palletName +
                ",\n Gender = " + palletID;
    }
}

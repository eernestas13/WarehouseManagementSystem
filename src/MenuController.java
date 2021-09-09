import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;


import com.sun.tools.javac.Main;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class MenuController {

  /*  @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }
*/
    /**
     * Initializes the variables needed in this class
     */

    private Scanner input = new Scanner(System.in);
    private FloorList floorList = new FloorList();
    private AisleList aisleList = new AisleList();
    private ShelvesList shelvesList = new ShelvesList();
    private PalletList palletList = new PalletList();
    private Floor floor;

    /**
     * Menu Controller Constructor
     */
    public MenuController() {
        runMenu();
    }


    /**
     * Starts the Application
     */
    public static void main(String[] args) {
        new MenuController();
    }


    /**
     * Prints the Main Menu to the console for the user
     */
    private int startMenu() {
        System.out.println("		    Storage			  ");
        System.out.println("----------------------------------");
        System.out.println("1) Add a new Floor");
        System.out.println("2) Add a new Aisle to Floor");
        System.out.println("3) Add a Shelf to an Aisle");
        System.out.println("4) Add a Pallet");
        System.out.println("5) List all Floors");
        System.out.println("6) List all Aisles on a Floor");
        System.out.println("7) List all Shelves");
        System.out.println("8) List All Pallets");
        System.out.println("9) Reset System");
        System.out.println("10) Open Delete Menu");
        System.out.println("11) Search for Pallet");
        System.out.println("12) Assign a Pallet to a Shelf");
        // *Got Stuck * System.out.println("14) List All Goods");
        System.out.println("----------------------------------");
        System.out.println("13) Save System to xml");
        System.out.println("14) Load System from xml");
        System.out.println("----------------------------------");
        System.out.println("0) Exit");
        System.out.print("==>> ");
        int option = 0;
        try {
            option = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Input was not a number, try again");
            input.next();
            startMenu();
        }
        if ((option >= 0) && (option <= 13)) {
            return option;
        } else {
            System.out.println("Invalid Index selected. Try again");
            return startMenu();
        }
    }

    /**
     * Opens the Delete Menu
     */
    private int deleteMenu() {
        System.out.println("		 DELETION MENU			  ");
        System.out.println("----------------------------------");
        System.out.println("1) Delete a Floor");
        System.out.println("2) Delete an Aisle");
        System.out.println("3) Delete a Shelf");
        System.out.println("4) Delete a Pallet");
        System.out.println("5) Return to Start Menu");
        System.out.println("----------------------------------");
        System.out.println("0) Exit");
        System.out.print("==>> ");
        int option = 0;
        try {
            option = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Input was not a number, try again");
            input.next();
            startMenu();
        }
        if ((option >= 0) && (option <= 5)) {
            return option;
        } else {
            System.out.println("Invalid Index selected. Please Try again");
            return deleteMenu();
        }
    }


    /**
     * Opens the "Add Floor" menu
     */
    private Floor addFloorMenu() {
        try {
            System.out.println("Enter New Floor: ");
            int floorNum;
            floorNum = input.nextInt();
            if (floorList.findFloor(floorNum) == null) {
                System.out.println("Set floor Security:  ");
                int secLevel;
                secLevel = input.nextInt();
                Floor floor = new Floor(floorNum, secLevel);
                FloorNode floorNode = new FloorNode(floor);
                floorList.addFloor(floorNode);
                System.out.println(floorList.findFloor(floorNum).toString());
            }
        } catch (Exception e) {
            System.out.println("Error ");
        }
        return floor;
    }


    /**
     * Opens the "Add Aisle to a Floor" menu
     */
    private Aisle addAisleToFloorMenu() {
        try {
            input.nextLine();
            System.out.println("Enter Floor Number: ");
            int floorNum;
            floorNum = input.nextInt();
            if (floorList.findFloor(floorNum) != null) {
                System.out.println("What is this Aisle Called: ");
                int aisleNum;
                aisleNum = input.nextInt();

                Aisle aisle = new Aisle(floorNum, aisleNum, floorList);
                AisleNode aisleNode = new AisleNode(aisle);
                Floor floor = floorList.findFloor(floorNum);
                floor.addAisle(aisle);
                aisleList.addAisle(aisleNode);
                System.out.println(aisleList.findAisle(aisleNum).toString());
                return aisle;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return addAisleToFloorMenu();
    }


    /**
     * Opens the "Add Shelf to a Aisle" menu
     */
    private Shelf addShelfToAisleMenu() {
        try {
            input.nextLine();
            System.out.println("Enter Floor Name: ");
            int floorNum;
            floorNum = input.nextInt();
            if (floorList.findFloor(floorNum) != null) {
                System.out.println("Enter Aisle Name: ");
                int aisleNum;
                aisleNum = input.nextInt(); if (aisleList.findAisle(aisleNum) != null) {
                    System.out.println("Enter Shelf Name: ");
                    String shelfName;
                    shelfName = input.nextLine();
                    if (shelvesList.findShelf(shelfName) == null) {
                        System.out.println("Enter new Shelf Name: ");
                        shelfName = input.nextLine();

                        Shelf shelf = new Shelf(aisleNum, shelfName, aisleList);
                        ShelfNode shelfNode = new ShelfNode(shelf);
                        Aisle aisle = aisleList.findAisle(aisleNum);
                        aisle.addShelf(shelf);
                        shelvesList.addShelf(shelfNode);
                        System.out.println(shelvesList.findShelf(shelfName).toString());
                        return shelf;
                    } else {
                        System.out.println("Error");
                        return addShelfToAisleMenu();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Opens the "Add Pallet" menu
     */
    private Pallet addPalletMenu() {
        try {
            System.out.println("Enter Pallet ID: ");
            int palletID;
            palletID = input.nextInt();
            if (Pallet.checkID(palletID) == 1) {
                input.nextLine();
                if (palletList.findPallet(palletID) == null) {
                    System.out.println("Enter Product Type: ");
                    String productType;
                    productType = input.nextLine();

                    Pallet pallet = new Pallet(productType, palletID);
                    if (pallet.getPalletName() != null) {
                        PalletNode palletNode = new PalletNode(pallet);
                        palletList.addPallet(palletNode);
                        System.out.println(palletList.findPallet(palletID));
                        return pallet;
                    } else {
                        System.out.println("Error");
                        return addPalletMenu();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Controls the Menus and moves between different menus depending on the user input
     */
    private void runMenu() {
        try {
            int option = startMenu();
            //needed to consume the enter character
            input.nextLine();
            while (option != 0) {
                switch (option) {
                    case 1:
                        //input.nextLine();  //will not let user enter address for additional properties created unless this read is there
                        addFloorMenu();
                        break;
                    case 2:
                        addAisleToFloorMenu();
                        break;
                    case 3:
                        addShelfToAisleMenu();
                        break;
                    case 4:
                        addPalletMenu();
                        break;
                    case 5:
                        listAllFloors();
                        break;
                    case 6:
                        listAllAislesOnFloor();
                        break;
                    case 10:
                        int option8 = deleteMenu();
                        switch (option8) {
                            case 1:
                                input.nextLine();
                                deleteFloor();
                                break;
                            case 2:
                                input.nextLine();
                                deleteAisle();
                                break;
                            case 3:
                                input.nextLine();
                                deleteShelf();
                                break;
                            case 4:
                                deletePallet();
                                break;
                            case 5:
                                startMenu();
                                break;
                            default:
                                System.out.println("Invalid option Entered " + option8);
                                break;
                        }
                    case 12:
                        input.nextInt();
                        assignPalletToShelf();
                        break;
                    case 7:
                        input.nextInt();
                        listAllPallets();
                        break;
                    case 8:
                        input.nextInt();
                        listAllShelves();
                        break;
                    case 9:
                        input.nextInt();
                        Reset();
                        break;
                    case 11:
                        input.nextInt();
                        //Search();
                        break;
                    case 13:
                        input.nextInt();
                        save();
                        break;
                    case 14:
                        input.nextInt();
                        load();
                        break;
                }


                //pause the program so that the user can read what we just printed to the terminal window
                System.out.println("\nPress any key to continue...");
                input.nextLine();
                input.nextLine();  //this second read is required - bug in Scanner class; a String read is ignored straight after reading an int.

                //display the main menu again
                option = startMenu();
            }

            //the user chose option 0, so exit the program
            System.out.println("Exiting");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            System.out.println("\nPress any key to continue...");
            input.nextLine();

            //display the main menu again
            startMenu();
        }
    }

    /**
     * Lists All Floors in the System
     */
    private void listAllFloors() {
        int count = 1;
        if (floorList.head == null) {
            System.out.println("No floors on System");
        } else {
            FloorNode temp = floorList.head;
            while (temp != null) {
                System.out.println("Floor " + count + ")\n" + temp.getFloor().toString());
                temp = temp.getNextNode();
                count++;
                System.out.println("\n");
            }
        }
    }

    /**
     * Lists All Aisles on a Floor in the System
     */
    private void listAllAislesOnFloor() {
        int count = 1;
        if (floorList.head == null) {
            System.out.println("No floors in list");
        } else {
            System.out.println("Enter Floor Number: ");
            input.nextInt();
            int floor;
            floor = input.nextInt();
            if (floorList.findFloor(floor) != null) {
                if (floorList.findFloor(floor).getAisleList().head != null) {
                    AisleNode temp = floorList.findFloor(floor).getAisleList().head;
                    while (temp != null) {
                        System.out.println("Floor Number = " + floor + "\n\n" + "Aisle: " + count + ")\n" + temp.getAisle().toString());
                    }
                } else {
                    System.out.println("No Aile's on Floor");
                }
            }

        }
    }

    /**
     * Opens the "Remove Floor" menu
     */
    private void deleteFloor() {
        System.out.println("Enter Floor Number to be Deleted: ");
        int floorNum;
        floorNum = input.nextInt();
        if (floorList.findFloor(floorNum) != null) {
            System.out.println("Deleting \n" + floorList.findFloor(floorNum).toString());
            floorList.deleteFloor(floorNum);
            System.out.println("Delete Successful");
        } else {
            System.out.println("Error in Deleting...");
            deleteMenu();
        }
    }

    /**
     * Opens the "Remove Aisle from Floor" menu
     */
    private void deleteAisle() {
        System.out.println("Enter Aisle Number: ");
        int floorNum;
        floorNum = input.nextInt();
        if (floorList.findFloor(floorNum) != null) {
            AisleNode aisle1List = floorList.findFloor(floorNum).getAisleList().head;
            while (aisle1List != null) {
                System.out.println(aisle1List.toString());
                aisle1List = aisle1List.getNextNode();
            }
            System.out.println("Enter Aisle Number: ");
            int aisleNum;
            aisleNum = input.nextInt();
            System.out.println("Deleting \n" + aisleList.findAisle(aisleNum).toString());
            aisleList.deleteAisle(aisleNum);
        }
    }

    /**
     * Opens the "Remove Shelf from Aisle" menu
     */
    private void deleteShelf() {
        System.out.println("Enter Floor Number");
        int floorNum;
        floorNum = input.nextInt();
        if (floorList.findFloor(floorNum) != null) {
            System.out.println("Enter Aisle Number: ");
            int aisleNum;
            aisleNum = input.nextInt();
            if (floorList.findFloor(floorNum).getAisleList().findAisle(aisleNum) != null) {
                ShelfNode shelf1List = floorList.findFloor(floorNum).getAisleList().findAisle(aisleNum).getShelvesList().head;
                while (shelf1List != null) {
                    System.out.println(shelf1List.toString());
                    shelf1List = shelf1List.getNextNode();
                }
                System.out.println("Enter Shelf Name: ");
                String shelfName;
                shelfName = input.nextLine();
                System.out.println("Deleting \n" + shelvesList.findShelf(shelfName).toString());
                shelvesList.deleteShelf(shelfName);
            }
        }
    }

    /**
     * Opens the "Remove Pallet from Shelf" menu
     */
    private void deletePallet() {
        System.out.println("Enter Pallet ID: ");
        int palletID;
        palletID = input.nextInt();
        //input.nextLine();
        if (palletList.findPallet(palletID) != null) {
            System.out.println("Deleting \n" + palletList.findPallet(palletID).toString());
            palletList.deletePallet(palletID);
        }
    }

    /**
     * Opens the "Pallet Student to Shelf" menu
     */
    private void assignPalletToShelf() {
        System.out.println("Enter Floor: ");
        int floorNum;
        floorNum = input.nextInt();
        if (floorList.findFloor(floorNum) != null) {
            System.out.println("Enter Aisle: ");
            int aisleNum;
            aisleNum = input.nextInt();
            if (floorList.findFloor(floorNum).getAisleList().findAisle(aisleNum) != null) {
                System.out.println("Enter Shelf Name: ");
                String shelfName;
                shelfName = input.nextLine();                                                                                                                       /*somethings wrong with getPallet */
                if ((floorList.findFloor(floorNum).getAisleList().findAisle(aisleNum) != null) && (floorList.findFloor(floorNum).getAisleList().findAisle(aisleNum).getPallet() == null)) {
                    System.out.println("Enter Pallet ID to add Pallet to Shelf: ");
                    int palletID;
                    palletID = input.nextInt();
                    if (palletList.findPallet(palletID) != null) {
                        floorList.findFloor(floorNum).getAisleList().findAisle(aisleNum).getShelvesList().findShelf(shelfName).setPallet(palletList.findPallet(palletID));
                        System.out.println(floorList.findFloor(floorNum).getAisleList().findAisle(aisleNum).getShelvesList().findShelf(shelfName).toString());
                    }
                } else {
                    System.out.println("Error");
                    assignPalletToShelf();
                }
            }
        }
    }

    /**
     * Lists All Pallets in the System
     */
    private void listAllPallets() {
        int count = 1;
        if (palletList.head == null) {
            System.out.println("No Pallets in System. ");
        } else {
            PalletNode temp = palletList.head;
            while (temp != null) {
                System.out.println("Pallet " + count + ")\n" + temp.getPallet().toString());
                temp = temp.getNextNode();
                count++;
                System.out.println("\n");
            }
        }
    }

    /**
     * Lists All Shelves in the System
     */
    private void listAllShelves() {
        int count = 1;
        FloorNode floorrList = floorList.head;
        AisleNode aisleeList = aisleList.head;
        ShelfNode shelfList = shelvesList.head;
        if (floorList.head == null) {
            System.out.println("No Floors in System. ");
        } else {
            while (floorrList != null) {
                //System.out.println();
                if (floorrList.getFloor().getAisleList().head == null) {
                    System.out.println("No Aisles on this Floor. ");
                } else {
                    while (aisleeList != null) {
                        if (aisleeList.getAisle().getShelvesList().head == null) {
                            System.out.println("No Shelves on this Aisle. ");
                        } else {
                            while (shelfList != null) {
                                System.out.println("Shelf " + count + ")\n" + shelfList.getShelf().toString());
                                shelfList = shelfList.getNextNode();
                                count++;
                                System.out.println("\n");
                            }
                        }
                    }
                    aisleeList = aisleeList.getNextNode();
                }
            }
            floorrList = floorrList.getNextNode();
        }
    }

    /**
     * Reset's the System
     */
    private void Reset() {
        floorList.Reset();
        System.out.println("System has been Reset.");
        startMenu();
    }


    /**
     * Searches the System for a specific Pallet
     */
    /*
    private void Search() {
        System.out.println("Enter Pallet ID: ");
        int palletID;
        input.nextInt();
        if (palletList.findPallet(palletID) != null) {
            input.contains("");
        }
    }
     */
    public void load() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("floors.xml"));
        floorList = (FloorList)is.readObject();
        is.close();
    }

    public void save() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("floors.xml"));
        out.writeObject(floorList);
        out.close();
        runMenu();
    }

}

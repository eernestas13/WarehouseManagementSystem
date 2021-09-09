public class ShelvesList {

    public ShelfNode head;
    private ShelfNode tail;

    /**
     * Adds shelfNode to shelfList
     * @param shelfNode
     */
    public void addShelf(ShelfNode shelfNode) {
        if (tail == null) {
            head = shelfNode;
            tail = shelfNode;
        } else {
            tail.setNextNode(shelfNode);
            tail = shelfNode;
        }
    }

    /**
     * Searches through shelfList for searched shelfNode
     * @param shelfName
     * @return
     */
    public Shelf findShelf(String shelfName) {
        if (head == null) {
            System.out.println("No Shelves located");
            return null;
        } else {
            ShelfNode temp = head;
            while ((temp != null) && (!temp.getShelf().getShelfName().equals(shelfName)))
                temp = temp.getNextNode();
            return temp == null ? null : temp.getShelf();
        }
    }



    /**
     * Deletes a shelfNode from the shelfList
     * @param shelfName
     */
  public void deleteShelf(String shelfName) {
      ShelfNode temp = head;
      ShelfNode previous = null;
      if(temp != null && temp.shelf.getShelfName()==shelfName) {
          head=temp.nextNode;
          return;
      }
      while (temp!=null && temp.getShelf().getShelfName()!=shelfName) {
          previous = temp;
          temp = temp.nextNode;
      }
      if (temp == null) {
          return;
      }
      previous.nextNode = temp.nextNode;
  }

}

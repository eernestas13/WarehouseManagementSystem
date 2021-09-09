public class AisleList {

    AisleNode head;
    AisleNode tail;

    /**
     * Adds a AisleNode to the FloorList
     * @param aisleNode AisleNode added to list
     */
    public void addAisle(AisleNode aisleNode) {

        if(tail == null) {
            head = aisleNode;
            tail = aisleNode;

        }
        else {
            tail.setNextNode(aisleNode);
            tail = aisleNode;
        }
    }

    /**
     * Goes through aislelist for the searched AisleNode
     * @param aisleNum aisleName to be searched
     * @return found / not found
     */
    public Aisle findAisle(int aisleNum) {
        if (head == null) {
            System.out.println("No Aisles on this Floor");
            return null;
        }
        else {
            AisleNode temp = head;
            //while ((temp != null) && (!temp.getAisle().getAisleNum().equals(aisleNum)))
            temp = temp.getNextNode();
            return temp == null ? null : temp.getAisle();
        }
    }



    /**
     * Deletes a AisleNode from the AisleList
     * @param aisleNum AisleNode to delete
     */
   public void deleteAisle(int aisleNum) {
       AisleNode temp = head;
       AisleNode previous = null;
       if(temp != null && temp.aisle.getAisleNum()==aisleNum) {
           head=temp.nextNode;
           return;
       }
       while (temp!=null && temp.getAisle().getAisleNum()!=aisleNum) {
           previous = temp;
           temp = temp.nextNode;
       }
       if (temp == null) {
           return;
       }
       previous.nextNode = temp.nextNode;
   }

}

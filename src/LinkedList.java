public class LinkedList {
    private Node head = null;
    private int extension = 0;

    public int getExtension() {
        return extension;
    }

    public boolean isEmpty(){
        return this.head == null;
    }
    public void insertFirst(String data){
        Node node = new Node(data);
        if(isEmpty()){
            this.head = node;
            this.extension++;
        } else{
            Node temp = this.head;
            this.head = node;
            node.setNext(temp);
            this.extension++;
        }
    }

    public void insertLast(String data){
        Node node = new Node(data);
        if(isEmpty()){
            this.head = node;
            this.extension++;
        } else{
            Node temp = this.head;
            while(temp.getNext()!=null){
                temp = temp.getNext();
            }
            temp.setNext(node);
            this.extension++;
        }
    }

    public void insertPosicion(int position, String data) {
        if(position > this.extension){
            System.out.println("Invalid position");
        } else if(position==1){
            insertFirst(data);
        } else{
            Node temp = this.head;
            while((position-2)!=0){
                temp = temp.getNext();
                position--;
            }
            Node node = new Node(data);
            node.setNext(temp.getNext());
            temp.setNext(node);
            this.extension++;
        }
    }

    public boolean isNode(String data){
        Node temp = this.head;
        int nodesLeft = this.extension;
        while(nodesLeft!=0){
            if(temp.getData()==data){
                return true;
            }
            else{
                temp = temp.getNext();
                nodesLeft--;
            }
        }
        return false;
    }

    public int searchPosition(String data){
        if(isNode(data)){
            Node temp = this.head;
            int position = 1;
            while(temp.getData().equals(data)==false){
                temp=temp.getNext();
                position++;
            }
            return position;
        }
        else{
            return -1;
        }
    }

    public void editNode(int position, String newData){
        if(position<=0 || position>this.extension){
            System.out.println("The node doesn't exists");
        }else{
            Node temp = this.head;
            int counter = 1;
            while(counter!=position){
                temp = temp.getNext();
                counter++;
            }
            temp.setData(newData);
        }
    }

    public void editNodebyData(String previousData, String newData){
        editNode(searchPosition(previousData), newData);
    }

    public void deleteFirstnode(){
        Node temp = this.head;
        this.head = temp.getNext();
    }

    public void deleteLastnode(){
        Node temp = this.head;
        while(temp.getNext().getNext()!=null){
            temp=temp.getNext();
        }
        temp.setNext(null);
    }

    public void deleteNodebyData(String data){
        int position = searchPosition(data);
        if(position<=0 || position>this.extension) {
            System.out.println("Couldn't find the node");
        }else if(position==1) {
            deleteFirstnode();
        }else if(position==this.extension){
            deleteLastnode();
        } else{
            Node temp = this.head;
            int counter = 1;
            while((counter+1)!=position){
                temp = temp.getNext();
                counter++;
            }
            temp.setNext(temp.getNext().getNext());
        }
    }

    public void retrnList(){
        if(isEmpty()){
            System.out.println("List empty");
        } else{
            System.out.println("List: ");
            Node temp = this.head;
            while(temp != null){
                System.out.println("["+temp.getData()+"] ");
                temp = temp.getNext();
            }
        }
    }
}

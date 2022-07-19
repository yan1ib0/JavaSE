package cc.excalibur.list;

public class MyLinkedList<T>  implements MyList<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;


    private void linklast(T element){
        Node<T> l=last;
        Node<T> newnode=new Node<>(l,element,null);
        last=newnode;
        if(l==null){
            newnode.prev=null;
            first=newnode;
        }else{
            l.next=newnode;
        }
        size++;
    }


    private void rangeCheck(int index) throws Exception {
        if(index<0||index>=size){
            throw new Exception("数组越界 idnex:"+index+" size:"+size);
        }
    }
    private Node<T> node(int index){
        Node<T> targetNode;
        if(index<(size>>1)){
            targetNode=first;
            for (int i=0;i<index;i++) {
                targetNode=targetNode.next;
            }
        }else{
            targetNode=last;
            for (int i=0;i<index;i++) {
                targetNode=targetNode.prev;
            }
        }
        return  targetNode;
    }
    @Override
    public boolean add(T ele) {
        this.linklast(ele);
        return true;
    }

    @Override
    public T get(int index) {
        try {
            this.rangeCheck(index);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Node<T> targetnode=this.node(index);

        return targetnode.val;
    }

    private T unlink(Node<T> tNode){
        T oldval=tNode.val;
        Node<T> prev=tNode.prev;
        Node<T> next=tNode.next;
        if(prev==null){
            first=next;
        }
        else {
            prev.next = next;
            tNode.prev = null;
        }
        if(next==null)
            last=prev;
        else{
            next.prev=prev;
            tNode.next=null;
        }
        size--;
        return tNode.val;
    }
    @Override
    public T remove(int index) {
        try {
            this.rangeCheck(index);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Node<T> targetnode=this.node(index);
        return  unlink(targetnode);
    }

    @Override
    public int size() {
        return size;
    }
}

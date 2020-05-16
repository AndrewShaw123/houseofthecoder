/**
 * AVL树
 *
 * @author andrew
 * @date 2020/2/10
 */
public class AvlTree {


    public static int height(AvlNode t){
        if(t==null){
            return -1;
        }else{
            return t.height;
        }
    }

    /**
     * 左左型 右旋转
     * @param t 需要旋转的根节点
     * @return 旋转后需要旋转的根节点
     */
    public AvlNode rightRotate(AvlNode t){
        AvlNode t1 = t.leftChild;
        t.leftChild = t1.rightChild;
        t1.rightChild = t;
        t.height = Math.max(height(t.leftChild),height(t.rightChild))+1;
        t1.height = Math.max(height(t1.leftChild),height(t1.rightChild))+1;
        return t1;
    }

    /**
     * 右右型 左旋转
     * @param t 需要旋转的根节点
     * @return 旋转后需要旋转的根节点
     */
    public AvlNode leftRotate(AvlNode t){
        AvlNode t1 = t.rightChild;
        t.rightChild = t1.leftChild;
        t1.leftChild = t;
        t.height = Math.max(height(t.leftChild),height(t.rightChild))+1;
        t1.height = Math.max(height(t1.leftChild),height(t1.rightChild))+1;
        return t1;
    }

    /**
     * 左右型 先左旋转->再右旋转
     * @param t 需要旋转的根节点
     * @return 旋转后需要旋转的根节点
     */
    public AvlNode leftRightRotate(AvlNode t){
        t.leftChild = leftRotate(t.leftChild);
        AvlNode t1 = rightRotate(t);
        return t1;
    }

    /**
     * 右左型 先右旋转->再左旋转
     * @param t 需要旋转的根节点
     * @return 旋转后需要旋转的根节点
     */
    public AvlNode rightLeftRotate(AvlNode t){
        t.rightChild = rightRotate(t.rightChild);
        AvlNode t1 = leftRotate(t);
        return t1;
    }

    /**
     * 插入AVL树
     * @param data 插入的数据
     * @param t
     * @return
     */
    public AvlNode insert(int data , AvlNode t){

        if(t==null){
            t = new AvlNode();
            t.data = data;
            t.leftChild = t.rightChild = null;
        }else if(data < t.data){
            t.leftChild = insert(data,t.leftChild);
            if(height(t.leftChild)-height(t.rightChild)==2){
                if(data < t.leftChild.data){
                    //左左型
                    t = rightRotate(t);
                }else{
                    //左右型
                    t = leftRightRotate(t);
                }
            }
        }else if(data > t.data){
            t.rightChild = insert(data,t.rightChild);
            if(height(t.rightChild)-height(t.leftChild)==2){
                if(data > t.rightChild.data){
                    //右右型
                    t = leftRotate(t);
                }else{
                    //右左型
                    t = rightLeftRotate(t);
                }
            }
        }


        t.height = Math.max(height(t.leftChild),height(t.rightChild))+1;
        return t;
    }

}

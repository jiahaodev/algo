package algo.lesson08;

/**
 * 使用前后栈实现浏览器的前进后退。
 * 两个栈
 * @author JiahaoWu
 */
public class SampleBrowser {

    private String curPage;
    private LinkedListBasedStack backStack;
    private LinkedListBasedStack forwardStack;

    public SampleBrowser(){
        this.backStack = new LinkedListBasedStack();
        this.forwardStack = new LinkedListBasedStack();
    }

    //核心1：打开
    public void open(String url){
        if (curPage != null) {
            backStack.push(curPage);
        }
        showUrl(url,"Open");
    }

    //核心2：后退
    public String goBack(){
        if(canGoBack()){
            forwardStack.push(curPage); //旧数据入栈
            String backUrl = backStack.pop(); //取  目的 数据，出栈
            showUrl(backUrl,"Back");
            return backUrl;
        }
        return null;
    }


    //核心3：前进
    public String goForward(){
        if (canGoForward()) {
            backStack.push(curPage);//旧数据入栈
            String forwardUrl = forwardStack.pop();//取  目的 数据，出栈
            showUrl(forwardUrl,"Forward");
            return forwardUrl;
        }
        return null;
    }

    public boolean canGoBack(){
        return backStack.size() > 0;
    }

    public boolean canGoForward(){
        return forwardStack.size() > 0;
    }


    public void showUrl(String url, String prefix) {
        this.curPage = url; //记录当前页面
        System.out.println(prefix + " page == " + url);
    }

    public void checkCurrentPage() {
        System.out.println("Current page is: " + this.currentPage);
    }


    /*------------------------------------------------------*/

    //基于链表的栈
    public static class LinkedListBasedStack{

        private int size;
        private Node top;

        //根据数据构建节点，并建立next指向关系
        static Node createNode(String data,Node next){
            return new Node(data,next);
        }

        public void clear(){
            this.top = null;
            this.size = 0;
        }

        public void push(data){
            Node node = createNode(data,top);
            top = node;
            size++;
        }

        public String pop(){
            Node popNode = top;
            if (popNode == null) {
                return null;
            }
            top = popNode.next;
            size--;
            return popNode.data; //实现是链式栈，但是调用者关注的主要是节点中的数据
        }

        public String getTopData(){
            if (top == null) {
                return null;
            }
            return top.data;
        }

        public int size(){
            return size;
        }

        public void print() {
            System.out.println("Print stack:");
            Node currentNode = top;
            while (currentNode != null) {
                String data = currentNode.getData();
                System.out.print(data + "\t");
                currentNode = currentNode.next;
            }
            System.out.println();
        }


        //定义节点类
        public static class Node{
            
            private String data;
            private Node next;
            
            public Node(String data){
                this(data,null);
            }
            public Node(String data,Node next){
                this.data = data;
                this.next = next;
            }

            public void setData(String data){
                this.data = data;
            }
            public String getData(){
                return this.data;
            }

            public void setNext(Node next){
                this.next = next;
            }
            public Node getNext(){
                return this.next;
            }
        }

    }

}

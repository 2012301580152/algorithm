package whu.hydro.algorithm.tree;

import java.util.*;

/**
 * @ClassName BinaryTree
 * @Description TODO
 * @Author 86187
 * @Date 2019/3/9 19:45
 * @Version 1.0
 */
public class BinaryTree {


    BinaryTreeNode Construct(int[] preorder, int[] inorder) {
        if (preorder==null || preorder==null ||
                preorder.length!=inorder.length || preorder.length==0) {
            return null;
        }


        return ConstructCore(preorder, 0, preorder.length-1,
                inorder, 0, inorder.length-1);

    }

    private int getIndex(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (key==arr[i]){
                return i;
            }
        }
        return -1;
    }

    BinaryTreeNode ConstructCore(int[] preorder, int preFirst, int preEnd,
                                 int[] inorder, int inFirst, int inEnd) {
        int rootValue = preorder[preFirst];
        BinaryTreeNode root = new BinaryTreeNode(rootValue);
        int inRootPosition = getIndex(inorder, rootValue);
        int leftLength = inRootPosition - inFirst;
        int rightLength = inEnd - inRootPosition;

        BinaryTreeNode left;
        BinaryTreeNode right;

        if (leftLength==0) {
            left = null;
        } else if (leftLength==1) {
            left = new BinaryTreeNode(inorder[inFirst]);
        } else {
            left = ConstructCore(preorder, preFirst+1, preFirst+leftLength,
                    inorder, inFirst, inRootPosition-1);
        }
        root.setLeft(left);

        if (rightLength==0) {
            right = null;
        } else if (rightLength==1) {
            right = new BinaryTreeNode(inorder[inEnd]);
        } else {
            right = ConstructCore(preorder, preFirst+leftLength+1, preEnd,
                    inorder, inRootPosition+1, inEnd);
        }
        root.setRight(right);

        return root;

    }

    private void preOrderPrint(BinaryTreeNode root) {
        System.out.print(root.getValue()+",");
        if (root.getLeft()!=null) {
            preOrderPrint(root.getLeft());
        }

        if(root.getRight() != null) {
            preOrderPrint(root.getRight());
        }
    }

    private void inOrderPrint(BinaryTreeNode root) {
        if (root.getLeft()!=null) {
            inOrderPrint(root.getLeft());
        }

        System.out.print(root.getValue()+",");

        if(root.getRight() != null) {
            inOrderPrint(root.getRight());
        }
    }

    private void endOrderPrint(BinaryTreeNode root) {
        if (root.getLeft()!=null) {
            endOrderPrint(root.getLeft());
        }
        if(root.getRight() != null) {
            endOrderPrint(root.getRight());
        }

        System.out.print(root.getValue()+",");
    }

    private void preOrderLoopPrintNotSame(BinaryTreeNode root) {

        Stack<BinaryTreeNode> nodeContainer = new Stack<>();
        Set set = new HashSet();
        BinaryTreeNode current = root;
        boolean hasPrint = false;

        while (current != null) {
            int currentValue = current.getValue();
            hasPrint = set.contains(currentValue);

            if (!hasPrint) {
                System.out.println(currentValue);
                set.add(currentValue);
            }

            if (current.getLeft()!=null && !hasPrint) {
                nodeContainer.push(current);
                current = current.getLeft();
            } else if (current.getRight()!=null && !hasPrint) {

                nodeContainer.push(current);
                current = current.getRight();
            } else {
                if (nodeContainer.isEmpty()) {
                    break;
                }

                current = nodeContainer.pop();
            }
        }
    }


    private void preOrderLoopPrint(BinaryTreeNode root) {

        Stack<BinaryTreeNode> nodeContainer = new Stack<>();
        Stack<Boolean> leftDirection = new Stack<>();
        BinaryTreeNode current = root;
        boolean fromLeft = false;
        boolean fromRight = false;

        while (current != null) {
            if (!fromLeft && !fromRight) {
                System.out.println(current.getValue());
            }
            if (current.getLeft()!=null && !fromLeft && !fromRight) {
                fromLeft = false;
                fromRight = false;
                nodeContainer.push(current);
                leftDirection.push(true);
                current = current.getLeft();
            } else if (current.getRight()!=null && !fromRight) {
                fromLeft = false;
                fromRight = false;
                nodeContainer.push(current);
                leftDirection.push(false);
                current = current.getRight();
            } else {
                if (nodeContainer.isEmpty()) {
                    break;
                }
                fromLeft = leftDirection.pop();
                fromRight = !fromLeft;
                current = nodeContainer.pop();
            }
        }
    }


    private void inOrderLoopPrint(BinaryTreeNode root) {

        Stack<BinaryTreeNode> nodeContainer = new Stack<>();
        Stack<Boolean> leftDirection = new Stack<>();
        BinaryTreeNode current = root;
        boolean fromLeft = false;
        boolean fromRight = false;

        while (current != null) {
            if (fromLeft || (current.getLeft()==null&&!fromRight)) {
                System.out.println(current.getValue());
            }
            if (current.getLeft()!=null && !fromLeft && !fromRight) {
                fromLeft = false;
                fromRight = false;
                nodeContainer.push(current);
                leftDirection.push(true);
                current = current.getLeft();
            } else if (current.getRight()!=null && !fromRight) {
                fromLeft = false;
                fromRight = false;
                nodeContainer.push(current);
                leftDirection.push(false);
                current = current.getRight();
            } else {
                if (nodeContainer.isEmpty()) {
                    break;
                }
                fromLeft = leftDirection.pop();
                fromRight = !fromLeft;
                current = nodeContainer.pop();
            }
        }
    }



    private void orderLoopPrint(BinaryTreeNode root, String orderType) {
        Stack<BinaryTreeNode> nodeContainer = new Stack<>();
        Stack<Boolean> leftDirection = new Stack<>();
        BinaryTreeNode current = root;
        boolean fromLeft = false;
        boolean fromRight = false;

        while (current != null) {
            if (isPrintable(current, fromLeft, fromRight, orderType)) {
                System.out.println(current.getValue());
            }
            if (current.getLeft()!=null && !fromLeft && !fromRight) {
                fromLeft = false;
                fromRight = false;
                nodeContainer.push(current);
                leftDirection.push(true);
                current = current.getLeft();
            } else if (current.getRight()!=null && !fromRight) {
                fromLeft = false;
                fromRight = false;
                nodeContainer.push(current);
                leftDirection.push(false);
                current = current.getRight();
            } else {
                if (nodeContainer.isEmpty()) {
                    break;
                }
                fromLeft = leftDirection.pop();
                fromRight = !fromLeft;
                current = nodeContainer.pop();
            }
        }
    }

    private void BinaryType(BinaryTreeNode root) {

        if (root != null) {
            Stack<BinaryTreeNode> nodeContainer = new Stack<>();
            Stack<Integer> type = new Stack<>();
            nodeContainer.push(root);
            type.push(0);
            int currentType = 0;

            while (!nodeContainer.isEmpty()) {
//                if (currentType==2) {
                    System.out.println(root.getValue());
//                }
                if (root.getLeft()!=null && currentType==0) {
                    nodeContainer.push(root);
                    type.push(currentType);
                    currentType = 0;
                    root = root.getLeft();
                } else if (root.getRight()!=null && currentType==1) {
                    nodeContainer.push(root);
                    type.push(currentType);
                    currentType = 0;
                    root = root.getRight();
                } else {

                    if (currentType < 2) {
                        currentType++;
                    } else {
                        root = nodeContainer.pop();
                        currentType = type.pop()+1;
                    }
                }
            }
        }

    }



    private void BinaryType2(BinaryTreeNode root) {
        if (root != null) {
            Stack<BinaryTreeNode> stack = new Stack<>();
            Stack<Integer> type = new Stack<>();
            stack.push(root);
            type.push(0);
            int currentType = 0;
            while (!stack.isEmpty()) {
                root = stack.pop();
                currentType = type.pop()+1;
                if (root.getLeft()!=null) {
                    stack.push(root.getLeft());
                    type.push(0);
                }

                if (root.getRight()!=null) {
                    stack.push(root.getRight());
                    type.push(0);
                } else {
                    currentType++;
                }

//                if (currentType)
            }
        }


    }


    boolean isPrintable(BinaryTreeNode current, boolean fromLeft, boolean fromRight, String orderType) {
        switch (orderType) {
            case "pre": return !fromLeft && !fromRight;
            case "in": return fromLeft || (current.getLeft()==null&&!fromRight);
            case "end": return fromRight || (fromLeft&&current.getRight()==null) || (current.getLeft()==null&&current.getRight()==null);
        }
        return false;
    }



    public static void main(String[] args) {
        int[] preorder = {1,2,4,7,3,5,6,8};
        int[] inorder = {4,7,2,1,5,3,8,6};
        BinaryTree binaryTree = new BinaryTree();
        BinaryTreeNode root = binaryTree.Construct(preorder, inorder);

        binaryTree.preOrderPrint(root);
        System.out.println();
        binaryTree.inOrderPrint(root);
        System.out.println();
        binaryTree.endOrderPrint(root);
        System.out.println();
        binaryTree.BinaryType(root);
    }
}

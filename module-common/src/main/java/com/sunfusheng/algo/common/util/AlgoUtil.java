package com.sunfusheng.algo.common.util;

import com.sunfusheng.algo.common.model.DoubleNode;
import com.sunfusheng.algo.common.model.Node;

import java.util.List;

/**
 * @author sunfusheng
 * @since 2020-02-22
 */
public class AlgoUtil {

    // 打印一维数组
    public static void printArray(int[] arr) {
        printArray(arr, false);
    }

    public static void printlnArray(int[] arr) {
        printArray(arr, true);
    }

    public static void printArray(int[] arr, boolean br) {
        if (arr == null || arr.length == 0) {
            System.out.println("[]");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        if (br) {
            System.out.println(sb);
        } else {
            System.out.print(sb);
        }
    }

    // 打印二维数组
    public static void printArray2(int[][] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("[[]]");
            return;
        }

        System.out.println("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("  ");
            printArray(arr[i]);
            if (i < arr.length - 1) {
                System.out.println(", ");
            }
        }
        System.out.println("\n]");
    }

    // 打印列表
    public static void printList(List<Integer> list) {
        printList(list, false);
    }

    public static void printlnList(List<Integer> list) {
        printList(list, true);
    }

    public static void printList(List<Integer> list, boolean br) {
        if (list == null || list.size() == 0) {
            System.out.println("[]");
            return;
        }

        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        printArray(arr, br);
    }

    // 打印列表2
    public static void printList2(List<List<Integer>> lists) {
        if (lists == null || lists.size() == 0) {
            System.out.println("[[]]");
            return;
        }

        System.out.println("[");
        for (int i = 0; i < lists.size(); i++) {
            System.out.print("  ");
            printList(lists.get(i));
            if (i < lists.size() - 1) {
                System.out.println(", ");
            }
        }
        System.out.println("\n]");
    }

    // 构造单向链表
    public static Node createLinkedList(int... values) {
        if (values == null || values.length == 0) {
            return null;
        }

        Node head = null;
        Node pre = null;
        Node next = null;
        for (int value : values) {
            if (head == null) {
                head = new Node(value);
                pre = head;
            } else {
                next = new Node(value);
                pre.next = next;
                pre = next;
            }
        }
        return head;
    }

    // 打印单向链表
    public static void printLinkedList(Node head) {
        if (head == null) {
            System.out.println("null");
            return;
        }

        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.value);
            head = head.next;
            if (head != null) {
                sb.append(" -> ");
            }
        }
        System.out.println(sb);
    }

    // 构造双向链表
    public static DoubleNode createDoubleLinkedList(int... values) {
        if (values == null || values.length == 0) {
            return null;
        }

        DoubleNode head = null;
        DoubleNode pre = null;
        DoubleNode next = null;
        for (int value : values) {
            if (head == null) {
                head = new DoubleNode(value);
                pre = head;
            } else {
                next = new DoubleNode(value);
                next.last = pre;
                pre.next = next;
                pre = next;
            }
        }
        return head;
    }

    // 打印双向链表
    public static void printDoubleLinkedList(DoubleNode head) {
        if (head == null) {
            System.out.println("null");
            return;
        }

        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.value);
            head = head.next;
            if (head != null) {
                sb.append(" <=> ");
            }
        }
        System.out.println(sb);
    }

    // 构造环形的单向链表
    public static Node createCircleLinkedList(int... values) {
        if (values == null || values.length == 0) {
            return null;
        }

        Node head = null;
        Node pre = null;
        Node next = null;
        for (int value : values) {
            if (head == null) {
                head = new Node(value);
                pre = head;
            } else {
                next = new Node(value);
                pre.next = next;
                pre = next;
            }
        }
        pre.next = head;
        return head;
    }

    // 打印单向链表
    public static void printCircleLinkedList(Node head, int times) {
        if (head == null || times < 1) {
            System.out.println("null");
            return;
        }

        Node node = head;
        StringBuilder sb = new StringBuilder();
        while (times != 0) {
            sb.append(node.value).append(" -> ");
            node = node.next;
            if (node == head) {
                times--;
            }
        }
        System.out.println(sb);
    }
}

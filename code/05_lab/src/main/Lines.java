package main;

import java.util.HashSet;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Lines extends LinkedList2 {
    private boolean allOk;
    private Integer n;
    private Integer nHelper;

    public Lines() {
        super();
        allOk = true;
    }


    public Stream<Node<String>> getStream() {
        return StreamSupport.stream(this.spliterator(), false).filter((node) -> {
            if (node.prev == null) {
                return node.value.contains(node.next.value);
            }
            else if (node.next == null) {
                return node.value.contains(node.prev.value);
            }
            else {
                return node.value.contains(node.prev.value) && node.value.contains(node.next.value);
            }
        });
    }

    private int getMaxLen() {
        nHelper = Integer.MIN_VALUE;
        this.forEach((node) -> {
            if (node.value.length() > nHelper) {
                nHelper = node.value.length();
            }
        });
        return nHelper;
    }

    public Optional<Integer> getOptional() {
        n = Integer.MAX_VALUE;
        HashSet<Integer> used = new HashSet<Integer>();

        this.forEach((node) -> {
            int len = node.value.length();
            if (!used.contains(len)) {
                used.add(len);
                allOk = true;
                this.forEach((nestedNode) -> {
                    if (nestedNode.prev == null && nestedNode.next == null) {
                        if (nestedNode.value.length() <= len) {
                            allOk = false;
                        }
                    }
                    else if (nestedNode.prev == null) {
                        if (nestedNode.value.length() > len && nestedNode.value.contains(nestedNode.next.value)) {
                            allOk = false;
                        }
                    }
                    else if (nestedNode.next == null) {
                        if (nestedNode.value.length() > len && nestedNode.value.contains(nestedNode.prev.value)) {
                            allOk = false;
                        }
                    }
                    else {
                        if (nestedNode.value.length() > len &&
                                ((nestedNode.value.contains(nestedNode.prev.value) || (nestedNode.value.contains(nestedNode.next.value))))) {
                            allOk = false;
                        }
                    }
                });
                if (allOk && len < n) {
                    n = len;
                }
            }
        });
        int maxLen = getMaxLen();
        if (n == Integer.MAX_VALUE || n == maxLen) {
            n = null;
        }
        return Optional.ofNullable(n);
    }
}

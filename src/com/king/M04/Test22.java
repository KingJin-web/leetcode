package com.king.M04;

import java.util.*;

/**
 * @program: leetcode
 * https://leetcode-cn.com/problems/top-k-frequent-words/
 * @description: 692. 前K个高频单词
 * @author: King
 * @create: 2021-05-20 23:37
 */
public class Test22 {
    static String[] arr = {"i", "love", "leetcode", "i", "love", "coding"};

    /**
     * 执行用时：9 ms, 在所有 Java 提交中击败了24.99%的用户
     * 内存消耗：38.7 MB, 在所有 Java 提交中击败了50.78%的用户
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequent(String[] words, int k) {
        List<String> ls = new ArrayList<>();
        Map<String, Integer> cnt = new HashMap<String, Integer>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            ls.add(entry.getKey());
        }
        ls.sort(new Comparator<String>() {
            public int compare(String word1, String word2) {
                return cnt.get(word1).equals(cnt.get(word2)) ? word1.compareTo(word2) : cnt.get(word2) - cnt.get(word1);
            }
        });
        return ls.subList(0,k);
    }

    public static void main(String[] args) {
        Test22 test22 = new Test22();
        test22.topKFrequent(arr,3);
    }

    class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            Map<String, Integer> cnt = new HashMap<String, Integer>();
            for (String word : words) {
                cnt.put(word, cnt.getOrDefault(word, 0) + 1);
            }
            PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<Map.Entry<String, Integer>>(new Comparator<Map.Entry<String, Integer>>() {
                public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                    return entry1.getValue() == entry2.getValue() ? entry2.getKey().compareTo(entry1.getKey()) : entry1.getValue() - entry2.getValue();
                }
            });
            for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
                pq.offer(entry);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
            List<String> ret = new ArrayList<String>();
            while (!pq.isEmpty()) {
                ret.add(pq.poll().getKey());
            }
            Collections.reverse(ret);
            return ret;
        }
    }


        public List<String> topKFrequent1(String[] words, int k) {
            Map<String, Integer> cnt = new HashMap<String, Integer>();
            for (String word : words) {
                cnt.put(word, cnt.getOrDefault(word, 0) + 1);
            }
            PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<Map.Entry<String, Integer>>(new Comparator<Map.Entry<String, Integer>>() {
                public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                    return entry1.getValue() == entry2.getValue() ? entry2.getKey().compareTo(entry1.getKey()) : entry1.getValue() - entry2.getValue();
                }
            });
            for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
                pq.offer(entry);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
            List<String> ret = new ArrayList<String>();
            while (!pq.isEmpty()) {
                ret.add(pq.poll().getKey());
            }
            Collections.reverse(ret);
            return ret;
        }


}


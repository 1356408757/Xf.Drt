package com.trust.xfyl.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * TODO
 * 
 * @Description
 * @author Bay-max
 * @date 2024/4/22 15:39
 **/

public class UuidUtil {
    /**
     * 拿到uuid且去掉里面的符号
     *
     * @return String
     */
    public static String getUUID() {
        // 获取当前时间并格式化为指定格式
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String formattedTime = dateFormat.format(new Date());

        // 创建UUID对象
        UUID uniqueId = UUID.randomUUID();

        // 将UUID转换为字符串形式
        String id = formattedTime + "_" + uniqueId.toString().replaceAll("-", "").toUpperCase();
        return id;
    }

    /**
     * 将UUid里面的数字拿出来重新生成新的数字不过目前没什么卵用
     *
     * @param uuid
     * @return Long
     */
    public static Long getnumber(String uuid) {
        String str = uuid.trim();
        System.out.println(str);
        String str2 = "";
        if (str != null && !"".equals(str)) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
                    str2 += str.charAt(i);
                }
            }
            if (str2.length() > 19) {
                String substring = str2.substring(0, (str2.length() - (str2.length() - 19)));
                return Long.valueOf(substring);
            } else {
                return Long.valueOf(str2);
            }
        }
        return Long.valueOf(str2);
    }


    /**
     * list去重
     *
     * @param list
     * @return List
     */
    public static List removeDuplicate(List list) {

        System.out.println(list);
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = list.size() - 1; j > i; j--) {
                if (list.get(j).equals(list.get(i))) {
                    list.remove(j);
                }
            }
        }
        return list;
    }
    /**
     * @Author djj
     * @Description //TODO list去重
     * @Date 16:05 2024/2/2
     * @Param
     * @return
     **/
/*
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);
        list.add(12);
        list.add(1);
        list.add(12);
        list.add(2);
        list.add(2);
        list.add(22);
        list.add(22);
        list.add(23);
        Collections.sort(list);
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list.toString());
       *//* Object collect = list.stream().distinct().collect(Collectors.toList());
        System.out.println(collect.toString());*//*
        Set<String> uniqueSet = new LinkedHashSet<>(list);
        List<String> deduplicatedList = new ArrayList<>(uniqueSet);
        System.out.println(deduplicatedList.toString());
        List<String> myList = Arrays.asList("apple", "banana", "orange", "apple", "banana");
        Set<String> uniqueSet1 = new HashSet<>(myList);
        List<String> deduplicatedList1 = new ArrayList<>(uniqueSet1);
        System.out.println(deduplicatedList1);
    }*/

}


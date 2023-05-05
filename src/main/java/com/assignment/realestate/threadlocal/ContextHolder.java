package com.assignment.realestate.threadlocal;

public class ContextHolder {

    private static final ThreadLocal<Integer> USER_ID = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return Integer.MIN_VALUE;
        }
    };

    public static void setUserId(Integer userId) {
        USER_ID.set(userId);
    }

    public static Integer getUserId() {
        return USER_ID.get();
    }

    public static void removeUserId() {
        USER_ID.remove();
    }
}

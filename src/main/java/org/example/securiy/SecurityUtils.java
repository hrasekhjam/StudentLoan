package org.example.securiy;

import org.example.entity.Students;

public class SecurityUtils {
    private static Students students = null;

    public static Students getStudents() {
        return students;
    }

    public static void setStudents(Students students) {
        SecurityUtils.students = students;
    }

    public static boolean isLogin() {
        return students != null;
    }
}

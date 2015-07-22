package by.intexsoft.reflection;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Admin on 22.07.2015.
 */
public abstract class AbstractPerson implements Comparable {
    Field[] fields = this.getClass().getDeclaredFields();

    @Override
    public String toString() {
        String c = "";
        for (Field f : fields) {
            if (f.isAnnotationPresent(MyAnnotation.class)) {
                f.setAccessible(true);
                try {
                    c += f.get(this) + " ";
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return c;
    }

    @Override
    public int hashCode() {
        int result = 1;
        for (Field f : fields) {
            if (f.isAnnotationPresent(MyAnnotation.class)) {
                int multiplier = f.getAnnotation(MyAnnotation.class).multiply();
                f.setAccessible(true);
                try {
                    result = multiplier * result + f.get(this).hashCode();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (this == null) {
            return false;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        for (Field f : fields) {
            if (f.isAnnotationPresent(MyAnnotation.class)) {
                f.setAccessible(true);
                try {
                    if (f.get(this) != f.get(obj)) {
                        return false;
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    @Override
    public int compareTo(Object o) {
        if (o.getClass() == null) {
            return -1;
        }
        if (o.getClass() != this.getClass()) {
            return -1;
        }

        Arrays.sort(fields, new Comparator<Field>() {
            @Override
            public int compare(Field f1, Field f2) {
                Integer p1 = 0, p2 = 0;
                if (f1.isAnnotationPresent(MyAnnotation.class) && f2.isAnnotationPresent(MyAnnotation.class)) {
                    p1 = f1.getAnnotation(MyAnnotation.class).priority();
                    p2 = f2.getAnnotation(MyAnnotation.class).priority();
                }
                return p1.compareTo(p2);
            }
        });


        for (Field f : fields) {
            try {
                f.setAccessible(true);
                if (f.get(this) instanceof Comparable) {
                    if (((Comparable) f.get(this)).compareTo(f.get(o)) < 0) {
                        return -1;
                    } else if (((Comparable) f.get(this)).compareTo(f.get(o)) > 0) {
                        return 1;
                    }
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                System.out.println(e.getMessage());
            }
        }
        return 0;
    }
}

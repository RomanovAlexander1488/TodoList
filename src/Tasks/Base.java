package Tasks;

import java.util.Objects;

public class Base {
    protected String title;

    public Base(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Base base = (Base) o;
        return Objects.equals(title, base.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    //    @Override
//    public int compareTo(Base other) {
//        return this.title.compareTo(other.title);
//    }
}

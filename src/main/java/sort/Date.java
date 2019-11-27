package sort;

/**
 * typically unsafe to use equals with inheritance
 * (would violate symmetry)
 */
public final class Date implements Comparable<Date> {
    private final int month, day, year;

    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    @Override
    public int compareTo(Date that) {
        if (this.year < that.year) return -1;
        if (this.year > that.year) return +1;
        if (this.month < that.month) return -1;
        if (this.month > that.month) return +1;
        if (this.day < that.day) return -1;
        if (this.day > that.day) return +1;
        return 0;
    }

    /**
     * Symbol Table API
     * @param y must be Object. Why? Experts still debate
     * @return
     */
    public boolean equals(Object y) {
        // optimize for true object equality
        if (y == this) return true;

        // check for null
        if (y == null) return false;

        // objects must be in the same class
        // (religion: getClass() vs. instanceof)
        if (y.getClass() != this.getClass()) return false;

        // cast is guaranteed to succeed
        Date that = (Date) y;

        // check that all significant fields are the same
        if (this.day != that.day) return false;
        if (this.month != that.month) return false;
        if (this.year != that.year) return false;
        return true;
    }
}

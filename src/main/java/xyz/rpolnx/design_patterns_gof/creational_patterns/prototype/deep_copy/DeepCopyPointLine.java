package xyz.rpolnx.design_patterns_gof.creational_patterns.prototype.deep_copy;

class Point {
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point point) {
        this(point.x, point.y);
    }
}

class Line {
    public Point start, end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Line deepCopy() {
        return new Line(new Point(start), new Point(end));
    }
}

class Runner {
    public static void main(String[] args) {
        Point start = new Point(1, 2);
        Point end = new Point(1, 4);

        Line firstLine = new Line(start, end);

        Line secondLine = firstLine.deepCopy();
        secondLine.end = new Point(1, 5);

        assert firstLine.start == secondLine.start;
        assert firstLine.end.x == secondLine.end.y;
        assert firstLine.end.y != secondLine.end.y;
    }
}

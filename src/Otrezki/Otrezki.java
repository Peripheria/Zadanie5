package Otrezki;

class Point
{
    double x,y;

    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    static void displayPoint(Point p)
    {
        System.out.println("(" + p.x + ", " + p.y + ")");
    }
}

class Test
{
    static Point lineLineIntersection(Point A, Point B, Point C, Point D)
    {
        double a1 = B.y - A.y;
        double b1 = A.x - B.x;
        double c1 = a1*(A.x) + b1*(A.y);

        double a2 = D.y - C.y;
        double b2 = C.x - D.x;
        double c2 = a2*(C.x)+ b2*(C.y);

        double determinant = a1*b2 - a2*b1;

        if (determinant == 0)
        {
            return new Point(Double.MAX_VALUE, Double.MAX_VALUE);
        }
        else
        {
            double x = (b2*c1 - b1*c2)/determinant;
            double y = (a1*c2 - a2*c1)/determinant;
            return new Point(x, y);
        }
    }

    public static void main(String args[])
    {
        Point A = new Point(40, 40);
        Point B = new Point(20, 30);
        Point C = new Point(10, 80);
        Point D = new Point(10, 20);

        Point intersection = lineLineIntersection(A, B, C, D);

        if (intersection.x == Double.MAX_VALUE &&
                intersection.y == Double.MAX_VALUE)
        {
            System.out.println("Линии AB и CD параллельны");
        }

        else
        {
            System.out.print("Отрезки пересекаются в точке:");
            Point.displayPoint(intersection);
        }
    }
}

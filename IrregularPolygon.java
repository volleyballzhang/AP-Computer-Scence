import java.awt.geom.*;     // for Point2D.Double
import java.util.ArrayList; // for ArrayList
import gpdraw.*;            // for DrawingTool

public class IrregularPolygon{
   private ArrayList <Point2D.Double> myPolygon;
   private SketchPad paper;
   private DrawingTool pen;
   private Point2D.Double point;
   // constructors
   public IrregularPolygon() {
       myPolygon = new ArrayList <Point2D.Double> ();
       paper = new SketchPad(600, 600);
       pen = new DrawingTool(paper);
   }
   // public methods
   public void add(double x, double y) {
       point = new Point2D.Double(x, y);
       myPolygon.add(point);
   }
   public void draw() {
       pen.up();
       for(int i = 0; i < myPolygon.size(); i++) {
           Point2D point = myPolygon.get(i);
           Point2D point2 = myPolygon.get(i + 1);
           pen.up();
           pen.move(point.getX(), point.getY());
           pen.down();
           pen.move(point2.getX(), point2.getY());
        }
   }
   public double perimeter() {
       double perimeter = 0;
       double s = 0;
       for(int i = 0; i < myPolygon.size(); i++) {
           Point2D point = myPolygon.get(i);
           Point2D point2 = myPolygon.get(i + 1);
           s = Math.sqrt(Math.pow((point2.getX()-point.getX()),2)+Math.pow((point2.getY()-point.getY()),2));
           perimeter += s;
        }
        return perimeter;
   }
   public double area() {
       double a1 = 0;
       double a2 = 0;
       for(int i = 0; i < myPolygon.size(); i++) {
           Point2D point = myPolygon.get(i);
           Point2D point2 = myPolygon.get(i + 1);
           a1 += point.getX() * point2.getY();
           a2 += point.getY() * point2.getX();
        }
       double area = (a1 - a2) / 2;
       return area;
   }
}
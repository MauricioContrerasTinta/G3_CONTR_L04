package Lab04;
import javax.swing.*;
import java.awt.*;

public class PythagorasTree extends JPanel{
    private int profundidad;

    public PythagorasTree(int profundidad){
        this.profundidad=profundidad;
        setPreferredSize(new Dimension(800, 800));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.setColor(Color.RED);

        trazaArbol(g2d, 350, 600, 100, -90, profundidad);
    }

    private void trazaArbol(Graphics2D g, int x, int y, int lado, double angulo, int nivel){
        if(nivel == 0 || lado<2) return;
        int x2 = x + (int) (lado * Math.cos(Math.toRadians(angulo)));
        int y2 = y + (int) (lado * Math.sin(Math.toRadians(angulo)));

        g.drawLine(x, y, x2, y2);

        int nuevoLado = (int) (lado * 0.7);
        trazaArbol(g, x2, y2, nuevoLado, angulo -45, nivel -1);
        trazaArbol(g, x2, y2, nuevoLado, angulo +45, nivel -1);
    }

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Arbol");
        PythagorasTree panel = new PythagorasTree(10);
        ventana.add(panel);
        ventana.setSize(800 , 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
    
}

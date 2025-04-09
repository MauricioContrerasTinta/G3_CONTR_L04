package Lab04;
import javax.swing.JPanel;

public class PythagorasTree extends JPanel{
    private int profundidad;

    public PythagorasTree(int profundidad){
        this.profundidad=profundidad;
        setPreferredSize(new Dimension(800, 800));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
    
}

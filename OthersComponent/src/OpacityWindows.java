import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import com.sun.awt.AWTUtilities;

public class OpacityWindows extends JFrame {
	private JSlider slide = new JSlider();
	public OpacityWindows(){
	this.setTitle("Transparence !");
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setSize(300, 150);
	slide.setMaximum(100);
	slide.setMinimum(0);
	slide.setValue(100);
	slide.setPaintTicks(true);
	slide.setPaintLabels(true);
	slide.setMinorTickSpacing(10);
	slide.setMajorTickSpacing(20);
	slide.addChangeListener(new Changed(this));
	this.getContentPane().add(slide, BorderLayout.CENTER);
	this.setVisible(true);
	AWTUtilities.setWindowOpacity(this, ((float) slide.getValue()) /100.0f);
	}
	public class Changed implements ChangeListener{
	private JFrame frame;
	public Changed(JFrame frame){this.frame = frame;}
	public void stateChanged(ChangeEvent event){
	AWTUtilities.setWindowOpacity(this.frame, ((float)
	slide.getValue()) / 100.0f);
	}
	}
	public static void main(String[] args){
		OpacityWindows ow = new OpacityWindows();
		}
}

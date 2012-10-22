package asidesktop.client;

import java.awt.Color;
import java.awt.TextField;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.Painter;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class InputValidator extends InputVerifier {

	private AsiDesktopGui gui;
	private Color defaultColor;
	
	public InputValidator(AsiDesktopGui gui) {
		this.gui = gui;
		defaultColor = UIManager.getColor("nimbusFocus");
	}

	@Override
	public boolean verify(JComponent input) {
		try {
			double value = Double.parseDouble( ((JTextField) input).getText() );
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	@Override
	public boolean shouldYieldFocus(JComponent input) {
		if( verify(input) ) {
			//Swing doesn't let you change appearance of individual components :/
			//UIManager.put("nimbusFocus", defaultColor);

		} else {
			//UIManager.put("nimbusFocus", UIManager.getColor("nimbusRed"));

		}

		gui.validateFields();
		
		return true;
	}

}

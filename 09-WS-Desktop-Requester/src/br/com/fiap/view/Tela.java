package br.com.fiap.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import br.com.fiap.ws.bo.DisciplinaBOStub;
import br.com.fiap.ws.service.DisciplinaService;

public class Tela {

	protected Shell shell;
	private Text txtNac;
	private Text txtPs;
	private Text txtAm;
	private Text txtMedia;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Tela window = new Tela();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(190, 268);
		shell.setText("SWT Application");
		
		Label lblNac = new Label(shell, SWT.NONE);
		lblNac.setBounds(10, 34, 55, 15);
		lblNac.setText("NAC");
		
		Label lblPs = new Label(shell, SWT.NONE);
		lblPs.setBounds(10, 73, 55, 15);
		lblPs.setText("PS");
		
		Label lblAm = new Label(shell, SWT.NONE);
		lblAm.setBounds(10, 117, 55, 15);
		lblAm.setText("AM");
		
		txtNac = new Text(shell, SWT.BORDER);
		txtNac.setBounds(70, 31, 76, 21);
		
		txtPs = new Text(shell, SWT.BORDER);
		txtPs.setBounds(71, 70, 76, 21);
		
		txtAm = new Text(shell, SWT.BORDER);
		txtAm.setBounds(70, 114, 76, 21);
		
		Button btnCalcular = new Button(shell, SWT.NONE);
		btnCalcular.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Clique do botão
				//Recupera os valores da tela
				float nac = Float.parseFloat(txtNac.getText());
				float am = Float.parseFloat(txtAm.getText());
				float ps = Float.parseFloat(txtPs.getText());
				
				try {
					DisciplinaService service = new DisciplinaService();
					
					float media = service.calcularMedia(am, nac, ps);
					//Exibe a média na tela
					txtMedia.setText(String.valueOf(media));
				}catch(Exception e1) {
					txtMedia.setText(e1.getMessage());
				}
			}
		});
		btnCalcular.setBounds(70, 154, 76, 25);
		btnCalcular.setText("Calcular");
		
		Label lblMdia = new Label(shell, SWT.NONE);
		lblMdia.setBounds(10, 201, 33, 15);
		lblMdia.setText("M\u00E9dia");
		
		txtMedia = new Text(shell, SWT.BORDER);
		txtMedia.setEditable(false);
		txtMedia.setBounds(70, 198, 76, 21);
		
		
		
	}
}

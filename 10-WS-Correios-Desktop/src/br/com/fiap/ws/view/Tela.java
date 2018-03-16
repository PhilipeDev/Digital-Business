package br.com.fiap.ws.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.tempuri.CalcPrecoPrazoWSStub.CServico;

import br.com.fiap.ws.service.CorreiosService;

public class Tela {

	protected Shell shell;
	private Text txtOrigem;
	private Text txtDestino;
	private Text txtPrazo;
	private Text txtDataPrevista;
	private Label lblDataPrevista;

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
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Label lblCepOrigem = new Label(shell, SWT.NONE);
		lblCepOrigem.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblCepOrigem.setBounds(10, 33, 92, 20);
		lblCepOrigem.setText("CEP Origem");
		
		txtOrigem = new Text(shell, SWT.BORDER);
		txtOrigem.setBounds(10, 59, 76, 21);
		
		Label lblCepDestino = new Label(shell, SWT.NONE);
		lblCepDestino.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblCepDestino.setBounds(158, 33, 83, 15);
		lblCepDestino.setText("CEP Destino");
		
		txtDestino = new Text(shell, SWT.BORDER);
		txtDestino.setBounds(158, 59, 76, 21);
		
		Button btnCalcularPrazo = new Button(shell, SWT.NONE);
		btnCalcularPrazo.setBounds(285, 55, 100, 25);
		btnCalcularPrazo.setText("Calcular Prazo");
		
		btnCalcularPrazo.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					try {
						CorreiosService service = new CorreiosService();
						String cepOrigem = txtOrigem.getText();
						String cepDestino = txtDestino.getText();
						CServico c = service.calcularPrazo(cepOrigem, cepDestino);
						txtDataPrevista.setText(c.getDataMaxEntrega());
						txtPrazo.setText(String.valueOf(c.getPrazoEntrega()));
					} catch (Exception e2) {
						txtDataPrevista.setText(e2.getMessage());
					}
				}
			});
		
		txtPrazo = new Text(shell, SWT.BORDER);
		txtPrazo.setBounds(106, 148, 76, 20);
		
		Label lblResultado = new Label(shell, SWT.NONE);
		lblResultado.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblResultado.setBounds(10, 151, 83, 20);
		lblResultado.setText("Prazo em dias");
		
		txtDataPrevista = new Text(shell, SWT.BORDER);
		txtDataPrevista.setBounds(106, 196, 76, 21);
		
		lblDataPrevista = new Label(shell, SWT.NONE);
		lblDataPrevista.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblDataPrevista.setBounds(10, 199, 76, 18);
		lblDataPrevista.setText("Data Prevista");

	}
	
	
}

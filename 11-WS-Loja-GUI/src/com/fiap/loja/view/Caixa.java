package com.fiap.loja.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import com.fiap.loja.bo.EstoqueBOStub.ProdutoTO;
import com.fiap.loja.service.LojaService;

public class Caixa {

	protected Shell shell;
	private Text txtCodigo;
	private Text txtQuantidade;
	private Table tblProdutos;
	private Text txtProduto;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Caixa window = new Caixa();
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
		shell.setSize(450, 422);
		shell.setText("SWT Application");
		
		Label lblCdigoDoProduto = new Label(shell, SWT.NONE);
		lblCdigoDoProduto.setBounds(10, 40, 116, 15);
		lblCdigoDoProduto.setText("C\u00F3digo do produto:");
		
		txtCodigo = new Text(shell, SWT.BORDER);
		txtCodigo.setBounds(132, 37, 76, 21);
		
		Label lblProduto = new Label(shell, SWT.NONE);
		lblProduto.setBounds(58, 74, 55, 15);
		lblProduto.setText("Produto:");
		
		txtQuantidade = new Text(shell, SWT.BORDER);
		txtQuantidade.setBounds(132, 111, 76, 21);
		
		Label lblQuantidade = new Label(shell, SWT.NONE);
		lblQuantidade.setBounds(46, 114, 67, 18);
		lblQuantidade.setText("Quantidade:");
		
		Button btnPesquisar = new Button(shell, SWT.NONE);
		btnPesquisar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				try {
					LojaService service = new LojaService();
					int cdProduto = Integer.parseInt(txtCodigo.getText());
					
					ProdutoTO to = new ProdutoTO();
					
					to = service.consultarProduto(cdProduto);
					
					txtProduto.setText(to.getNome());
					
				} catch (Exception e2) {
					System.err.println(e2.getMessage());
				}
			}
		});
		btnPesquisar.setBounds(282, 36, 75, 25);
		btnPesquisar.setText("Pesquisar");
		
		Button btnConfirmarCompra = new Button(shell, SWT.NONE);
		btnConfirmarCompra.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				TableItem item = new TableItem(tblProdutos, 0);
				item.setText(new String [] {String.valueOf(txtCodigo.getText()),txtProduto.getText(),txtQuantidade.getText()});
			}
		});
		btnConfirmarCompra.setBounds(22, 162, 116, 25);
		btnConfirmarCompra.setText("Confirmar Compra");
		
		Button btnEncerrarAplicao = new Button(shell, SWT.NONE);
		btnEncerrarAplicao.setBounds(144, 162, 123, 25);
		btnEncerrarAplicao.setText("Encerrar Aplica\u00E7\u00E3o");
		
		tblProdutos = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		tblProdutos.setBounds(22, 194, 374, 179);
		tblProdutos.setHeaderVisible(true);
		tblProdutos.setLinesVisible(true);
		
		TableColumn tblclmnCdigo = new TableColumn(tblProdutos, SWT.NONE);
		tblclmnCdigo.setWidth(100);
		tblclmnCdigo.setText("C\u00F3digo");
		
		TableColumn tblclmnNomeDoProduto = new TableColumn(tblProdutos, SWT.NONE);
		tblclmnNomeDoProduto.setWidth(162);
		tblclmnNomeDoProduto.setText("Nome do Produto");
		
		TableColumn tblclmnQuantidade = new TableColumn(tblProdutos, SWT.NONE);
		tblclmnQuantidade.setWidth(100);
		tblclmnQuantidade.setText("Quantidade");
		
		txtProduto = new Text(shell, SWT.BORDER);
		txtProduto.setEditable(false);
		txtProduto.setBounds(132, 74, 225, 21);

	}
}

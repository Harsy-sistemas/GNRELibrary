package br.com.gnre.java;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.xml.rpc.ServiceException;

import org.apache.axis.types.UnsignedByte;

import guiasgnre.webgnre.GeraGuiaGnreLocator;
import guiasgnre.webgnre.GeraGuiaGnreSoapBindingStub;
import guiasgnre.webgnre.GeraGuiaGnreSoapType;
import guiasgnre.webgnre.TAssinatura;
import guiasgnre.webgnre.TDadosNfe;
import guiasgnre.webgnre.TGuias;
import guiasgnre.webgnre.TListaGuias;
import guiasgnre.webgnre.TListaNfe;
import guiasgnre.webgnre.TPdfGuias;
import guiasgnre.webgnre.TReciboNota;
import guiasgnre.webgnre.TRecibos;
import guiasgnre.webgnre.TRetornoAssinatura;
import guiasgnre.webgnre.TRetornoLote;
import guiasgnre.webgnre.TRetornoLotePDF;

import java.math.BigDecimal;
import java.math.*;
import javax.swing.JTextPane;
import javax.swing.UIManager;

import static java.nio.file.StandardOpenOption.*;

import java.nio.file.*;
import java.io.*;

import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField; 

public class AppGnre {
	
	TRetornoLote retornoLote = new TRetornoLote();
	TRetornoLotePDF retornoLotePdf = new TRetornoLotePDF();
	TListaGuias listaGuias = new TListaGuias();
	
	private JFrame frame;
	private JTextField textFieldUsuario;
	private JTextField textFieldCnpj;
	private JTextField textFieldTokenApi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppGnre window = new AppGnre();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppGnre() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setAlwaysOnTop(true);
		frame.setBackground(SystemColor.control);
		frame.setBounds(100, 100, 509, 341);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnGeraGuia = new JButton("Gera Guia");
		btnGeraGuia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				TDadosNfe[] tDadosNotas;
				tDadosNotas = new TDadosNfe[1];
				tDadosNotas[0] = new TDadosNfe();
				tDadosNotas[0].setEmitente(textFieldCnpj.getText());
				tDadosNotas[0].setSerie("000");
				tDadosNotas[0].setModelo("55");
				tDadosNotas[0].setNum_nota_fiscal(new BigDecimal(1577));
				tDadosNotas[0].setTipo_documento("10");
				tDadosNotas[0].setChave_nfe("35160509141415000150550000000015771000015775");
				tDadosNotas[0].setConvenio("");
				tDadosNotas[0].setData_emissao("2016-05-25");
				tDadosNotas[0].setProduto("");
				tDadosNotas[0].setVencimento("2016-06-25");
				tDadosNotas[0].setValor(new BigDecimal(101.02));
				tDadosNotas[0].setIcms_uf_destino(new BigDecimal(2.0));
				tDadosNotas[0].setFcp_uf_destino(new BigDecimal(0.0));
				tDadosNotas[0].setCpf("10618969861");
				tDadosNotas[0].setCnpj("");
				tDadosNotas[0].setNome_destinatario("NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL");
				tDadosNotas[0].setMunicipio_destinatario("PORTO ALEGRE");
				tDadosNotas[0].setCod_municipio_destinat("14902");
				tDadosNotas[0].setUf_destinatario("RS");
				tDadosNotas[0].setIcms_st(new BigDecimal(0.0));
				tDadosNotas[0].setData_recepcao("");
								
				TListaNfe tListaNotas = new TListaNfe();
				tListaNotas.setItens(tDadosNotas);
				
				GeraGuiaGnreLocator locator = new GeraGuiaGnreLocator();
				GeraGuiaGnreSoapType geraGuia = null;
				try {
					geraGuia = locator.getGeraGuiaGnreSoap();
				} catch (ServiceException e2) {
					e2.printStackTrace();
				}
				
				try {
					retornoLote = geraGuia.geraGuia(textFieldCnpj.getText(), textFieldUsuario.getText(), textFieldTokenApi.getText(), tListaNotas);
					JOptionPane.showMessageDialog(null,("# do Lote: " + retornoLote.getLote() + "\nCód. Retorno: " + retornoLote.getRetorno() + "\nMensagem de retorno: " + retornoLote.getMsg_retorno() + "\nPróximo passo (exceto se o retorno foi '1', falha de login): Clique em 'Busca Guia', para ver o status \nda guia que acabou de gerar, ou clique em 'Busca Guia PDF',\npara buscar a guia e trazer o PDF dela pronto para ser impresso/pago."));
					
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}
		});
		frame.getContentPane().setLayout(new MigLayout("", "[232.00px,grow][][232.00,grow]", "[23px][23px][23px][23px][][12.00px][23px][23px][23px][23px][23px]"));
		
		JTextPane txtpnNomeDeUsurio = new JTextPane();
		txtpnNomeDeUsurio.setEditable(false);
		txtpnNomeDeUsurio.setBackground(UIManager.getColor("Button.background"));
		txtpnNomeDeUsurio.setText("Nome de usu\u00E1rio cadastrado no portal:");
		frame.getContentPane().add(txtpnNomeDeUsurio, "flowx,cell 0 0,growx");
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setColumns(10);
		frame.getContentPane().add(textFieldUsuario, "flowx,cell 0 1,growx");
		
		JTextPane txtpnTokenApi = new JTextPane();
		txtpnTokenApi.setEditable(false);
		txtpnTokenApi.setText("Token API:");
		txtpnTokenApi.setBackground(SystemColor.menu);
		frame.getContentPane().add(txtpnTokenApi, "flowx,cell 0 2,growx");
		
		textFieldTokenApi = new JTextField();
		textFieldTokenApi.setColumns(10);
		frame.getContentPane().add(textFieldTokenApi, "flowx,cell 0 3,growx");
		
		textFieldCnpj = new JTextField();
		textFieldCnpj.setColumns(10);
		frame.getContentPane().add(textFieldCnpj, "flowx,cell 2 1,growx");
		
		JTextPane txtpnCnpjDaEmpresa = new JTextPane();
		txtpnCnpjDaEmpresa.setEditable(false);
		txtpnCnpjDaEmpresa.setText("CNPJ da Empresa (somente n\u00FAmeros):");
		txtpnCnpjDaEmpresa.setBackground(SystemColor.menu);
		frame.getContentPane().add(txtpnCnpjDaEmpresa, "flowx,cell 2 0,growx");
		
		JTextPane textPane = new JTextPane();
		textPane.setText("Retornos exibidos na tela:");
		textPane.setEditable(false);
		textPane.setBackground(SystemColor.menu);
		frame.getContentPane().add(textPane, "cell 0 5,grow");
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setText("Retornos em arquivos PDF:");
		textPane_1.setEditable(false);
		textPane_1.setBackground(SystemColor.menu);
		frame.getContentPane().add(textPane_1, "cell 2 5,grow");
		frame.getContentPane().add(btnGeraGuia, "cell 0 6,growx,aligny top");
		
		JButton btnBuscaGuia = new JButton("Busca Guia");
		btnBuscaGuia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GeraGuiaGnreLocator locator = new GeraGuiaGnreLocator();
				GeraGuiaGnreSoapType geraGuia = null;
				try {
					geraGuia = locator.getGeraGuiaGnreSoap();
				} catch (ServiceException e2) {
					e2.printStackTrace();
				}
				
				try {
					listaGuias = geraGuia.buscaGuia(textFieldCnpj.getText(), textFieldUsuario.getText(), textFieldTokenApi.getText(), retornoLote);
					TGuias[] guias = listaGuias.getGuias();
					JOptionPane.showMessageDialog(null,("# da Nota: " + guias[0].getNum_nota_fiscal() + "\nRecibo: " + guias[0].getRecibo() + "\nStatus: " + guias[0].getStatus() + "\nSe o status for 'Aguardando', ou 'Erro', clique em um dos botões abaixo para ver se o problema é resolvido."));
					
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}				
			}
		});
		
		JButton btnGeraGuiaPdf = new JButton("Gera Guia PDF");
		btnGeraGuiaPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TDadosNfe[] tDadosNotas;
				tDadosNotas = new TDadosNfe[1];
				tDadosNotas[0] = new TDadosNfe();
				tDadosNotas[0].setEmitente(textFieldCnpj.getText());
				tDadosNotas[0].setSerie("000");
				tDadosNotas[0].setModelo("55");
				tDadosNotas[0].setNum_nota_fiscal(new BigDecimal(1577));
				tDadosNotas[0].setTipo_documento("10");
				tDadosNotas[0].setChave_nfe("35160509141415000150550000000015771000015775");
				tDadosNotas[0].setConvenio("");
				tDadosNotas[0].setData_emissao("2016-05-25");
				tDadosNotas[0].setProduto("");
				tDadosNotas[0].setVencimento("2016-06-25");
				tDadosNotas[0].setValor(new BigDecimal(101.02));
				tDadosNotas[0].setIcms_uf_destino(new BigDecimal(4.52));
				tDadosNotas[0].setFcp_uf_destino(new BigDecimal(1.49));
				tDadosNotas[0].setCpf("10618969861");
				tDadosNotas[0].setCnpj("");
				tDadosNotas[0].setNome_destinatario("NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL");
				tDadosNotas[0].setMunicipio_destinatario("PORTO ALEGRE");
				tDadosNotas[0].setCod_municipio_destinat("14902");
				tDadosNotas[0].setUf_destinatario("RS");
				tDadosNotas[0].setIcms_st(new BigDecimal(0.0));
				tDadosNotas[0].setData_recepcao("");
								
				TListaNfe tListaNotas = new TListaNfe();
				tListaNotas.setItens(tDadosNotas);
								
				GeraGuiaGnreLocator locator = new GeraGuiaGnreLocator();
				GeraGuiaGnreSoapType geraGuia = null;
				try {
					geraGuia = locator.getGeraGuiaGnreSoap();
				} catch (ServiceException e2) {
					e2.printStackTrace();
				}
				
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
					Date now = new Date();
				    Path p = Paths.get("./GuiasGNRE_" + (sdf.format(now)) + ".pdf");
				    
					retornoLotePdf = geraGuia.geraGuiaPDF(textFieldCnpj.getText(), textFieldUsuario.getText(), textFieldTokenApi.getText(), tListaNotas);
					JOptionPane.showMessageDialog(null,("# do Lote: " + retornoLotePdf.getLote() + "\nCód. Retorno: " + retornoLotePdf.getRetorno() + "\nMensagem de retorno: " + retornoLotePdf.getMsg_retorno() + "\nArquivo gerado (apenas se o retorno foi 'Sucesso'): " + p + "."));					
					
				    UnsignedByte[] pdf = retornoLotePdf.getPdf_guias()[0].getPdf();
				    int len = pdf.length;
				    				    
				    byte[] pdfArr = new byte[len];
				    int iCount=0;
			    					    
				    for (UnsignedByte item : pdf){
				    	pdfArr[iCount] = (item.byteValue());
				    	iCount++;
				    }
				    
				    try (OutputStream out = new BufferedOutputStream(
		    	      Files.newOutputStream(p, CREATE, APPEND))) {
		    	      out.write(pdfArr, 0, len);
		    	    } catch (IOException x) {
		    	      System.err.println(x);
		    	    }
				    
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnGeraGuiaPdf, "cell 2 6,growx");
		frame.getContentPane().add(btnBuscaGuia, "cell 0 7,growx,aligny top");
		
		JButton btnBuscaTodasPendentes = new JButton("Busca Todas Guias Pendentes");
		btnBuscaTodasPendentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {								
				GeraGuiaGnreLocator locator = new GeraGuiaGnreLocator();
				GeraGuiaGnreSoapType geraGuia = null;
				
				try {
					geraGuia = locator.getGeraGuiaGnreSoap();
				} catch (ServiceException e2) {
					e2.printStackTrace();
				}
				
				String dataInicial = JOptionPane.showInputDialog("Digite a data inicial da busca por guias pendentes \n(Padrão: AAAA-MM-DD. Ex: 2016-06-01)\nSe não informado, buscará todas as guias \ndesde a sua primeira guia gerada no portal:");
				String dataFinal = JOptionPane.showInputDialog("Digite a data final da busca por guias pendentes \n(Padrão: AAAA-MM-DD. Ex: 2016-06-01)\nSe não informado, buscará todas as guias \ndesde a data inicial informada, até hoje:");
				
				try {
					listaGuias = geraGuia.buscaTodasGuiasPendentes(textFieldCnpj.getText(), textFieldUsuario.getText(), textFieldTokenApi.getText(), dataInicial, dataFinal);
					JOptionPane.showMessageDialog(null,("Status: " + listaGuias.getRetorno() + "\nMensagem: " + listaGuias.getMsg_retorno()));
					TGuias[] guias = listaGuias.getGuias();					
					for (int i=0; i < guias.length; i++) {
						JOptionPane.showMessageDialog(null,("# da Nota: " + guias[i].getNum_nota_fiscal() + "\nRecibo: " + guias[i].getRecibo() + "\nStatus: " + guias[i].getStatus()));
					}
					
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}	
			}
		});
		
		JButton btnBuscaGuiaPendentes = new JButton("Busca Guias Pendentes");
		btnBuscaGuiaPendentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int iLen = retornoLote.getRecibos().length;
				int iCount = 0; 
				
				String[] arRecibos = new String[iLen];
				
				TReciboNota[] recibos;
				recibos = new TReciboNota[iLen];
				
				TRecibos guiasPendentes;
				guiasPendentes = new TRecibos();
				
				GeraGuiaGnreLocator locator = new GeraGuiaGnreLocator();
				GeraGuiaGnreSoapType geraGuia = null;
				try {
					geraGuia = locator.getGeraGuiaGnreSoap();
				} catch (ServiceException e2) {
					e2.printStackTrace();
				}
				
				recibos = retornoLote.getRecibos();
				
				for (TReciboNota item : recibos) {
					if (item.getStatus() != "Autorizado") {
						arRecibos[iCount] = (item.getRecibo());
						iCount++;
					}
				}
				
				guiasPendentes.setEmitente(recibos[0].getEmitente());
				guiasPendentes.setRecibo(arRecibos);
				
				try {
					listaGuias = geraGuia.buscaGuiasPendentes(textFieldCnpj.getText(), textFieldUsuario.getText(), textFieldTokenApi.getText(), guiasPendentes);
					TGuias[] guias = listaGuias.getGuias();
					
					for (int i=0; i < guias.length; i++) {
						JOptionPane.showMessageDialog(null,("# da Nota: " + guias[i].getNum_nota_fiscal() + "\nRecibo: " + guias[i].getRecibo() + "\nStatus: " + guias[i].getStatus()));
					}					
					
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}		
			}
		});
		
		JButton btnBuscaGuiaPdf = new JButton("Busca Guia PDF");
		btnBuscaGuiaPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GeraGuiaGnreLocator locator = new GeraGuiaGnreLocator();
				GeraGuiaGnreSoapType geraGuia = null;
				try {
					geraGuia = locator.getGeraGuiaGnreSoap();
				} catch (ServiceException e2) {
					e2.printStackTrace();
				}
								
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
					Date now = new Date();
				    Path p = Paths.get("./GuiasGNRE_" + (sdf.format(now)) + ".pdf");
				    
					retornoLotePdf = geraGuia.buscaGuiaPDF(textFieldCnpj.getText(), textFieldUsuario.getText(), textFieldTokenApi.getText(), retornoLote);
					JOptionPane.showMessageDialog(null,("# do Lote: " + retornoLotePdf.getLote() + "\nCód. Retorno: " + retornoLotePdf.getRetorno() + "\nMensagem de retorno: " + retornoLotePdf.getMsg_retorno() + "\nArquivo gerado (apenas se o retorno foi 'Sucesso'): " + p + "."));
					
				    UnsignedByte[] pdf = retornoLotePdf.getPdf_guias()[0].getPdf();
				    int len = pdf.length;
				    				    
				    byte[] pdfArr = new byte[len];
				    int iCount=0;
			    					    
				    for (UnsignedByte item : pdf){
				    	pdfArr[iCount] = (item.byteValue());
				    	iCount++;
				    }
				    
				    try (OutputStream out = new BufferedOutputStream(
		    	      Files.newOutputStream(p, CREATE, APPEND))) {
		    	      out.write(pdfArr, 0, len);
		    	    } catch (IOException x) {
		    	      System.err.println(x);
		    	    }
				    
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnBuscaGuiaPdf, "cell 2 7,growx");
		frame.getContentPane().add(btnBuscaGuiaPendentes, "cell 0 8,growx,aligny top");
		frame.getContentPane().add(btnBuscaTodasPendentes, "cell 0 9,growx,aligny top");
		
		JButton btnBuscaTodasComErro = new JButton("Busca Todas Guias com Erro");
		btnBuscaTodasComErro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GeraGuiaGnreLocator locator = new GeraGuiaGnreLocator();
				GeraGuiaGnreSoapType geraGuia = null;
				
				try {
					geraGuia = locator.getGeraGuiaGnreSoap();
				} catch (ServiceException e2) {
					e2.printStackTrace();
				}
				
				String dataInicial = JOptionPane.showInputDialog("Digite a data inicial da busca por guias pendentes \n(Padrão: AAAA-MM-DD. Ex: 2016-06-01)\nSe não informado, buscará todas as guias \ndesde a sua primeira guia gerada no portal:");
				String dataFinal = JOptionPane.showInputDialog("Digite a data final da busca por guias pendentes \n(Padrão: AAAA-MM-DD. Ex: 2016-06-01)\nSe não informado, buscará todas as guias \ndesde a data inicial informada, até hoje:");
				
				try {
					listaGuias = geraGuia.buscaTodasGuiasComErro(textFieldCnpj.getText(), textFieldUsuario.getText(), textFieldTokenApi.getText(), dataInicial, dataFinal);
					JOptionPane.showMessageDialog(null,("Status: " + listaGuias.getRetorno() + "\nMensagem: " + listaGuias.getMsg_retorno()));
					TGuias[] guias = listaGuias.getGuias();					
					for (int i=0; i < guias.length; i++) {
						JOptionPane.showMessageDialog(null,("# da Nota: " + guias[i].getNum_nota_fiscal() + "\nRecibo: " + guias[i].getRecibo() + "\nStatus: " + guias[i].getStatus()));
					}
					
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}	
			}
		});
		frame.getContentPane().add(btnBuscaTodasComErro, "cell 0 10,growx,aligny top");

	}
}

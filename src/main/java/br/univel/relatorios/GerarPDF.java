package br.univel.relatorios;

import java.awt.Desktop;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.swing.table.TableModel;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;

public class GerarPDF {

	private String tipo;

	private String arq = "C:\\Users\\user\\git\\TrabalhoBimestral\\src\\main\\resources\\";
	private String salvarLocal = "C:\\Users\\user\\git\\TrabalhoBimestral\\src\\main\\resources\\";

	public GerarPDF(String tipo, TableModel tbModel) {
		this.tipo = tipo;
		this.arq = caminhoArq(tipo);
		GerarPdf(nomeRelatorio(tipo), tbModel);
	}

	private void GerarPdf(String out_pdf, TableModel tbModel) {
		JasperPrint jp = null;
		try {
			Map<String, Object> map = new HashMap<>();
			if (this.tipo.equals("Clientes")) {
				map.put("enderecop", "Rua Rio Oiapoque, 269");
				map.put("telefonep", "45 - 2121-2121");
			} else {
				map.put("endereco", "Rua bagual, 1");
				map.put("telefone", "45 - 4545-4545");
			}

			jp = JasperFillManager.fillReport(arq, map, new JRTableModelDataSource(tbModel));

			JasperExportManager.exportReportToPdfFile(jp, this.salvarLocal + out_pdf);

			Desktop.getDesktop().open(new File(this.salvarLocal + out_pdf));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String nomeRelatorio(String tipo) {
		StringBuilder nome = new StringBuilder();
		SimpleDateFormat frm = new SimpleDateFormat("ddMMyyyy");
		nome.append(tipo + "-" + frm.format(new java.util.Date()) + "-");

		Calendar hora = Calendar.getInstance();
		return nome.append(String.format("%1$tH-%tM-%1$tS", hora) + ".fdf").toString();
	}

	private String caminhoArq(String tipo) {
		if (tipo.equals("Clientes"))
			return this.arq = this.arq + "RelatorioClientes.jasper";
		else if (tipo.equals("Produtos"))
			return this.arq = this.arq + "RelatorioProdutos.jasper";
		else if (tipo.equals("Vendas"))
			return this.arq = this.arq + "RelatorioVendas.jasper";
		return "NoExisteTipo";
	}
}
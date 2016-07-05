/**
 * GeraGuiaGnre.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package guiasgnre.webgnre;

public interface GeraGuiaGnre extends javax.xml.rpc.Service {

/**
 * O portal GuiasGNRE.com.br oferece a possibilidade de gerar suas
 * guias de recolhimento de tributos estaduais para todos os Estados
 * que disponibilizaram portais para emissão e validação das guias. Através
 * do portal GuiasGNRE.com.br você gera em um só lugar suas guias DIFAL,
 * FCOP e ICMS ST de forma rápida, e prática, através das informações
 * contidas nos XML's de suas notas fiscais.Lista de códigos de retorno
 * para as funções chamadas: 0 = Sucesso | 1 = Não autorizado, Verifique
 * o CNPJ, Usuário e Token. | 2 = Lote processado com pendências. | 3
 * = Nenhuma guia liberada no momento. | 4 = Falha ao buscar guias. |
 * 5 = Falha ao gerar o PDF. | 6 = Data inicial inválida. Padrão esperado:
 * AAAA-MM-DD. | 7 = Data final inválida. Padrão esperado: AAAA-MM-DD.
 */
    public java.lang.String getGeraGuiaGnreSoapAddress();

    public guiasgnre.webgnre.GeraGuiaGnreSoapType getGeraGuiaGnreSoap() throws javax.xml.rpc.ServiceException;

    public guiasgnre.webgnre.GeraGuiaGnreSoapType getGeraGuiaGnreSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}

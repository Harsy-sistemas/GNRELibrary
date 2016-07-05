/**
 * GeraGuiaGnreSoapType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package guiasgnre.webgnre;

public interface GeraGuiaGnreSoapType extends java.rmi.Remote {

    /**
     * Função de Envio dos Dados da NFe para o webservice para geração
     * das guias. Esta função recebe uma ou mais notas e retorna uma lista
     * com informações das guias das respectivas notas, para que sejam usadas
     * e impressas em um gerador de relatórios de sua preferência. Lista
     * de códigos de retorno: 0 = Sucesso | 1 = Não autorizado. Verifique
     * o CNPJ, Usuário e Token. | 2 = Lote processado com pendências. | 3
     * = Nenhuma guia liberada no momento.
     */
    public guiasgnre.webgnre.TRetornoLote geraGuia(java.lang.String sEmpresa, java.lang.String sUsuario, java.lang.String sChaveApi, guiasgnre.webgnre.TListaNfe listaNfe) throws java.rmi.RemoteException;

    /**
     * Função de Envio dos Dados da NFe para o webservice para geração
     * das guias, porém já retornando o PDF das guias pronto para ser salvo
     * e/ou impresso após a recepção do arquivo. Lista de códigos de retorno:
     * 0 = Sucesso | 1 = Não autorizado, Verifique o CNPJ, Usuário e Token.
     * | 2 = Lote processado com pendências. | 3 = Nenhuma guia liberada
     * no momento. | 4 = Falha ao buscar guias. | 5 = Falha ao gerar o PDF.
     */
    public guiasgnre.webgnre.TRetornoLotePDF geraGuiaPDF(java.lang.String sEmpresa, java.lang.String sUsuario, java.lang.String sChaveApi, guiasgnre.webgnre.TListaNfe listaNfe) throws java.rmi.RemoteException;

    /**
     * Busca Guias que ficaram pendentes, com status de 'Transmitida'
     * ou 'Aguardando', e não foram retornadas no momento do envio do lote
     * das notas, pois estavam em processamento pela SEFAZ de destino. Esta
     * função recebe um ou mais recibos das guias desejadas e retorna uma
     * lista com informações das guias dos respectivos recibos, para que
     * sejam usadas e impressas em um gerador de relatórios de sua preferência.
     * Lista de códigos de retorno: 0 = Sucesso | 1 = Não autorizado. Verifique
     * o CNPJ, Usuário e Token. | 2 = Lote processado com pendências. | 3
     * = Nenhuma guia liberada no momento.
     */
    public guiasgnre.webgnre.TListaGuias buscaGuiasPendentes(java.lang.String sEmpresa, java.lang.String sUsuario, java.lang.String sChaveApi, guiasgnre.webgnre.TRecibos guiasPendentes) throws java.rmi.RemoteException;

    /**
     * Busca todas as guias que estão pendentes, com status 'Trasmitida'
     * ou 'Aguardando', exceto aquelas com status 'Erro', e não foram retornadas
     * no momento do envio do lote das notas. Se informado data de inicio
     * e fim da emissão da nota, filtra apenas guias nesse intervalo de tempo.
     * Se informado apenas data de início, filtra todas a partir desta data.
     * Se informado apenas data final, filtra todas as guias até esta data.
     * Se não informar nenhuma data, retorna todas as guias com status 'Transmitida'
     * ou 'Aguardando'. Lista de códigos de retorno: 0 = Sucesso | 1 = Não
     * autorizado. Verifique o CNPJ, Usuário e Token. | 2 = Lote processado
     * com pendências. | 3 = Nenhuma guia liberada no momento. | 6 = Data
     * inicial inválida. Padrão esperado: AAAA-MM-DD. | 7 = Data final inválida.
     * Padrão esperado: AAAA-MM-DD.
     */
    public guiasgnre.webgnre.TListaGuias buscaTodasGuiasPendentes(java.lang.String sEmpresa, java.lang.String sUsuario, java.lang.String sChaveApi, java.lang.String sDataInicio, java.lang.String sDataFim) throws java.rmi.RemoteException;

    /**
     * Busca todas as guias que estão com erro, com status 'Erro',
     * exceto aquelas com status 'Transmitida' ou 'Aguardando', e não foram
     * retornadas no momento do envio do lote das notas. Se informado data
     * de inicio e fim da emissão da nota, filtra apenas guias nesse intervalo
     * de tempo. Se informado apenas data de início, filtra todas a partir
     * desta data. Se informado apenas data final, filtra todas as guias
     * até esta data. Se não informar nenhuma data, retorna todas as guias
     * com status 'Transmitida' ou 'Aguardando'. Lista de códigos de retorno:
     * 0 = Sucesso | 1 = Não autorizado. Verifique o CNPJ, Usuário e Token.
     * | 2 = Lote processado com pendências. | 3 = Nenhuma guia liberada
     * no momento. | 6 = Data inicial inválida. Padrão esperado: AAAA-MM-DD.
     * | 7 = Data final inválida. Padrão esperado: AAAA-MM-DD.
     */
    public guiasgnre.webgnre.TListaGuias buscaTodasGuiasComErro(java.lang.String sEmpresa, java.lang.String sUsuario, java.lang.String sChaveApi, java.lang.String sDataInicio, java.lang.String sDataFim) throws java.rmi.RemoteException;

    /**
     * Busca Guia(s) específica(s) através do CNPJ do emitente e do
     * número do recibo (que pode ser mais de um), independente do status
     * da guia. Lista de Erros: 0 = Sucesso | 1 = Não autorizado, Verifique
     * o CNPJ, Usuário e Token. | 2 = Lote processado com pendências. | 3
     * = Nenhuma guia liberada no momento.
     */
    public guiasgnre.webgnre.TListaGuias buscaGuia(java.lang.String sEmpresa, java.lang.String sUsuario, java.lang.String sChaveApi, guiasgnre.webgnre.TRetornoLote lote) throws java.rmi.RemoteException;

    /**
     * Busca Guia(s) específica(s) através do CNPJ do emitente e do
     * número do recibo (que pode ser mais de um), independente do status
     * da guia. Lista de códigos de retorno: 0 = Sucesso | 1 = Não autorizado,
     * Verifique o CNPJ, Usuário e Token. | 2 = Lote processado com pendências.
     * | 3 = Erro ao transmitir o lote de guias. | 4 = Falha ao buscar guias.
     * | 5 = Falha ao gerar o PDF.
     */
    public guiasgnre.webgnre.TRetornoLotePDF buscaGuiaPDF(java.lang.String sEmpresa, java.lang.String sUsuario, java.lang.String sChaveApi, guiasgnre.webgnre.TRetornoLote lote) throws java.rmi.RemoteException;

    /**
     * Assinatura Grátis é utilizado para criar o cadastro do utilizador
     * do serviço. Tabela de erros: 0 = Sucesso | 1 = Login não é um e-mail
     * válido. | 2 = Login em uso, tente outro. | 3 = Senha deve estar entre
     * 6 e 10 dígitos. | 4 = Razão Social não pode estar em branco. | 5 =
     * Fantasia não pode estar em branco. | 6 = Telefone deve estar entre
     * 10 e 11 dígitos. | 7 = Cep deve conter 8 dígitos. | 8 = Logradouro
     * não pode estar em branco. | 9 = Nro não pode ficar em branco, caso
     * nao tenha número no endereço, preencher com S/N. | 10 = Bairro não
     * pode estar em branco. | 11 = Código da UF é inválido. | 12 = Código
     * do Município é inválido. | 13 = Telefone contém digítos não numéricos.
     * | 14 = CEP contém digítos não numéricos. | 15 = CNPJ é inválido. |
     * 16 = CNPJ em uso por outra assinatura. | 17 = Nome do responsável
     * pela assinatura não pode estar em branco. | 18 = Erro ao gravar a
     * conta do usuário. | 19 = Erro ao gravar os dados da empresa. | 20
     * = Erro ao criar a assinatura na forma de pagamento grátis.
     */
    public guiasgnre.webgnre.TRetornoAssinatura assinatura_gratis(guiasgnre.webgnre.TAssinatura assinatura) throws java.rmi.RemoteException;
}
